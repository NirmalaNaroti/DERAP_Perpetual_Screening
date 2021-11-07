package com.fragma.dto;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class EndOfDay {

    private String accountNumber;
    private String accountCurrency;
    private String accountClass;
    private String accountTitle;
    private long previousDayBalance;
    private long reportDayBalance;
    private String atmFacility;
    private String chequeFacility;
    private  String noDebit;
    private String noCredit;
    private String accountStatus;
    private String lastCreditDate;
    private String lastDebitDate;
    private Double lastCreditAmount;
    private Double lastDebitAmount;
    private String rmName;


    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountCurrency() {
        return accountCurrency;
    }

    public void setAccountCurrency(String accountCurrency) {
        this.accountCurrency = accountCurrency;
    }

    public String getAccountClass() {
        return accountClass;
    }

    public void setAccountClass(String accountClass) {
        this.accountClass = accountClass;
    }

    public String getAccountTitle() {
        return accountTitle;
    }

    public void setAccountTitle(String accountTitle) {
        this.accountTitle = accountTitle;
    }

    public long getPreviousDayBalance()
    {

        return previousDayBalance;
    }

    public void setPreviousDayBalance(long previousDayBalance) {
        this.previousDayBalance = previousDayBalance;
    }

    public long getReportDayBalance() {
        return reportDayBalance;
    }

    public void setReportDayBalance(long reportDayBalance) {
        this.reportDayBalance = reportDayBalance;
    }

    public String getAtmFacility() {
        return atmFacility;
    }

    public void setAtmFacility(String atmFacility) {
        this.atmFacility = atmFacility;
    }

    public String getChequeFacility() {
        return chequeFacility;
    }

    public void setChequeFacility(String chequeFacility) {
        this.chequeFacility = chequeFacility;
    }

    public String getNoDebit() {
        return noDebit;
    }

    public void setNoDebit(String noDebit) {
        this.noDebit = noDebit;
    }

    public String getNoCredit() {
        return noCredit;
    }

    public void setNoCredit(String noCredit) {
        this.noCredit = noCredit;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
    }

    public String getLastCreditDate() {
        return lastCreditDate;
    }

    public void setLastCreditDate(String lastCreditDate) {
        this.lastCreditDate = lastCreditDate;
    }

    public String getLastDebitDate() {
        return lastDebitDate;
    }

    public void setLastDebitDate(String lastDebitDate) {
        this.lastDebitDate = lastDebitDate;
    }

    public Double getLastCreditAmount() {
        return lastCreditAmount;
    }

    public void setLastCreditAmount(Double lastCreditAmount) {
        this.lastCreditAmount = lastCreditAmount;
    }

    public Double getLastDebitAmount() {
        return lastDebitAmount;
    }

    public void setLastDebitAmount(Double lastDebitAmount) {
        this.lastDebitAmount = lastDebitAmount;
    }

    public String getRmName() {
        return rmName;
    }

    public void setRmName(String rmName) {
        this.rmName = rmName;
    }
}
