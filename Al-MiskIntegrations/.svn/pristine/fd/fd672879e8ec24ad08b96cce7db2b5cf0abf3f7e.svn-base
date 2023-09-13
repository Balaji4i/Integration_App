
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.al.miskintegrations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
//import org.json.simple.JSONObject;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author gautham.r
 */
public class InvokeWebService {

    WsPayload payload;
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public InvokeWebService() {
        payload = new WsPayload();

    }

    public void setEnvironmentURL(String environment) {
        if (environment == null || environment.equalsIgnoreCase("prod")) {
            setBaseUrl("https://egzy.fa.em2.oraclecloud.com");
        } else {
            setBaseUrl("https://egzy-test.fa.em2.oraclecloud.com");
        }
    }

    public String invoiceInterface(BodyDeserialization bodyData) {
        try {
            String resp = ""; //Added on Dec-06
            setEnvironmentURL(bodyData.getEnvironment());
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("text/xml");
            String xmlInput = payload.invoiceInterfacePayload(bodyData);
            System.out.println("Base Url :" + getBaseUrl());
            System.out.println("Request Payload : " + xmlInput);
            RequestBody body = RequestBody.create(mediaType, xmlInput);
            Request request
                    = new Request.Builder().url(getBaseUrl() + "/fscmService/RecInvoiceService?wsdl").post(body).addHeader("content-type",
                            "text/xml").addHeader("cache-control",
                                    "no-cache").addHeader("SOAPACTION", "createInterfaceLine").build();
            Response response = null;

            response = client.newCall(request).execute();

            InputStream isr = response.body().byteStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }
//            if (bodyData.getCcId() == null) {
//                if (bodyData.getOrgId().equalsIgnoreCase("")) {
//                    bodyData.setCcId("");
//                }
//                if (bodyData.getOrgId().equalsIgnoreCase("")) {
//                    bodyData.setCcId("");
//                }
//            }
            System.out.println("Response Code : " + response.code());
            resp = out.toString();
            System.out.println("response : " + resp);
            if (response.code() == 200) {
                String status = distributionInterface(bodyData);
                if (status.equalsIgnoreCase("Success")) {
                    return status;
                } else {
                    return status;
                }
//                return "Invoice Created Succesfully";
            } else {
//                return "Error in Invoice Creation";
                return "Error in Invoice Creation :" + resp;
            }
        } catch (IOException ex) {
            Logger.getLogger(InvokeWebService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Error in Service";
    }

//    public String codeGeneration(BodyDeserialization bodyData) {
//        String ccId = null;
//        try {
//
//            OkHttpClient client = new OkHttpClient();
//            MediaType mediaType = MediaType.parse("text/xml");
//            String segments[] = bodyData.getSegmentedCode().split("\\.");
//            String xmlInput = payload.codeCombinationPayload(bodyData, segments);
//            System.out.println("code Generation Request : " + xmlInput);
//            RequestBody body = RequestBody.create(mediaType, xmlInput);
////             Please change the soap url and soap action
//            Request request
//                    = new Request.Builder().url(getBaseUrl() + "/fscmService/AccountCombinationService?wsdl").post(body).addHeader("content-type",
//                            "text/xml").addHeader("cache-control",
//                                    "no-cache").addHeader("SOAPACTION", "validateAndCreateAccounts").build();
//            Response response = null;
//
//            response = client.newCall(request).execute();
//
//            InputStream isr = response.body().byteStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(isr));
//            StringBuilder out = new StringBuilder();
//            String resultsXml;
//            while ((resultsXml = reader.readLine()) != null) {
//                out.append(resultsXml);
//            }
//
//            System.out.println("Response   :" + out.toString());
//            ccId = xmlExtractor(response.code(), out.toString());
//            if (response.code() == 200 && !ccId.contains("ErrorccId".toLowerCase())) {
//                String status = distributionInterface(bodyData, ccId);
//                if (status.equalsIgnoreCase("Success")) {
//                    return status;
//                } else {
//                    return status;
//                }
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(InvokeWebService.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
////        ccId = "300000001703389";
//        return ccId;
//    }
//    public String xmlExtractor(int responseCode, String responseString) {
//        try {
//            DocumentBuilder builder
//                    = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            InputSource src = new InputSource();
//            src.setCharacterStream(new StringReader(responseString));
//            Document doc = builder.parse(src);
//            if (responseCode == 200) {
//                // gets the error Information Except the error in segment
//                if (doc.getElementsByTagName("ns1:CcId").item(0).getTextContent().isEmpty()) {
//                    System.out.println(doc.getElementsByTagName("ns1:Error").item(0).getTextContent());
//                    return "Error : " + doc.getElementsByTagName("ns1:Error").item(0).getTextContent();
//                } // gets the error if it occurs in segments
//                else if (doc.getElementsByTagName("ns1:CcId").item(0).getTextContent().equalsIgnoreCase("-1")) {
//                    return "Enter the required value attributes for the segment values  and error code : " + doc.getElementsByTagName("ns1:ErrorCode").item(0).getTextContent();
//                } // gets the data if payload has no errors
//                else {
//                    return doc.getElementsByTagName("ns1:CcId").item(0).getTextContent();
//                }
//
//            } else {
//                return doc.getElementsByTagName("faultstring").item(0).getTextContent();
//            }
//        } catch (SAXException | IOException | ParserConfigurationException ex) {
//            Logger.getLogger(InvokeWebService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return "Parsing Error";
//    }
    public String distributionInterface(BodyDeserialization bodyData) {
        try {
            String resp = ""; //Added on Dec-06
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("text/xml");
            String xmlInput = payload.distributionPayload(bodyData);
            System.out.println("Request Payload : " + xmlInput);
            RequestBody body = RequestBody.create(mediaType, xmlInput);
            Request request
                    = new Request.Builder().url(getBaseUrl() + "/fscmService/RecInvoiceService?wsdl").post(body).addHeader("content-type",
                            "text/xml").addHeader("cache-control",
                                    "no-cache").addHeader("SOAPACTION", "createInterfaceDistribution").build();
            Response response = null;

            response = client.newCall(request).execute();

            InputStream isr = response.body().byteStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }
            System.out.println(resultsXml);
            resp = out.toString();
            if (response.code() == 200) {
                return "Success";
            } else {
                return " Error in payload of distribution Interface :" + resp;
            }
        } catch (IOException ex) {
            Logger.getLogger(InvokeWebService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return "Error in webservice of Distribution Interface";
    }

    public String responseToRest(String result) {
        JSONObject json = new JSONObject();
        json.put("result", result);
        return json.toString();
    }

    public String responseToCreateReciept(String result) {
        JSONObject json = new JSONObject();
        json.put("cash_reciept_id", result);
        return json.toString();
    }

    public String createReciept(RecieptBody recieptData) {
        try {
            setEnvironmentURL(recieptData.getEnvironment());
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("text/xml");

            String xmlInput = payload.recieptCreationPayload(recieptData);
            System.out.println(xmlInput);
            RequestBody body = RequestBody.create(mediaType, xmlInput);
            Request request
                    = new Request.Builder().url(getBaseUrl() + "/fscmService/StandardReceiptService?wsdl").post(body).addHeader("content-type",
                            "text/xml").addHeader("cache-control",
                                    "no-cache").addHeader("SOAPACTION", "createStandardReceipt").build();
            Response response = null;

            response = client.newCall(request).execute();

            InputStream isr = response.body().byteStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }
            String responseString = out.toString();
            responseString = responseString.substring(responseString.indexOf("<?xml"), responseString.indexOf("</env:Envelope>")) + "</env:Envelope>";
            System.out.println(responseString);
            return xmlExtractorForReceiptCreation(response.code(), responseString);
        } catch (IOException ex) {
            Logger.getLogger(ReceiptCreation.class.getName()).log(Level.SEVERE, null, ex);
            return "Error in Invoking webservice";
        }

    }

    public String xmlExtractorForReceiptCreation(int responseCode, String responseString) {
        try {
            DocumentBuilder builder
                    = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource src = new InputSource();
            src.setCharacterStream(new StringReader(responseString));
            Document doc = builder.parse(src);
            if (responseCode != 200) {
                Element rootElement = doc.getDocumentElement();
                NodeList item = rootElement.getElementsByTagName("faultstring");
                String out = item.item(0).getTextContent();
                out = out.substring(out.indexOf("<TEXT>") + 6, out.indexOf("</TEXT>"));
                return out;
            } else {
                return doc.getElementsByTagName("ns3:CashReceiptId").item(0).getTextContent();
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ReceiptCreation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(ReceiptCreation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReceiptCreation.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "parsing Error";
    }

    public String applyReciept(RecieptApplyBody applyData) {
        setEnvironmentURL(applyData.getEnvironment());
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("text/xml");
            String xmlInput = payload.recieptApplyPayload(applyData);
            RequestBody body = RequestBody.create(mediaType, xmlInput);
            Request request
                    = new Request.Builder().url(getBaseUrl() + "/fscmService/StandardReceiptService?wsdl").post(body).addHeader("content-type",
                            "text/xml").addHeader("cache-control",
                                    "no-cache").addHeader("SOAPACTION", "createApplyReceipt").build();
            Response response = null;

            response = client.newCall(request).execute();

            InputStream isr = response.body().byteStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }
            String responseString = out.toString();
            System.out.println(responseString);

            if (response.code() == 200) {
                return "Receipt applied";
            } else {
                return "Failure in Reciept apply payload";
            }
        } catch (IOException ex) {
            Logger.getLogger(InvokeWebService.class.getName()).log(Level.SEVERE, null, ex);
            return "Failure in Invoking the receipt apply webservice";
        }
    }

    public String cancelReciept(RecieptCancelBody recieptCancelBody) {
        setEnvironmentURL(recieptCancelBody.getEnvironment());
        try {
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("text/xml");
            String xmlInput = payload.cancelRecieptPayload(recieptCancelBody);
            RequestBody body = RequestBody.create(mediaType, xmlInput);
            Request request
                    = new Request.Builder().url(getBaseUrl() + "/fscmService/StandardReceiptService?WSDL").post(body).addHeader("content-type",
                            "text/xml").addHeader("cache-control",
                                    "no-cache").addHeader("SOAPACTION", "createReverseReceipt").build();
            Response response = null;

            response = client.newCall(request).execute();
            InputStream isr = response.body().byteStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(isr));
            StringBuilder out = new StringBuilder();
            String resultsXml;
            while ((resultsXml = reader.readLine()) != null) {
                out.append(resultsXml);
            }

            System.out.println("Response   :" + out.toString());
            if (response.code() == 200) {
                return "The Reciept is reversed successfully";
            } else {
                return "Error in payload or the reciept id is already reversed";
            }
        } catch (IOException ex) {
            Logger.getLogger(InvokeWebService.class.getName()).log(Level.SEVERE, null, ex);
            return "Error in Invoking webservice of Reciept Cancellation";
        }
    }
}
