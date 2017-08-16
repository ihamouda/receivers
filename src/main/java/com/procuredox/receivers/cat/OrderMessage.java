package com.procuredox.receivers.cat;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.procuredox.receivers.*;
import com.procuredox.receivers.cat.responsemessage.OrderType;
import com.procuredox.receivers.ordermessage.Extrinsic;
import com.procuredox.receivers.ordermessage.ItemIn;
import com.procuredox.receivers.ordermessage.PunchOutOrderMessage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.apache.velocity.tools.generic.NumberTool;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.glassfish.jersey.internal.util.Base64;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * Created by ihamouda on 2017-06-25.
 */
public class OrderMessage {
    final Logger logger = Logger.getLogger("Cat Order");
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
            SimpleDateFormat formatIn = new SimpleDateFormat("yyyyMMdd");
            Order order = new Order();
            InputStream is = new ByteArrayInputStream(cXml.getBytes());
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);
            Element elm = (Element)doc.getRootElement().selectSingleNode("/cXML/Message/PunchOutOrderMessage");
            JAXBContext jaxBCtx = JAXBContext.newInstance(PunchOutOrderMessage.class);
            Unmarshaller unmarshaller = jaxBCtx.createUnmarshaller();
            PunchOutOrderMessage message = (PunchOutOrderMessage) unmarshaller.unmarshal(
                    new ByteArrayInputStream(elm.asXML().getBytes()));
            order.setBatchNumber(batchNumber);
            Address address = new Address();
            address.setStreet(message.getPunchOutOrderMessageHeader().getShipTo().getAddress().getPostalAddress()
                    .getStreet().get(0).getvalue().trim());
            address.setCity(message.getPunchOutOrderMessageHeader().getShipTo().getAddress()
                    .getPostalAddress().getCity().getvalue().trim());
            address.setProvince(message.getPunchOutOrderMessageHeader().getShipTo().getAddress()
                    .getPostalAddress().getState().getvalue().trim());
            address.setPostalCode(message.getPunchOutOrderMessageHeader().getShipTo()
                    .getAddress().getPostalAddress().getPostalCode().trim());
            address.setCountry(message.getPunchOutOrderMessageHeader().getShipTo().getAddress().getPostalAddress()
                    .getCountry().getIsoCountryCode().trim());
            ShipTo shipTo = new ShipTo();
            shipTo.setShipToName(message.getPunchOutOrderMessageHeader().getShipTo()
                    .getAddress().getName().getvalue().trim());
            shipTo.setAddress(address);
            shipTo.setPaymentInstructions(message.getPunchOutOrderMessageHeader().getShipTo().getIdReference()
                    .stream().filter(e ->e.getDomain().equals("shipInstr")).collect(Collectors.toList())
                    .get(0).getDescription().getvalue().trim());
            shipTo.setDeliveryLocation(message.getPunchOutOrderMessageHeader().getShipTo().getIdReference()
                    .stream().filter(e -> e.getDomain().equals("deliveryLocation")).collect(Collectors.toList()).get(0).getDescription()
                    .getvalue().trim());
            shipTo.setAccountName(message.getPunchOutOrderMessageHeader().getShipTo().getIdReference()
                    .stream().filter(e->e.getDomain().equals("accountNum")).collect(Collectors.toList()).get(0)
                    .getDescription().getvalue().trim());
            shipTo.setAccountNum(message.getPunchOutOrderMessageHeader().getShipTo().getIdReference()
                    .stream().filter(e->e.getDomain().equals("accountNum")).collect(Collectors.toList()).get(0)
                    .getIdentifier().trim());
            shipTo.setSupplierReference(message.getPunchOutOrderMessageHeader().getShipTo().getIdReference()
                    .stream().filter(e->e.getDomain().equals("supplierReference")).collect(Collectors.toList()).get(0)
                    .getDescription().getvalue().trim());
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
            order.setShipTo(shipTo);
            order.setSupplierOrderReference(message.getPunchOutOrderMessageHeader().getSupplierOrderInfo().getOrderID().trim());
            order.setCurrency(message.getPunchOutOrderMessageHeader().getTotal().getMoney().getCurrency().trim());
            order.setTotalAmount(Double.parseDouble(message.getPunchOutOrderMessageHeader().getTotal().getMoney().getvalue().trim()));
            List<ItemIn> items = message.getItemIn();
            List<Item> list = new ArrayList<>();
            for(ItemIn item: items){
                Item listItem = new Item();
                boolean coreCharge = item.getItemID().getIdReference().stream()
                        .filter(e -> e.getDomain().equals("core")).
                                collect(Collectors.toList()).get(0).getIdentifier().equals("Y");
                listItem.setCoreCharge(coreCharge);
                listItem.setDescription(item.getItemDetail().getDescription().get(0).getvalue().trim());
                listItem.setUnitOfMeasure(item.getItemDetail().getUnitOfMeasure().getvalue().trim());
                listItem.setUnitPrice(Double.parseDouble(item.getItemDetail().getUnitPrice().getMoney().getvalue().trim()));
                listItem.setLineNumber(Integer.parseInt(item.getLineNumber().trim()));
                listItem.setDeliveryDate(formatIn.parse(item.getItemDetail().getLeadTime().trim()));
                listItem.setQuantity(Double.parseDouble(item.getQuantity()));
                if(items.indexOf(item) == 0)
                    order.setExpectedDate(formatIn.parse(item.getItemDetail().getLeadTime().trim()));
                listItem.setSupplierPartId(item.getItemID().getSupplierPartID().getvalue().trim());
                listItem.setSupplierPartAuxiliaryId(item.getItemID().getSupplierPartAuxiliaryID().getContent().get(0).toString().
                        trim());
                List<Extrinsic> extrinsics = item.getItemDetail().getExtrinsic();
                List<ItemQuantity> quantities = new ArrayList<>();
                for(Extrinsic ex: extrinsics){
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
            /*File xmlFile = new File("c:/Users/ihamouda/Documents/order.xml");
            FileUtils.writeStringToFile(xmlFile,xml);*/
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
            return Response.status(Response.Status.OK).entity(writer.toString()).build();
        }catch (JAXBException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (IOException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (DocumentException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (Exception e){
            logger.error(e.getMessage());
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
            }else return null;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
}
