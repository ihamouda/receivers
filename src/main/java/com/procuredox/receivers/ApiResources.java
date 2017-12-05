package com.procuredox.receivers;

import com.procuredox.receivers.cat.CatConfirm;
import com.procuredox.receivers.cat.OrderMessage;

import com.procuredox.receivers.custcode.*;
import com.procuredox.receivers.resend.BatchFileNotFound;
import com.procuredox.receivers.resend.DocumentNotFound;
import com.procuredox.receivers.resend.PartnerNotFound;
import com.procuredox.receivers.resend.PoResender;
import com.procuredox.receivers.tradeshift.Receive;
import org.apache.commons.lang.exception.ExceptionUtils;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


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

    @POST
    @Path("/requeue")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response resendPo(ResendPORequest request) {
        final PoResender service = new PoResender();
        try {
            service.resend(request.getBatchNumber());
            return Response.ok(new ResendPOResponse(true, null, null)).build();
        } catch (DocumentNotFound | PartnerNotFound | BatchFileNotFound e) {
            return Response.status(Response.Status.NO_CONTENT)
                    .entity(new ResendPOResponse(false, e.getMessage(), null))
                    .build();
        } catch (Exception e) {
            return Response.serverError()
                    .entity(new ResendPOResponse(false, e.getMessage(), ExceptionUtils.getFullStackTrace(e)))
                    .build();
        }
    }

    @POST
    @Path("/custcodepartners")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustCodesPartners(CustCodePartnersRequest request){
        final GetCustomers customers = new GetCustomers();
        return customers.getCustomers(request.getSecKey());
    }

    @POST
    @Path("/custcodesearch")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustCodesSearch(CustCodeSearchRequest request){
        final GetCustCodes codes = new GetCustCodes();
        return codes.getCustCodes(request.getSecKey(), request.getSearch());
    }

    @POST
    @Path("/setcustcode")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response setCustCode(SetCustCodeRequest request){
        final SetCustCode custcode = new SetCustCode();
        return custcode.setCustCode(request);
    }

    @POST
    @Path("/checkcustcode")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkCustCode(CheckCustCodeRequest request){
        final CheckCustCode code = new CheckCustCode();
        return code.checkCustCode(request.getSecKey(), request.getCustCode());
    }

    @POST
    @Path("/checkinvcustcode")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkInvCustCode(CheckCustCodeRequest request){
        final CheckInvCustCode code = new CheckInvCustCode();
        return code.checkCustCode(request.getSecKey(), request.getCustCode());
    }

    @POST
    @Path("/checkseckey")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response checkSecKey(CheckSecKeyRequest request){
        final CheckSecKey key = new CheckSecKey();
        return key.checkSecKey(request.getSecKey());
    }

    @POST
    @Path("deletecustcode")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteCustCode(DeleteCustCodeRequest request){
        final DeleteCustCode custCode = new DeleteCustCode();
        return custCode.deleteCustCode(request);
    }
}
