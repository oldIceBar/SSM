package com.excel.generator;

import com.excel.annotation.ExcelTableHead;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class SheetHeadGenerator {
    public static void generateSheetHead(Sheet sheet,Class clazz){
        ExcelTableHead excelTableHead = (ExcelTableHead) clazz.getAnnotation(ExcelTableHead.class);
        Row headRow = sheet.createRow(0);
        String[] cells = excelTableHead.cells();
        for(int i =0;i<cells.length;i++){
            Cell cell = headRow.createCell(i);
            cell.setCellValue(cells[i]);
        }
    }
}
