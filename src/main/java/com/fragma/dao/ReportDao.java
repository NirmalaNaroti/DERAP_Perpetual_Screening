package com.fragma.dao;

import com.fragma.config.ConfigurationHelper;
import com.fragma.dto.MainDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class ReportDao {

    static Logger LOG = LoggerFactory.getLogger(ReportDao.class);

    private final JdbcTemplate jdbcTemplate;
    private final ConfigurationHelper configurationHelper;
    int SLNo=0;

    @Autowired
    public ReportDao(@Qualifier("hiveJdbcTemplate") JdbcTemplate jdbcTemplate, ConfigurationHelper configurationHelper) {
        this.jdbcTemplate = jdbcTemplate;
        this.configurationHelper = configurationHelper;

    }

    public void getData(MainDto mainDto){
        LOG.info("***** executing getData *****");
        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                LOG.info("Query = "+ ConfigurationHelper.getQuery() );
                PreparedStatement ps = connection.prepareStatement(ConfigurationHelper.getQuery());

                return ps;
            }
        },new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {

                String state = isNullOrEmpty(resultSet.getString("state"));
                String exception = isNullOrEmpty(resultSet.getString("exception"));
                String decision = isNullOrEmpty(resultSet.getString("decision"));
                String transactionOurRefNo = isNullOrEmpty(resultSet.getString("transaction_our_ref_no"));
                String filteredDate = isNullOrEmpty(resultSet.getString("filtered_Date"));
                String lastOperator = isNullOrEmpty(resultSet.getString("last_operator"));
                String decisionType = isNullOrEmpty(resultSet.getString("decision_type"));
                String unit = isNullOrEmpty(resultSet.getString("unit"));
                String currency = isNullOrEmpty(resultSet.getString("currency"));
                String amount = isNullOrEmpty(resultSet.getString("amount"));
                String checker = isNullOrEmpty(resultSet.getString("checker"));
                String checkerComments = isNullOrEmpty(resultSet.getString("checker_comments"));
                String hits = isNullOrEmpty(resultSet.getString("hits"));
                String change_in_hits = isNullOrEmpty(resultSet.getString("change_in_hits"));



                LOG.info("state:"+state+"exception:"+exception+"decision:"+decision+"transactionOurRefNo:"+transactionOurRefNo+"filteredDate:"+filteredDate+"lastOperator:"+lastOperator+"decisionType"+decisionType+"unit"+unit+"currency"+currency+"amount"+amount+"checker"+checker+"checkerComments"+checkerComments+"hits"+hits+"change_in_hits"+change_in_hits);

               // mainDto.addAccountNumberToSet(++SLNo);

                mainDto.populateData(++SLNo,state,exception,decision,transactionOurRefNo,filteredDate,lastOperator,decisionType,unit,currency,amount,checker,checkerComments,hits,change_in_hits);
            }
        });
    }

    public void getSummaryData(MainDto mainDto){
        LOG.info("***** executing getData *****");
        jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                LOG.info("Query = "+ ConfigurationHelper.getSummaryQuery() );
                PreparedStatement ps = connection.prepareStatement(ConfigurationHelper.getSummaryQuery());

                return ps;
            }
        },new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {

                String unit =isNullOrEmpty(resultSet.getString("unit"));
                String productOwner = isNullOrEmpty(resultSet.getString("product_owner"));
                long totalMessages = resultSet.getLong("total_messages");
                long noHits = resultSet.getLong("no_hits");
                long transactionWithHits = resultSet.getLong("transaction_with_hits");
                long userTrns = resultSet.getLong("user_trns");
                long reapplyTrns = resultSet.getLong("reapply_trns");
                long firstTime = resultSet.getLong("first_time");
                long repeatedTrns = resultSet.getLong("repeated_trns");
                long changeInMessage = resultSet.getLong("change_in_message");
                long changeInParty = resultSet.getLong("change_in_party");
                long changeInEdms = resultSet.getLong("change_in_edms");
                long changeInAmount = resultSet.getLong("change_in_amount");
                long changeInExpiryDate = resultSet.getLong("change_in_expiry_date");
                long changeInValueDate = resultSet.getLong("change_in_value_date");


                LOG.info("unit:"+unit+"productOwner:"+productOwner+"totalMessages:"+totalMessages+"noHits:"+noHits+"transactionWithHits:"+transactionWithHits+"userTrns:"+userTrns+"reapplyTrns"+reapplyTrns+"firstTime"+firstTime+"repeatedTrns"+repeatedTrns+"changeInMessage"+changeInMessage+"changeInParty"+changeInParty+"changeInEdms"+changeInEdms+"changeInAmount"+changeInAmount+"changeInExpiryDate"+changeInExpiryDate+"changeInValueDate"+changeInValueDate);

               // mainDto.addAccountNumberToSet(++SLNo);

                mainDto.populateSummaryData(unit,productOwner,totalMessages,noHits,transactionWithHits,userTrns,reapplyTrns,firstTime,repeatedTrns,changeInMessage,changeInParty,changeInEdms,changeInAmount,changeInExpiryDate,changeInValueDate);
            }
        });
    }

    public String isNullOrEmpty(String value) {
        if (value == null || value.isEmpty() || value.equalsIgnoreCase("\"\"")) {
            return " ";
        } else
            return value;
    }
}
