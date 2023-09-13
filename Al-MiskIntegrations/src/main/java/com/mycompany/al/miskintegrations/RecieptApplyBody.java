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
public class RecieptApplyBody {

    private String amountApplied;
    private String comments;
    private String customerTrxId;
    private String receipt_Number;
    private String receiptAmount;
    private String receipt_Date;
    private String transactionDate;
    private String accountingDate;
    private String applicationDate;
    private String currencyCode;
    private String cashRecieptId;
    private String environment;

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getCashRecieptId() {
        return cashRecieptId;
    }

    public void setCashRecieptId(String cashRecieptId) {
        this.cashRecieptId = cashRecieptId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getAmountApplied() {
        return amountApplied;
    }

    public void setAmountApplied(String amountApplied) {
        this.amountApplied = amountApplied;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getCustomerTrxId() {
        return customerTrxId;
    }

    public void setCustomerTrxId(String customerTrxId) {
        this.customerTrxId = customerTrxId;
    }

    public String getReceipt_Number() {
        return receipt_Number;
    }

    public void setReceipt_Number(String receipt_Number) {
        this.receipt_Number = receipt_Number;
    }

    public String getReceiptAmount() {
        return receiptAmount;
    }

    public void setReceiptAmount(String receiptAmount) {
        this.receiptAmount = receiptAmount;
    }

    public String getReceipt_Date() {
        return receipt_Date;
    }

    public void setReceipt_Date(String receipt_Date) {
        this.receipt_Date = receipt_Date;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getAccountingDate() {
        return accountingDate;
    }

    public void setAccountingDate(String accountingDate) {
        this.accountingDate = accountingDate;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

}
