package com.procuredox.receivers;

import com.procuredox.receivers.cat.CatConfirm;
import com.procuredox.receivers.cat.OrderMessage;
import com.procuredox.receivers.ordermessage.*;

import com.procuredox.receivers.tradeshift.Receive;
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

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Locale;
import java.util.UUID;


/**
 * Created by ihamouda on 2017-06-21.
 */
@Path("/")
public class ApiResources {
    @POST
    @Path("/tradeshift")
    @Consumes(MediaType.TEXT_XML)
    public Response receiveDocument(String Xml){
        Receive receive = new Receive();
        Response response = receive.receiveTradeShift(Xml);
        return response;
    }

    @POST
    @Path("/cat")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public Response getCatPo(@FormParam("CXML-base64") String cxml){
        OrderMessage message = new OrderMessage();
        Response response = message.receiveOrderMessage(cxml);
        return response;
    }

    @POST
    @Path("/catconfirm")
    @Consumes(MediaType.TEXT_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCatConfirm(String xml){
        CatConfirm confirm = new CatConfirm();
        Response response = confirm.receiveCatConfirm(xml);

        return response;
    }
}
