package com.fragma.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MainDto {

    static Logger LOG = LoggerFactory.getLogger(MainDto.class);

    public Map<Integer, ExcelHtml> excelMap = new HashMap<>();
    public Map<String, SummaryHtml> summaryHtmlMap = new HashMap<>();
    public Set<String> summaryHtmlMaptoset = new LinkedHashSet<>();

    public LocalDate todayDate;

    public LocalDate getTodayDate() {
        return todayDate;
    }


    public Map<String, SummaryHtml> getSummaryHtmlMap() {
        return summaryHtmlMap;
    }

    public String subDate(){
        LocalDate yesturday=todayDate.minusDays(1);
        String date = yesturday.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        return date;

    }

    public void setTodayDate(LocalDate todayDate) {
        this.todayDate = todayDate;
    }

    public Map<Integer, ExcelHtml> getExcelMap() {
        return excelMap;
    }

    public void addAccountNumberToSet(String unit) {
        System.out.println("Unit:"+unit);
        summaryHtmlMaptoset.add(unit);
    }

    public Set<String> getSummaryHtmlMaptoset() {
        return summaryHtmlMaptoset;
    }



    public String doubleToString(double amount)
    {
        if(Double.compare(amount,0.0D)==0)
        {
            return "0.00";
        }
        else {
            DecimalFormat df = new DecimalFormat("#,###.00"); // or pattern "###,###.##$"
            return df.format(amount);
        }
    }

    public String longToString(long amount)
    {
        if(amount== 0)
        {
            return "0";
        }
        else {

            DecimalFormat df = new DecimalFormat("0"); // or pattern "###,###.##$"

            NumberFormat nf= NumberFormat.getInstance();
            nf.setGroupingUsed(true);
            return df.format(amount);
        }
    }

    public String isNullOrEmpty(String  value)
    {
        if(value == null || value.isEmpty() || value.equals("\"\""))
        {
            return "-";
        }
        else
            return  value;
    }

    public String getColor(String str) {

        if (str.equalsIgnoreCase("Y")|| str.equalsIgnoreCase("O"))
            return "green";
        else
            return "red";

    }
    public String getCardColor(String str) {

        if (str.equalsIgnoreCase("Y")|| str.equalsIgnoreCase("O"))
            return "green";
        else
            return "red";

    }

    public void populateSummaryData(String unit, String productOwner, long totalMessages, long noHits, long transactionWithHits, long userTrns, long reapplyTrns, long firstTime, long repeatedTrns, long changeInMessage, long changeInParty, long changeInEdms, long changeInAmount, long changeInExpiryDate, long changeInValueDate) {

        SummaryHtml summaryHtml = summaryHtmlMap.get(unit);
        addAccountNumberToSet(unit);

        if (summaryHtml == null) {
            summaryHtml = new SummaryHtml();
        }
        summaryHtml.setUnit(unit);
        summaryHtml.setProductOwner(productOwner);
        summaryHtml.setTotalMessages(totalMessages);
        summaryHtml.setNoHits(noHits);
        summaryHtml.setTransactionWithHits(transactionWithHits);
        summaryHtml.setUserTrns(userTrns);
        summaryHtml.setReapplyTrns(reapplyTrns);
        summaryHtml.setFirstTime(firstTime);
        summaryHtml.setRepeatedTrns(repeatedTrns);
        summaryHtml.setChangeInMessage(changeInMessage);
        summaryHtml.setChangeInParty(changeInParty);
        summaryHtml.setChangeInEdms(changeInEdms);
        summaryHtml.setChangeInAmount(changeInAmount);


        summaryHtml.setChangeInExpiryDate(changeInExpiryDate);
        summaryHtml.setChangeInValueDate(changeInValueDate);

        summaryHtmlMap.put(unit, summaryHtml);

    }

    public void populateData(int SLNo, String state, String exception, String decision, String transactionOurRefNo, String filteredDate, String lastOperator, String decisionType, String unit, String currency, String amount, String checker, String checkerComments, String hits, String change_in_hits) {

        ExcelHtml excelHtml = excelMap.get(SLNo);

        if (excelHtml == null) {
            excelHtml = new ExcelHtml();
        }
        excelHtml.setState(state);
        excelHtml.setException(exception);
        excelHtml.setDecision(decision);
        excelHtml.setTransactionOurRefNo(transactionOurRefNo);
        excelHtml.setFilteredDate(filteredDate);
        excelHtml.setLastOperator(lastOperator);
        excelHtml.setDecisionType(decisionType);
        excelHtml.setUnit(unit);
        excelHtml.setCurrency(currency);
        excelHtml.setAmount(amount);
        excelHtml.setChecker(checker);
        excelHtml.setCheckerComments(checkerComments);
        excelHtml.setHits(hits);
        excelHtml.setChange_in_hits(change_in_hits);

        excelMap.put(SLNo, excelHtml);

    }
}
