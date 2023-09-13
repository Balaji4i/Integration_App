/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.al.miskintegrations;

/**
 *
 * @author gautham.r
 */
public class WsPayload {

    PayloadUtility payloadUtility;
    private String userName;
    private String password;
    private String encoded;

    public PayloadUtility getPayloadUtility() {
        return payloadUtility;
    }

    public void setPayloadUtility(PayloadUtility payloadUtility) {
        this.payloadUtility = payloadUtility;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEncoded() {
        return encoded;
    }

    public void setEncoded(String encoded) {
        this.encoded = encoded;
    }

    public WsPayload() {
        payloadUtility = new PayloadUtility();
    }

    public void payloadCredentials(String environment) {
        if (environment == null || environment.equalsIgnoreCase("prod")) {
            setUserName(payloadUtility.prod_UserName);
            setPassword(payloadUtility.prod_Password);
            setEncoded(payloadUtility.prod_Encoded);
        } else {
            setUserName(payloadUtility.test_UserName);
            setPassword(payloadUtility.test_Password);
            setEncoded(payloadUtility.test_Encoded);
        }
    }

    public String invoiceInterfacePayload(BodyDeserialization bodyData) {
        payloadCredentials(bodyData.getEnvironment());
        String otherChargesNumber = bodyData.getOtherChargesNumber() != null ? bodyData.getOtherChargesNumber() : "";
        String invoiceInterface = "<soapenv:Envelope xmlns:inv=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tran=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionInterfaceGdf/\" xmlns:tran1=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/autoInvoices/model/flex/TransactionLineInterfaceGdf/\" xmlns:tran2=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineInterfaceLineDff/\" xmlns:tran3=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceLinkToDff/\" xmlns:tran4=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceReferenceDff/\" xmlns:tran5=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionLineDff/\" xmlns:tran6=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionInterfaceHeaderDff/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/types/\">\n"
                + "   <soapenv:Header>\n"
                + "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n"
                + "         <wsu:Timestamp wsu:Id=\"TS-8B960622638231FB7F15394482101538\">\n"
                + "            <wsu:Created>" + payloadUtility.getCreatedDate() + "</wsu:Created>\n"
                + "            <wsu:Expires>" + payloadUtility.getExpiredDate() + "</wsu:Expires>\n"
                + "         </wsu:Timestamp>\n"
                + "         <wsse:UsernameToken wsu:Id=\"UsernameToken-7A5DA39F515F1BF2A415269962607085\">\n"
                + "            <wsse:Username>" + getUserName() + "</wsse:Username>\n"
                + "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" + getPassword() + "</wsse:Password>\n"
                + "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">" + getEncoded() + "</wsse:Nonce>\n"
                + "            <wsu:Created>" + payloadUtility.getCreatedDate() + "</wsu:Created>\n"
                + "         </wsse:UsernameToken>\n"
                + "      </wsse:Security>\n"
                + "   </soapenv:Header>\n"
                + "   <soapenv:Body>\n"
                + "      <typ:createInterfaceLine>\n"
                + "         <typ:interfaceLine>\n"
                + "            <inv:OrgId>" + bodyData.getOrgId() + "</inv:OrgId>\n"
                + "            <inv:Amount currencyCode=\"" + bodyData.getCurrencyCode() + "\">" + bodyData.getAmount() + "</inv:Amount>\n"
                + "            <inv:BatchSourceName>" + bodyData.getBatchSourceName() + "</inv:BatchSourceName>\n"
                + "            <inv:CustomerTrxTypeName>" + bodyData.getCustomerTrxTypeName() + "</inv:CustomerTrxTypeName>\n"
                + "            <inv:BillCustomerAccountNumber>" + bodyData.getBillCustomerAccountNumber() + "</inv:BillCustomerAccountNumber>\n"
                + "            <inv:BillCustomerSiteNumber>" + bodyData.getBillCustomerSiteNumber() + "</inv:BillCustomerSiteNumber>\n"
                + "            <inv:BillingDate>" + bodyData.getBillingDate() + "</inv:BillingDate>\n"
                + "            <inv:Comments>" + bodyData.getComments() + "</inv:Comments>\n"
                + "            <inv:TrxDate>" + bodyData.getTrxDate() + "</inv:TrxDate>\n"
                + "            <inv:CurrencyCode>" + bodyData.getCurrencyCode() + "</inv:CurrencyCode>\n"
                + "            <inv:Description>" + bodyData.getDescription() + "</inv:Description>\n"
                + "            <inv:GlDate>" + bodyData.getGlDate() + "</inv:GlDate>\n"
                + "            <inv:InvoicingRuleName>" + bodyData.getInvoicingRuleName() + "</inv:InvoicingRuleName>\n"
                + "            <inv:AccountingRuleName>" + bodyData.getAccountingRuleName() + "</inv:AccountingRuleName>\n"
                + "            <inv:RuleStartDate>" + bodyData.getRuleStartDate() + "</inv:RuleStartDate>\n"
                + "            <inv:RuleEndDate>" + bodyData.getRuleEndDate() + "</inv:RuleEndDate>\n"
                + "            <inv:UnitSellingPrice currencyCode=\"" + bodyData.getCurrencyCode() + "\">" + bodyData.getUnitSellingPrice() + "</inv:UnitSellingPrice>\n"
                + "            <inv:LineType>" + bodyData.getLineType() + "</inv:LineType>\n"
                + "            <inv:Quantity>" + bodyData.getQuantity() + "</inv:Quantity>\n"
                + "            <inv:PaymentTermsName>" + bodyData.getPaymentTermsName() + "</inv:PaymentTermsName>\n"
                + "            <inv:TaxCode>" + bodyData.getTaxCode() + "</inv:TaxCode>\n"
                + "            <inv:TransactionLineDff>\n"
                + "               <!--<tran5:InterfaceLineGuid>?</tran5:InterfaceLineGuid>-->\n"
                + "               <tran5:unit>" + bodyData.getSegmentedCode() + "</tran5:unit>\n"
                + "               <!--<tran5:leaseNumber>LA-A20</tran5:leaseNumber>-->\n"
                + "               <!--<tran5:bookingNumber>BK-A20</tran5:bookingNumber>-->\n"
                + "               <!--<tran5:__FLEX_Context>?</tran5:__FLEX_Context>-->\n"
                + "               <!--<tran5:__FLEX_Context_DisplayValue>?</tran5:__FLEX_Context_DisplayValue>-->\n"
                + "               <!--<tran5:_FLEX_NumOfSegments>?</tran5:_FLEX_NumOfSegments>-->\n"
                + "            </inv:TransactionLineDff>\n"
                + "            <inv:TransactionInterfaceLineDff xsi:type=\"tran2:PropertyLeasing\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
                + "               <tran2:__FLEX_Context>" + bodyData.getFlexContext() + "</tran2:__FLEX_Context>\n"
                + "               <tran2:leaseNumber>" + bodyData.getLeaseNumber() + "</tran2:leaseNumber>\n"
                + "               <tran2:bookingNumber>" + bodyData.getBookingNumber() + "</tran2:bookingNumber>\n"
                + "               <tran2:transactions>" + bodyData.getTransactions() + "</tran2:transactions>\n"
//		+ "               <tran2:noOfTenantYears>" + bodyData.getTenantYears() + "</tran2:noOfTenantYears>\n"
		+ "               <tran2:cancellationNo>" + bodyData.getCancellationNo() + "</tran2:cancellationNo>\n"
//                + "                <tran2:leaseotherChg>" + otherChargesNumber + "</tran2:leaseotherChg>\n"
//                +"                  <tran2:otherChgAmount>"+otherChargesNumber+"</tran2:otherChgAmount>\n"
                + "            </inv:TransactionInterfaceLineDff>\n"
				+ "            <inv:TransactionInterfaceHeaderDff>\n"
				+ "               <tran6:leaseNumber>" + bodyData.getLeaseNumber() + "</tran6:leaseNumber>\n"
				+ "               <tran6:bookingNumber>" + bodyData.getBookingNumber() + "</tran6:bookingNumber>\n"
				+ "               <tran6:building>" + bodyData.getBuildingName() + "</tran6:building>\n"
				+ "               <tran6:unit>" + bodyData.getUnitName() + "</tran6:unit>\n"
				+ "               <tran6:cancellationNo>" + bodyData.getCancellationNo() + "</tran6:cancellationNo>\n"
				+ "            </inv:TransactionInterfaceHeaderDff>\n"
                + "         </typ:interfaceLine>\n"
                + "      </typ:createInterfaceLine>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        return invoiceInterface;
    }

    public String distributionPayload(BodyDeserialization bodyData) {
        String distribution = "<soapenv:Envelope xmlns:inv=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tran=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionInterfaceLineDff/\" xmlns:tran1=\"http://xmlns.oracle.com/apps/flex/financials/receivables/transactions/autoInvoices/TransactionDistributionDff/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/transactions/invoices/invoiceService/types/\">\n"
                + "   <soapenv:Header>\n"
                + "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n"
                + "         <wsu:Timestamp wsu:Id=\"TS-8B960622638231FB7F15394483404099\">\n"
                + "            <wsu:Created>" + payloadUtility.getCreatedDate() + "</wsu:Created>\n"
                + "            <wsu:Expires>" + payloadUtility.getExpiredDate() + "</wsu:Expires>\n"
                + "         </wsu:Timestamp>\n"
                + "         <wsse:UsernameToken wsu:Id=\"UsernameToken-7A5DA39F515F1BF2A415269962607085\">\n"
                + "            <wsse:Username>" + getUserName() + "</wsse:Username>\n"
                + "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" + getPassword() + "</wsse:Password>\n"
                + "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">" + getEncoded() + "</wsse:Nonce>\n"
                + "            <wsu:Created>" + payloadUtility.getCreatedDate() + "</wsu:Created>\n"
                + "         </wsse:UsernameToken>\n"
                + "      </wsse:Security>\n"
                + "   </soapenv:Header>\n"
                + "   <soapenv:Body>\n"
                + "      <typ:createInterfaceDistribution>\n"
                + "         <typ:interfaceDistribution>\n"
                + "            <inv:InterfaceLineId/>\n"
                + "            <inv:AccountClass>" + bodyData.getAccountClass() + "</inv:AccountClass>\n"
                + "            <!--<inv:AccountClass>REV</inv:AccountClass>-->\n"
                + "            <inv:CodeCombinationId>" + bodyData.getCcId() + "</inv:CodeCombinationId>\n"
                + "            <inv:InterimTaxCcid/>\n"
                + "            <inv:OrgId>" + bodyData.getOrgId() + "</inv:OrgId>\n"
                + "            <inv:Percent>100</inv:Percent>\n"
                + "            <inv:DistributionInterfacLineDff xsi:type=\"tran:PropertyLeasing\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
                + "               <tran:__FLEX_Context>Property_Leasing</tran:__FLEX_Context>\n"
                + "               <tran:leaseNumber>" + bodyData.getLeaseNumber() + "</tran:leaseNumber>\n"
                + "               <tran:bookingNumber>" + bodyData.getBookingNumber() + "</tran:bookingNumber>\n"
                + "               <tran:transactions>" + bodyData.getTransactions() + "</tran:transactions>\n"
                + "               <tran:cancellationNo>" + bodyData.getCancellationNo() + "</tran:cancellationNo>\n"
                + "            </inv:DistributionInterfacLineDff>\n"
                + "         </typ:interfaceDistribution>\n"
                + "      </typ:createInterfaceDistribution>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        return distribution;
    }

    public String codeCombinationPayload(BodyDeserialization bodyData, String codes[]) {
        String codeCombination = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/accountCombinationService/types/\" xmlns:acc=\"http://xmlns.oracle.com/apps/financials/generalLedger/accounts/codeCombinations/accountCombinationService/\">\n"
                + "   <soapenv:Header>\n"
                + "<wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n"
                + "         <wsu:Timestamp wsu:Id=\"TS-B6C9C3574217989111153199515459014\">\n"
                + "            <wsu:Created>" + payloadUtility.getCreatedDate() + "</wsu:Created>\n"
                + "            <wsu:Expires>" + payloadUtility.getExpiredDate() + "</wsu:Expires>\n"
                + "         </wsu:Timestamp>\n"
                + "         <wsse:UsernameToken wsu:Id=\"UsernameToken-B6C9C3574217989111153199494551212\">\n"
                + "            <wsse:Username>" + getUserName() + "</wsse:Username>\n"
                + "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" + getPassword() + "</wsse:Password>\n"
                + "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">" + getEncoded() + "</wsse:Nonce>\n"
                + "            <wsu:Created>" + payloadUtility.getCreatedDate() + "</wsu:Created>\n"
                + "         </wsse:UsernameToken>\n"
                + "      </wsse:Security>\n"
                + "   </soapenv:Header>\n"
                + "   <soapenv:Body>\n"
                + "      <typ:validateAndCreateAccounts>\n"
                + "         <typ:validationInputRowList>\n"
                + "            <acc:DynamicInsertion>" + bodyData.getDynamicInsertion() + "</acc:DynamicInsertion>\n"
                + "            <acc:Segment1>" + codes[0] + "</acc:Segment1>\n"
                + "            <acc:Segment2>" + codes[1] + "</acc:Segment2>\n"
                + "            <acc:Segment3>" + codes[2] + "</acc:Segment3>\n"
                + "            <acc:Segment4>" + codes[3] + "</acc:Segment4>\n"
                + "            <acc:Segment5>" + codes[4] + "</acc:Segment5>\n"
                + "            <acc:Segment6>" + codes[5] + "</acc:Segment6>\n"
                + "            <acc:Segment7>" + codes[6] + "</acc:Segment7>\n"
                + "            <acc:Segment8>" + codes[7] + "</acc:Segment8>\n"
                + "            <acc:LedgerName>" + bodyData.getLedgerName() + "</acc:LedgerName>\n"
                + "            <acc:EnabledFlag>" + bodyData.getEnabledFlag() + "</acc:EnabledFlag>\n"
                + "            <acc:FromDate>" + bodyData.getFromDate() + "</acc:FromDate>\n"
                + "            <acc:ToDate>" + bodyData.getToDate() + "</acc:ToDate>\n"
                + "         </typ:validationInputRowList>\n"
                + "      </typ:validateAndCreateAccounts>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";

        return codeCombination;
    }

    public String recieptCreationPayload(RecieptBody recieptData) {
        payloadCredentials(recieptData.getEnvironment());
        String createReciept = "<soapenv:Envelope xmlns:com=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:stan=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptDff/\" xmlns:stan1=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/model/flex/StandardReceiptGdf/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/types/\">\n"
                + "   <soapenv:Header>\n"
                + "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n"
                + "         <wsu:Timestamp wsu:Id=\"TS-F84AFFFAB131372E9415323382493425\">\n"
                + "            <wsu:Created>" + payloadUtility.getCreatedDate() + "</wsu:Created>\n"
                + "            <wsu:Expires>" + payloadUtility.getExpiredDate() + "</wsu:Expires>\n"
                + "         </wsu:Timestamp>\n"
                + "         <wsse:UsernameToken wsu:Id=\"UsernameToken-F84AFFFAB131372E9415323307403511\">\n"
                + "            <wsse:Username>" + getUserName() + "</wsse:Username>\n"
                + "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" + getPassword() + "</wsse:Password>\n"
                + "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">" + getEncoded() + "</wsse:Nonce>\n"
                + "            <wsu:Created>" + payloadUtility.getCreatedDate() + "</wsu:Created>\n"
                + "         </wsse:UsernameToken>\n"
                + "      </wsse:Security>\n"
                + "   </soapenv:Header>\n"
                + "   <soapenv:Body>\n"
                + "      <typ:createStandardReceipt>\n"
                + "         <typ:standardReceipt>\n"
                + "            <com:Amount currencyCode=\"" + recieptData.getCurrencyCode() + "\">" + recieptData.getAmount() + "</com:Amount>\n"
                + "            <com:CurrencyCode>" + recieptData.getCurrencyCode() + "</com:CurrencyCode>\n"
                + "            <com:Comments>" + recieptData.getComments() + "</com:Comments>\n"
                + "            <com:GlDate>" + recieptData.getGlDate() + "</com:GlDate>\n"
                + "            <com:MaturityDate>" + recieptData.getMaturityDate() + "</com:MaturityDate>\n"
                + "            <com:OrgId>" + recieptData.getOrgId() + "</com:OrgId>\n"
                + "            <com:CustomerId>" + recieptData.getCustomerId() + "</com:CustomerId>\n"
                + "            <com:ReceiptDate>" + recieptData.getReceiptDate() + "</com:ReceiptDate>\n"
                + "            <com:ReceiptMethodId>" + recieptData.getReceiptMethodId() + "</com:ReceiptMethodId>\n"
                + "            <com:ReceiptNumber>" + recieptData.getReceiptNumber() + "</com:ReceiptNumber>\n"
                + "            <com:StandardReceiptFLEXVA>\n"
                + "               <stan:leasenumber>" + recieptData.getLeaseNumber() + "</stan:leasenumber>\n"
                + "               <stan:bookingNumber>" + recieptData.getBookingNumber() + "</stan:bookingNumber>\n"
                + "                <stan:building>" + recieptData.getBuilding() + "</stan:building>\n"
                + "                <stan:unit>" + recieptData.getUnit() + "</stan:unit>\n"
                + "                <stan:checkNo>" + recieptData.getChequeNo() + "</stan:checkNo>\n"
                + "            </com:StandardReceiptFLEXVA>\n"
                + "         </typ:standardReceipt>\n"
                + "      </typ:createStandardReceipt>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";
        return createReciept;
    }

    public String recieptApplyPayload(RecieptApplyBody applyData) {
        payloadCredentials(applyData.getEnvironment());
        String applyReciept = "<soapenv:Envelope xmlns:app=\"http://xmlns.oracle.com/apps/flex/financials/receivables/receipts/shared/standardReceiptService/commonService/ApplyReceiptDff/\" xmlns:com=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/types/\">\n"
                + "   <soapenv:Header>\n"
                + "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n"
                + "         <wsu:Timestamp wsu:Id=\"TS-ED86EBB96492AA8DE315350062608487\">\n"
                + "            <wsu:Created>" + payloadUtility.getCreatedDate() + "</wsu:Created>\n"
                + "            <wsu:Expires>" + payloadUtility.getExpiredDate() + "</wsu:Expires>\n"
                + "         </wsu:Timestamp>\n"
                + "         <wsse:UsernameToken wsu:Id=\"UsernameToken-7A5DA39F515F1BF2A415269962607085\">\n"
                + "            <wsse:Username>" + getUserName() + "</wsse:Username>\n"
                + "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" + getPassword() + "</wsse:Password>\n"
                + "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">" + getEncoded() + "</wsse:Nonce>\n"
                + "            <wsu:Created>" + payloadUtility.getCreatedDate() + "</wsu:Created>\n"
                + "         </wsse:UsernameToken>\n"
                + "      </wsse:Security>\n"
                + "   </soapenv:Header>\n"
                + "   <soapenv:Body>\n"
                + "      <typ:createApplyReceipt>\n"
                + "         <typ:applyReceipt>\n"
                + "            <com:AmountApplied>" + applyData.getAmountApplied() + "</com:AmountApplied>\n"
                + "            <com:ReceiptId>" + applyData.getCashRecieptId() + "</com:ReceiptId>\n"
                + "            <com:Comments>" + applyData.getComments() + "</com:Comments>\n"
                + "            <com:CustomerTrxId>" + applyData.getCustomerTrxId() + "</com:CustomerTrxId>\n"
                + "            <com:ReceiptNumber>" + applyData.getReceipt_Number() + "</com:ReceiptNumber>\n"
                + "            <com:ReceiptAmount currencyCode=\"" + applyData.getCurrencyCode() + "\">" + applyData.getReceiptAmount() + "</com:ReceiptAmount>\n"
                + "            <com:ReceiptDate>" + applyData.getReceipt_Date() + "</com:ReceiptDate>\n"
                + "            <com:TransactionDate>" + applyData.getTransactionDate() + "</com:TransactionDate>\n"
                + "            <com:ApplicationDate>" + applyData.getApplicationDate() + "</com:ApplicationDate>\n"
                + "            <com:AccountingDate>" + applyData.getAccountingDate() + "</com:AccountingDate>\n"
                + "         </typ:applyReceipt>\n"
                + "      </typ:createApplyReceipt>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";
        return applyReciept;
    }

    public String cancelRecieptPayload(RecieptCancelBody recieptCancelBody) {
        payloadCredentials(recieptCancelBody.getEnvironment());
        String recieptCancel = "<soapenv:Envelope xmlns:com=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:typ=\"http://xmlns.oracle.com/apps/financials/receivables/receipts/shared/standardReceiptService/commonService/types/\">\n"
                + "   <soapenv:Header>\n"
                + "      <wsse:Security soapenv:mustUnderstand=\"1\" xmlns:wsse=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd\" xmlns:wsu=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-utility-1.0.xsd\">\n"
                + "         <wsse:UsernameToken wsu:Id=\"UsernameToken-B6C9C3574217989111153200179538920\">\n"
                + "            <wsse:Username>" + getUserName() + "</wsse:Username>\n"
                + "            <wsse:Password Type=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-username-token-profile-1.0#PasswordText\">" + getPassword() + "</wsse:Password>\n"
                + "            <wsse:Nonce EncodingType=\"http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-soap-message-security-1.0#Base64Binary\">" + getEncoded() + "</wsse:Nonce>\n"
                + "            <wsu:Created>" + payloadUtility.getCreatedDate() + "</wsu:Created>\n"
                + "         </wsse:UsernameToken>\n"
                + "         <wsu:Timestamp wsu:Id=\"TS-B6C9C3574217989111153200178953019\">\n"
                + "            <wsu:Created>" + payloadUtility.getCreatedDate() + "</wsu:Created>\n"
                + "            <wsu:Expires>" + payloadUtility.getExpiredDate() + "</wsu:Expires>\n"
                + "         </wsu:Timestamp>\n"
                + "      </wsse:Security>\n"
                + "   </soapenv:Header>\n"
                + "   <soapenv:Body>\n"
                + "      <typ:createReverseReceipt>\n"
                + "         <typ:reverseReceipt>\n"
                + "            <com:ReceiptNumber>" + recieptCancelBody.getReceiptNumber() + "</com:ReceiptNumber>\n"
                + "            <com:ReversalCategory>" + recieptCancelBody.getReversalCategory() + "</com:ReversalCategory>\n"
                + "            <com:ReversalDate>" + recieptCancelBody.getReversalDate() + "</com:ReversalDate>\n"
                + "            <com:ReversalReasonCode>" + recieptCancelBody.getReversalReasonCode() + "</com:ReversalReasonCode>\n"
                + "            <com:ReversalComments>" + recieptCancelBody.getReversalComments() + "</com:ReversalComments>\n"
                + "            <com:BusinessUnit>" + recieptCancelBody.getBusinessUnit() + "</com:BusinessUnit>\n"
                + "            <com:ReversalGlDate>" + recieptCancelBody.getReversalGlDate() + "</com:ReversalGlDate>\n"
                + "         </typ:reverseReceipt>\n"
                + "      </typ:createReverseReceipt>\n"
                + "   </soapenv:Body>\n"
                + "</soapenv:Envelope>";
        return recieptCancel;
    }

}
