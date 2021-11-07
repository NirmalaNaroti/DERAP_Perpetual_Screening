package com.fragma.service;

import com.fragma.dto.EndOfDay;
import com.fragma.dto.ExcelHtml;
import com.fragma.dto.MainDto;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Map;

@Service
public class ExcelFileCreator {

    private static final Logger LOG = LoggerFactory.getLogger(ExcelFileCreator.class);

      XSSFWorkbook workbook = new XSSFWorkbook();
    DecimalFormat df = new DecimalFormat("#,###.00");

    public void createAllSheets(String excelFileLocation, MainDto mainDto) throws Exception {

        createEODSheet(mainDto, "DERAP-Perpetual_Screening");

        FileOutputStream out = new FileOutputStream(excelFileLocation);
        this.workbook.write(out);
        out.close();
        LOG.info(" Excel file written successfully on disk at :" + excelFileLocation);
    }

    private void createEODSheet(MainDto mainDto, String sheetName) throws Exception {

        LOG.info("***** executing createEODSheet ****** ");

        Font headingFont = workbook.createFont();
        headingFont.setBold(true);

        XSSFColor orange = new XSSFColor(new java.awt.Color(182, 207, 242));

        XSSFCellStyle headingCellStyle = workbook.createCellStyle();

        headingCellStyle.setFont(headingFont);
        headingCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        headingCellStyle.setFillForegroundColor(orange);
        headingCellStyle.setBorderBottom(BorderStyle.THIN);
        headingCellStyle.setBorderLeft(BorderStyle.THIN);
        headingCellStyle.setBorderRight(BorderStyle.THIN);
        headingCellStyle.setBorderTop(BorderStyle.THIN);
        headingCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        headingCellStyle.setAlignment(HorizontalAlignment.CENTER);
        headingCellStyle.setWrapText(true);

        XSSFColor lightOrange = new XSSFColor(new java.awt.Color(255, 216, 151));

        XSSFCellStyle MainHeadingCellStyle = workbook.createCellStyle();

        MainHeadingCellStyle.setFont(headingFont);
        MainHeadingCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        MainHeadingCellStyle.setFillForegroundColor(lightOrange);
        MainHeadingCellStyle.setBorderBottom(BorderStyle.THIN);
        MainHeadingCellStyle.setBorderLeft(BorderStyle.THIN);
        MainHeadingCellStyle.setBorderRight(BorderStyle.THIN);
        MainHeadingCellStyle.setBorderTop(BorderStyle.THIN);
        MainHeadingCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        MainHeadingCellStyle.setAlignment(HorizontalAlignment.CENTER);
        MainHeadingCellStyle.setWrapText(true);

        CellStyle bordersOnly = workbook.createCellStyle();
        bordersOnly.setBorderBottom(BorderStyle.THIN);
        bordersOnly.setBorderLeft(BorderStyle.THIN);
        bordersOnly.setBorderRight(BorderStyle.THIN);
        bordersOnly.setBorderTop(BorderStyle.THIN);
        bordersOnly.setAlignment(HorizontalAlignment.CENTER);
        bordersOnly.setVerticalAlignment(VerticalAlignment.CENTER);

        CellStyle bordersOnlyRed = workbook.createCellStyle();
        bordersOnlyRed.setBorderBottom(BorderStyle.THIN);
        bordersOnlyRed.setBorderLeft(BorderStyle.THIN);
        bordersOnlyRed.setBorderRight(BorderStyle.THIN);
        bordersOnlyRed.setBorderTop(BorderStyle.THIN);
        bordersOnlyRed.setAlignment(HorizontalAlignment.CENTER);
        bordersOnlyRed.setVerticalAlignment(VerticalAlignment.CENTER);

        XSSFFont font = workbook.createFont();
        font.setFontName(XSSFFont.DEFAULT_FONT_NAME);
        font.setFontHeightInPoints((short)10);
        font.setColor(IndexedColors.RED.getIndex());

        bordersOnlyRed.setFont(font);

        CellStyle bordersOnlyGreen = workbook.createCellStyle();
        bordersOnlyGreen.setBorderBottom(BorderStyle.THIN);
        bordersOnlyGreen.setBorderLeft(BorderStyle.THIN);
        bordersOnlyGreen.setBorderRight(BorderStyle.THIN);
        bordersOnlyGreen.setBorderTop(BorderStyle.THIN);
        bordersOnlyGreen.setAlignment(HorizontalAlignment.CENTER);
        bordersOnlyGreen.setVerticalAlignment(VerticalAlignment.CENTER);

        XSSFFont greenFont = workbook.createFont();
        greenFont.setFontName(XSSFFont.DEFAULT_FONT_NAME);
        greenFont.setFontHeightInPoints((short)10);
        greenFont.setColor(IndexedColors.GREEN.getIndex());

        bordersOnlyGreen.setFont(greenFont);



        Sheet sheet = workbook.createSheet(sheetName);



        int rowNum=1;

        Row headingRow = sheet.createRow(rowNum++);
        headingRow.setHeight((short) 900);

        int headingColmIndx = 0;

        createCellAddData(headingRow, headingColmIndx++, "STATE", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "EXCEPTION", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "REASON", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "TRANSACTION OUR REF NO", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "FILTERED DATE", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "LAST OPERATOR", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "DECISION TYPE", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "UNIT", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "CURRENCY", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "AMOUNT", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "CHECKER", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "CHECKER COMMENTS", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "NO OF HITS", headingCellStyle);
        createCellAddData(headingRow, headingColmIndx++, "Change in HIT", headingCellStyle);



        for (Map.Entry<Integer, ExcelHtml> tdEntry : mainDto.getExcelMap().entrySet()) {

            Row row = sheet.createRow(rowNum++);
            int cell = 0;


            createCellAddData(row, cell++, tdEntry.getValue().getState(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getException(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getDecision(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getTransactionOurRefNo(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getFilteredDate(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getLastOperator(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getDecisionType(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getUnit(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getCurrency(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getAmount(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getChecker(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getCheckerComments(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getHits(), bordersOnly);
            createCellAddData(row, cell++, tdEntry.getValue().getChange_in_hits(), bordersOnly);

        }

        for (int i = 0; i <= sheet.getRow(1).getLastCellNum(); i++) {

            sheet.autoSizeColumn(i);
            int columnWidth = sheet.getColumnWidth(i);
            sheet.setColumnWidth(i, columnWidth + 1000);
        }
    }

    public void createCellAddData(Row row, int cellNo, String cellValue, CellStyle cellStyle) {
        Cell cell = row.createCell(cellNo);
        cell.setCellValue(cellValue);
        cell.setCellStyle(cellStyle);
    }

}