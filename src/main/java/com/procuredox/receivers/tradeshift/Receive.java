package com.procuredox.receivers.tradeshift;

import com.procuredox.receivers.ApiResources;
import com.procuredox.receivers.AppResources;
import com.procuredox.receivers.SendEmail;
import com.procuredox.receivers.Utils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by ihamouda on 2017-06-25.
 */
public class Receive {
    final Logger logger = Logger.getLogger("Tradeshift");
    private  AppResources rb = AppResources.getInstance();
    final  Utils utils = Utils.getInstance();
    private final String BATCHPATH = rb.getRb().getString("root")+"data/biztalk/Share/Attachments/";
    private  SendEmail email = SendEmail.getInstance();

    public Response receiveTradeShift(String Xml){
        if(Xml == null){
            System.out.println("TradeShift: No Document");
            return Response.status(Response.Status.BAD_REQUEST).entity("No Document").build();
        }
        try {
            String Uuid = UUID.randomUUID().toString();

            File directory = new File(BATCHPATH+Uuid);
            if(!directory.exists()){
                directory.mkdirs();
            }
            File file = new File(directory+"/"+Uuid+".xml");
            FileUtils.writeByteArrayToFile(file,Xml.getBytes());
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    email.sendEmail(Uuid);
                }
            };
            task.run();
            return Response.status(Response.Status.OK).build();
        }
        catch (IOException e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (Exception e){
            logger.error(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
