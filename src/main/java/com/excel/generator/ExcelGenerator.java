package com.excel.generator;


import com.excel.util.PropertiesLoader;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ExcelGenerator {
    final private static Logger LOGGER = Logger.getLogger(ExcelGenerator.class);
    final private static String EXCEL_DIRECTORY = PropertiesLoader.getProperty("excel.file.dir");
    public static void generateExcel(String sheetName, List<T> entities,Class clazz) {
        File file = new File(EXCEL_DIRECTORY);
        if (!file.exists()){
            file.mkdir();
        }
        File f = new File(EXCEL_DIRECTORY+"/"+sheetName+".xls");
        HSSFWorkbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);
        SheetHeadGenerator.generateSheetHead(sheet,clazz);
        DataRowsGenerator.generateDataRows(entities,clazz,sheet,workbook);
        try {
            workbook.write(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
