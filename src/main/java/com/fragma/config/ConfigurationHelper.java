package com.fragma.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "conf")
public class ConfigurationHelper {

    private static String query;
    private static String summaryQuery;
    private static String excelLocation;

    public static String getQuery() {
        return query;
    }

    public static void setQuery(String query) {
        ConfigurationHelper.query = query;
    }

    public static String getSummaryQuery() {
        return summaryQuery;
    }

    public static void setSummaryQuery(String summaryQuery) {
        ConfigurationHelper.summaryQuery = summaryQuery;
    }

    public static String getExcelLocation() {
        return excelLocation;
    }

    public static void setExcelLocation(String excelLocation) {
        ConfigurationHelper.excelLocation = excelLocation;
    }
}
