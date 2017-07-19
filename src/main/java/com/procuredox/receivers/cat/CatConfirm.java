package com.procuredox.receivers.cat;

import com.procuredox.receivers.AppResources;
import com.procuredox.receivers.SendEmail;
import com.procuredox.receivers.Utils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.glassfish.jersey.internal.util.Base64;

import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;

/**
 * Created by ihamouda on 2017-07-19.
 */
public class CatConfirm {
    final Logger logger = Logger.getLogger("Cat Order");
    private AppResources rb = AppResources.getInstance();
    final Utils utils = Utils.getInstance();
    private final String BATCHPATH = rb.getRb().getString("root")+"data/biztalk/Share/Attachments/";
    private SendEmail email = SendEmail.getInstance();
    public Response receiveCatConfirm(String xml){
        try {
            final byte[] decodedBytes = Base64.decode(xml.getBytes());
            Integer batchNumber = utils.getBatchNumber();
            FileUtils.writeByteArrayToFile(
                    new File(BATCHPATH + batchNumber.toString() + "/cat_confirm.xml"), decodedBytes);

            return Response.status(Response.Status.OK).build();
        }catch (IOException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (Exception e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
