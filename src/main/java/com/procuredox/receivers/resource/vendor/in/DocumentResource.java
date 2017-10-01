package com.procuredox.receivers.resource.vendor.in;

import com.procuredox.receivers.db.model.BatchedProperties;
import com.procuredox.receivers.db.model.DocumentXPaths;
import com.procuredox.receivers.service.storage.StorageService;
import com.procuredox.receivers.services.DocumentService;
import com.procuredox.receivers.services.KeyDocNotValid;
import com.procuredox.receivers.services.NotAuthorized;
import org.dom4j.DocumentHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static com.procuredox.receivers.resource.vendor.in.Utils.defaultIfEmpty;

@Path("/receive")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentResource {
    private static final Logger log = LoggerFactory.getLogger(DocumentResource.class);

    private static final String FUNCTIONAL_ACKNOWLEDGEMENT = "FunctionalAcknowledgement";

    @Context
    private StorageService storageService;
    @Context
    private ServletContext servletContext;

    private DocumentService documentService;

    @POST
    @Path("/vendor")
    public Response receive(Document packageInfo) {
        log.info("document processing started: {}", packageInfo);
        try {
            final String xmlbody = packageInfo.getXmlbody();
            final String filename = packageInfo.getXmlName();

            byte[] decoded = Base64.getDecoder().decode(xmlbody);
            storageService.save(filename, packageInfo.getSession(), decoded);

            final String normalizedFilename = filename.toLowerCase();
            if (normalizedFilename.endsWith(".pdf")) {
                log.info("document processing success.");
                return Utils.restOk(new AttachmentResponseModel(
                        filename + ":" + Utils.currentTime() + " : Receive",
                        true));
            } else {
                Map<String,Object> headers = new HashMap<>();

                final String xml = new String(decoded);
                final org.dom4j.Document document = DocumentHelper.parseText(xml);

                final String root = document.getRootElement().getName();
                final String deploymentMode = document.getRootElement().attributeValue("deploymentMode");

                fillFromModel(headers, packageInfo);

                if (FUNCTIONAL_ACKNOWLEDGEMENT.equals(root)) {
                    final Session session = (Session) servletContext.getAttribute("AMQSession");
                    final Queue queue = session.createQueue("vendor.in.func");
                    final MessageProducer producer = session.createProducer(queue);

                    final StreamMessage streamMessage = session.createStreamMessage();
                    for (Map.Entry<String, Object> entry : headers.entrySet()) {
                        streamMessage.setStringProperty(entry.getKey(), (String)entry.getValue());
                    }

                    producer.send(queue, streamMessage);

                    final String message = filename + ":" + Utils.currentTime() + ": Received Successfuly";
                    log.info("functional acknowledgement processing success.");
                    return Utils.restOk(DocumentResponseModel.success(message));
                }

                final BatchedProperties propsHolder = documentService.find(packageInfo.getSecurityKey(), root);
                final DocumentXPaths props = propsHolder.getPaths();
                final int batchNumber = propsHolder.getBatchNumber();

                headers.put("TransmitType", deploymentMode);
                headers.put("BatchNumber", batchNumber);

                fillFromProperties(headers, props);

                final Session session = (Session) servletContext.getAttribute("AMQSession");
                final Queue queue = session.createQueue("vendor.in.start");
                final MessageProducer producer = session.createProducer(queue);

                final StreamMessage streamMessage = session.createStreamMessage();
                for (Map.Entry<String, Object> entry : headers.entrySet()) {
                    streamMessage.setStringProperty(entry.getKey(), (String)entry.getValue());
                }

                producer.send(queue, streamMessage);

                final String message = filename + ":" + Utils.currentTime() + ": Batch Number: " + batchNumber + " Received Successfuly";
                log.info("document processing success.");
                return Utils.restOk(DocumentResponseModel.success(message, batchNumber));
            }
        } catch (NotAuthorized e) {
            log.warn("unauthorized access.");
            return Utils.restFail(401, DocumentResponseModel.failed("Unauthorized"));
        } catch (KeyDocNotValid e) {
            log.warn("document processing fail with seckey/doc combination not valid.");
            return Utils.restFail(420, DocumentResponseModel.failed("Security Key/Document root combination not valid"));
        } catch (Exception e) {
            log.error("can't process document", e);
            return Utils.restFail(420, DocumentResponseModel.failed(e.getMessage()));
        }
    }

    private void fillFromModel(Map<String, Object> headers, Document model) {
        headers.put("SecurityKey", model.getSecurityKey());
        headers.put("Folder", model.getSession());
        headers.put("file_name", model.getXmlName());
    }

    private void fillFromProperties(Map<String, Object> headers, DocumentXPaths props) {
        headers.put("ReceiverIdentifierXpath", defaultIfEmpty(props.getReceiverIdentifierXpath(), ""));
        headers.put("SenderIdentifierXpath", defaultIfEmpty(props.getSenderIdentifierXpath(), ""));
        headers.put("DocumentTypeXpath", defaultIfEmpty(props.getDocumentTypeXpath(), ""));
        headers.put("CustomerCode", defaultIfEmpty(props.getCustomerCodeId(), ""));
    }

    public void setDocumentService(DocumentService documentService) {
        this.documentService = documentService;
    }

    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }

    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
}