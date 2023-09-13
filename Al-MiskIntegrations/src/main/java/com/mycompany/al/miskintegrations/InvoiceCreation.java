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
@Path("invoicecreation")
public class InvoiceCreation {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of InvoiceCreation
     */
    public InvoiceCreation() {
    }

    /**
     * Retrieves representation of an instance of
     * com.mycompany.al.miskintegrations.InvoiceCreation
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of InvoiceCreation
     *
     * @param content representation for the resource
     */
    @Path("/v1")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createInvoice(String body) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        BodyDeserialization bodyData = objectMapper.readValue(body, BodyDeserialization.class);
        InvokeWebService invokeWebService = new InvokeWebService();
        String resultstatus = invokeWebService.invoiceInterface(bodyData);
//        String resultstatus;
//        if (invoiceStatus.equalsIgnoreCase("Invoice Created Succesfully")) {
//            resultstatus = invokeWebService.codeGeneration(bodyData);
            return Response.ok()
                    .header("Access-Control-Allow-Origin", "*")
                    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
                    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").entity(invokeWebService.responseToRest(resultstatus)).build();
//        } else {

//            return Response.ok()
//                    .header("Access-Control-Allow-Origin", "*")
//                    .header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS")
//                    .header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").entity(invokeWebService.responseToRest(invoiceStatus)).build();
//        }
    }
}
