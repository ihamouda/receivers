package com.procuredox.receivers.cat;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.procuredox.receivers.*;
import com.procuredox.receivers.cat.cXML.CXML;
import com.procuredox.receivers.cat.cXML.PostalAddress;
import com.procuredox.receivers.cat.responsemessage.OrderType;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.generic.NumberTool;
import org.dom4j.DocumentException;
import org.glassfish.jersey.internal.util.Base64;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by ihamouda on 2017-06-25.
 */
public class OrderMessage {
    private static final Logger logger = Logger.getLogger(OrderMessage.class);

    private AppResources rb = AppResources.getInstance();
    final Utils utils = Utils.getInstance();
    private final String BATCHPATH = rb.getRb().getString("root")+"data/biztalk/Share/Attachments/";
    private SendEmail email = SendEmail.getInstance();

    public Response receiveOrderMessage(String cxml){
        try {
            final byte[] decodedBytes = Base64.decode(cxml.getBytes());
            //logger.info(new String(decodedBytes));
            Integer batchNumber = utils.getBatchNumber();
            FileUtils.writeByteArrayToFile(
                    new File(BATCHPATH+batchNumber.toString()+"/cat_order.xml"), decodedBytes);
            String cXml = new String(decodedBytes, StandardCharsets.UTF_8);
            cXml = cXml.replaceAll("<!DOCTYPE.*cXML.dtd\">", "");
            SimpleDateFormat formatIn = new SimpleDateFormat("yyyy-MM-dd");
            final Unmarshaller unmarshaller = JAXBContext.newInstance(CXML.class).createUnmarshaller();
            InputStream is = new ByteArrayInputStream(cXml.getBytes());
            CXML cxmIn = (CXML)unmarshaller.unmarshal(is);
            com.procuredox.receivers.cat.cXML.PunchOutOrderMessage message = (com.procuredox.receivers.cat.cXML.PunchOutOrderMessage)cxmIn.getHeaderOrMessageOrRequestOrResponse().get(0);
            Order order = new Order();
            PostalAddress postalAddress = message.getPunchOutOrderMessageHeader().getShipTo().getAddress().getPostalAddress();
            com.procuredox.receivers.cat.Address address = new com.procuredox.receivers.cat.Address();
            address.setStreet(postalAddress.getStreet().get(0).getvalue());
            address.setCity(postalAddress.getCity().getvalue());
            address.setCountry(postalAddress.getCountry().getvalue());
            address.setProvince(postalAddress.getState().getvalue());
            address.setPostalCode(postalAddress.getPostalCode());
            ShipTo shipTo = new ShipTo();
            shipTo.setAddress(address);
            shipTo.setShipToName(message.getPunchOutOrderMessageHeader().getShipTo().getAddress().getName().getvalue());
            shipTo.setPaymentInstructions(message.getPunchOutOrderMessageHeader().getShipTo().getIdReference().
                    stream().filter(e ->e.getDomain().equals("shipInstr")).collect(Collectors.toList()).get(0).getDescription().getvalue().trim());
            shipTo.setDeliveryLocation(message.getPunchOutOrderMessageHeader().getShipTo().getIdReference().
                    stream().filter(e -> e.getDomain().equals("deliveryLocation")).collect(Collectors.toList()).get(0).getDescription().getvalue().trim());
            shipTo.setAccountName(message.getPunchOutOrderMessageHeader().getShipTo().getIdReference()
                    .stream().filter(e->e.getDomain().equals("accountNum")).collect(Collectors.toList()).get(0)
                    .getDescription().getvalue().trim());
            shipTo.setAccountNum(message.getPunchOutOrderMessageHeader().getShipTo().getIdReference()
                    .stream().filter(e->e.getDomain().equals("accountNum")).collect(Collectors.toList()).get(0)
                    .getIdentifier().trim());
            shipTo.setShipVia(message.getPunchOutOrderMessageHeader().getShipTo().getIdReference()
                    .stream().filter(e->e.getDomain().equals("shipVia")).collect(Collectors.toList()).get(0)
                    .getDescription().getvalue().trim());
            shipTo.setPaymentInstructions(message.getPunchOutOrderMessageHeader().getShipTo().getIdReference()
                    .stream().filter(e->e.getDomain().equals("shipInstr")).collect(Collectors.toList()).get(0)
                    .getDescription().getvalue().trim());
            shipTo.setOrderType(message.getPunchOutOrderMessageHeader().getShipTo().getIdReference()
                    .stream().filter(e->e.getDomain().equals("orderType")).collect(Collectors.toList()).get(0)
                    .getDescription().getvalue().trim());
            shipTo.setShippingInstructions(message.getPunchOutOrderMessageHeader().getShipTo()
                    .getTransportInformation().get(0).getShippingInstructions().getDescription().getvalue().trim());
            List<SpecialInstruction> specialInstructions = new ArrayList<>();
            String instructions = message.getPunchOutOrderMessageHeader().getShipping()
                    .getDescription().getvalue();
            if(instructions != null && !instructions.isEmpty()) {
                //Scanner s = new Scanner(instructions);
                //s.useDelimiter("\u2020\u2020");
                //System.out.println(instructions.charAt(instructions.length()-1));
                String[] fields = splitFields(instructions.trim(), 50);
                for (String s : fields) {
                    specialInstructions.add(new SpecialInstruction(s.trim()));
                }
                //while (s.hasNext()){
                //    specialInstructions.add(new SpecialInstruction(s.next().trim()));
                //}
            }
            shipTo.setSpecialInstructions(specialInstructions);
            order.setExpectedDate(formatIn.parse(message.getPunchOutOrderMessageHeader().getSupplierOrderInfo().getOrderDate().trim()));
            Calendar c = Calendar.getInstance();
            c.setTime(formatIn.parse(message.getPunchOutOrderMessageHeader().getSupplierOrderInfo().getOrderDate().trim()));
            order.setShipTo(shipTo);
            order.setSupplierOrderReference(message.getPunchOutOrderMessageHeader().getSupplierOrderInfo().getOrderID().trim());
            order.setCurrency(message.getPunchOutOrderMessageHeader().getTotal().getMoney().getCurrency().trim());
            order.setTotalAmount(Double.parseDouble(message.getPunchOutOrderMessageHeader().getTotal().getMoney().getvalue().trim()));
            List<com.procuredox.receivers.cat.cXML.ItemIn> items = message.getItemIn();
            List<Item> list = new ArrayList<>();
            for(com.procuredox.receivers.cat.cXML.ItemIn item: items){
                Item listItem = new Item();
                boolean coreCharge = item.getItemID().getIdReference().stream()
                        .filter(e -> e.getDomain().equals("core")).
                                collect(Collectors.toList()).get(0).getIdentifier().equals("Y");
                listItem.setCoreCharge(coreCharge);
                listItem.setDescription(item.getItemDetail().getDescription().get(0).getvalue().trim());
                listItem.setUnitOfMeasure(item.getItemDetail().getUnitOfMeasure());
                listItem.setUnitPrice(Double.parseDouble(item.getItemDetail().getUnitPrice().getMoney().getvalue().trim()));
                listItem.setLineNumber(Integer.parseInt(item.getLineNumber().trim()));
                Integer lead = Integer.parseInt(item.getItemDetail().getLeadTime().trim());
                c.add(Calendar.DAY_OF_MONTH, lead);
                String dateLead = formatIn.format(c.getTime());
                listItem.setDeliveryDate(formatIn.parse(dateLead));
                listItem.setQuantity(Double.parseDouble(item.getQuantity()));
                listItem.setSupplierPartId(item.getItemID().getSupplierPartID().getvalue().trim());
                listItem.setSupplierPartAuxiliaryId(item.getItemID().getSupplierPartAuxiliaryID().getContent().get(0).toString().
                        trim());
                List<com.procuredox.receivers.cat.cXML.Extrinsic> extrinsics = item.getItemDetail().getExtrinsic();
                List<ItemQuantity> quantities = new ArrayList<>();
                for(com.procuredox.receivers.cat.cXML.Extrinsic ex: extrinsics){
                    ItemQuantity quantity = new ItemQuantity(Double.parseDouble(ex.getContent().get(0).toString().trim()),
                            ex.getName().trim());
                    quantities.add(quantity);
                }
                listItem.setQuantities(quantities);
                listItem.setManufacturerPartId(item.getItemDetail().getManufacturerPartID().trim());
                listItem.setManufacturerName(item.getItemDetail().getManufacturerName().getvalue().trim());
                listItem.setComments(item.getComments().getvalue().trim());
                list.add(listItem);
            }
            order.setItems(list);
            order.setCount(list.size());
            XmlMapper mapper = new XmlMapper();
            String xml = mapper.writeValueAsString(order);
            xml = xml.replaceAll("xmlns=\"\"","");
            FileUtils.writeByteArrayToFile(
                    new File(BATCHPATH+batchNumber.toString()+"/pdox_order.xml"), xml.getBytes());
            JAXBContext orderCtx = JAXBContext.newInstance(OrderType.class);
            Unmarshaller orderUnmarshaller = orderCtx.createUnmarshaller();
            OrderType orderType = (OrderType)orderUnmarshaller.unmarshal(new ByteArrayInputStream(xml.getBytes()));
            VelocityEngine ve = new VelocityEngine();
            ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
            ve.setProperty("runtime.log.logsystem.log4j.logger", ApiResources.class.getName());
            ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
            ve.init();
            Template t = ve.getTemplate("templates/punchout.vm");
            VelocityContext ctx = new VelocityContext();
            ctx.put("order",orderType);
            ctx.put("number",new NumberTool());
            ctx.put("aLocale", Locale.US);
            ctx.put("date",new ExtendedDateTool());
            StringWriter writer = new StringWriter();
            t.merge(ctx, writer);
            /*File file = new File("c:/Users/ihamouda/Documents/new.html");
            FileUtils.writeStringToFile(file,writer.toString());*/
            FileUtils.writeByteArrayToFile(
                    new File(BATCHPATH+batchNumber.toString()+"/pdox_order.html"), writer.toString().getBytes());
            return Response.status(Response.Status.ACCEPTED).entity(writer.toString()).build();
        }catch (JAXBException e){
            logger.error("order jaxb error:", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IOException e){
            logger.error("order io error:", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (DocumentException e){
            logger.error("order document error:", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (Exception e){
            logger.error("order error:", e);
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    private String[] splitFields(String string, int FIELD_SIZE){
        try {
            final int actualLength = string.length();
            if (actualLength > FIELD_SIZE) {
                final int resultSize = (int) Math.ceil((double) actualLength / FIELD_SIZE);
                final String[] result = new String[resultSize];

                final ByteArrayInputStream bais = new ByteArrayInputStream(string.getBytes());
                byte[] chunk = new byte[FIELD_SIZE];
                int idx = 0, n;
                while ((n = bais.read(chunk)) > 0) {
                    result[idx] = new String(chunk).trim();
                    idx += 1;
                }
                return result;
            }else{
                final String[] result = new String[1];
                result[0] = string.trim();
                return result;
            }
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
}
