package com.procuredox.receivers;

import org.apache.commons.io.FileUtils;
import org.glassfish.jersey.internal.util.Base64;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Created by ihamouda on 2017-06-21.
 */
@Path("/")
public class ApiResources {
    private static AppResources rb = AppResources.getInstance();
    private static final String BATCHPATH = rb.getRb().getString("root")+"data/biztalk/Share/Attachments/";
    private static SendEmail email = SendEmail.getInstance();
    @POST
    @Path("/tradeshift")
    @Consumes(MediaType.TEXT_XML)
    public Response receiveDocument(String Xml){
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
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/cat")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response getCatPo(@FormParam("CXML-base64") String cxml){
        try {
            String decoded = Base64.decode(cxml.getBytes()).toString();
            FileUtils.writeByteArrayToFile(
                    new File("c:/Users/ihamouda/Documents/CAT/tests/cat_order.xml"), decoded.toString().getBytes());
            return Response.status(Response.Status.OK).build();
        }catch (IOException e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }catch (Exception e){
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
