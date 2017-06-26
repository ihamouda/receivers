package com.procuredox.receivers.cat;

import com.procuredox.receivers.*;
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
import org.dom4j.io.SAXReader;
import org.glassfish.jersey.internal.util.Base64;

import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by ihamouda on 2017-06-25.
 */
public class OrderMessage {
    final Logger logger = Logger.getLogger(getClass().getName());
    private AppResources rb = AppResources.getInstance();
    final Utils utils = Utils.getInstance();
    private final String BATCHPATH = rb.getRb().getString("root")+"data/biztalk/Share/Attachments/";
    private SendEmail email = SendEmail.getInstance();

    public Response receiveOrderMessage(String cxml){
        try {
            final byte[] decodedBytes = Base64.decode(cxml.getBytes());
            logger.info(new String(decodedBytes));
            Integer batchNumber = utils.getBatchNumber();
            FileUtils.writeByteArrayToFile(
                    new File(BATCHPATH+batchNumber.toString()+"/cat_order.xml"), decodedBytes);
            String xml = new String(decodedBytes, StandardCharsets.UTF_8);
            xml = xml.replaceAll("<!DOCTYPE.*cXML.dtd\">", "");
            InputStream is = new ByteArrayInputStream(xml.getBytes());
            VelocityEngine ve = new VelocityEngine();
            ve.setProperty(RuntimeConstants.RUNTIME_LOG_LOGSYSTEM_CLASS, "org.apache.velocity.runtime.log.Log4JLogChute");
            ve.setProperty("runtime.log.logsystem.log4j.logger", ApiResources.class.getName());
            ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
            ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
            ve.init();
            Template t = ve.getTemplate("templates/punchout.vm");
            VelocityContext ctx = new VelocityContext();
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);
            org.dom4j.Element elm = (org.dom4j.Element) doc.selectSingleNode("/cXML/Message/PunchOutOrderMessage");
            JAXBContext jaxbContext = JAXBContext.newInstance(PunchOutOrderMessage.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            InputStream isXml = new ByteArrayInputStream(elm.asXML().getBytes());
            PunchOutOrderMessage message = (PunchOutOrderMessage) unmarshaller.unmarshal(isXml);
            Order order = new Order();
            order.setOperationAllowed(message.getPunchOutOrderMessageHeader().getOperationAllowed());
            order.setTotalAmount(Double.parseDouble(message.getPunchOutOrderMessageHeader().getTotal()
                    .getMoney().getvalue()));
            order.setCurrency(message.getPunchOutOrderMessageHeader().getTotal().getMoney().getCurrency());
            order.setItems(new ArrayList<>());
            for(ItemIn itemIn: message.getItemIn()){
                Item item = new Item();
                item.setDescription(itemIn.getItemDetail().getDescription().get(0).getvalue().trim());
                item.setLineNumber(Integer.parseInt(itemIn.getLineNumber()));
                item.setQuantity(Double.parseDouble(itemIn.getQuantity()));
                item.setSupplierPartId(itemIn.getItemID().getSupplierPartID().getvalue());
                item.setSupplierPartAuxilaryId((String)itemIn.getItemID().getSupplierPartAuxiliaryID().
                        getContent().get(0));
                item.setUnitPrice(Double.parseDouble(itemIn.getItemDetail().getUnitPrice().getMoney().getvalue()));
                item.setUnitOfMeasure(itemIn.getItemDetail().getUnitOfMeasure().getvalue());
                order.getItems().add(item);
            }
            order.setCount(order.getItems().size());
            order.setBatchNumber(batchNumber);
            ctx.put("order",order);
            ctx.put("number",new NumberTool());
            ctx.put("aLocale", Locale.US);
            StringWriter writer = new StringWriter();
            t.merge(ctx, writer);
            return Response.status(Response.Status.OK).entity(writer.toString()).build();
        }catch (JAXBException e){
            e.printStackTrace();
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
}
