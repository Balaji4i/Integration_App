/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.al.miskintegrations;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author gautham.r
 */
@Path("receipt")
public class ReceiptCreation {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ReceiptCreation
     */
    public ReceiptCreation() {
    }

    /**
     * Retrieves representation of an instance of
     * com.mycompany.al.miskintegrations.ReceiptCreation
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of ReceiptCreation
     *
     * @param content representation for the resource
     */
    @Path("/create/v1")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createReciept(String content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        RecieptBody bodyData = objectMapper.readValue(content, RecieptBody.class);
        InvokeWebService invokeWebService = new InvokeWebService();
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").entity(invokeWebService.responseToCreateReciept(invokeWebService.createReciept(bodyData))).build();
    }

    @Path("/apply/v1")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response applyReciept(String content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        RecieptApplyBody recieptApplyBody = objectMapper.readValue(content, RecieptApplyBody.class);
        InvokeWebService invokeWebService = new InvokeWebService();
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").entity(invokeWebService.responseToRest(invokeWebService.applyReciept(recieptApplyBody))).build();
    }

    @Path("/cancel/v1")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cancelReciept(String content) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        RecieptCancelBody recieptCancelBody = objectMapper.readValue(content, RecieptCancelBody.class);
        InvokeWebService invokeWebService = new InvokeWebService();
        return Response.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").entity(invokeWebService.responseToRest(invokeWebService.cancelReciept(recieptCancelBody))).build();
    }
}
