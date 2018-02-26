package com.excel.generator;

import com.excel.annotation.ExcelDataCell;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class DataRowsGenerator {
    public static void generateDataRows(List<T> entities, Class clazz, Sheet sheet, Workbook workbook) {
        List<Method> cellsMethod = new ArrayList<>();
        cellsMethod = Arrays.stream(clazz.getDeclaredMethods()).filter(m -> m.getAnnotation(ExcelDataCell.class) != null && m.getAnnotation(ExcelDataCell.class).actionType() == ExcelDataCell.ActionType.EXPORT).sorted(new Comparator<Method>() {
            @Override
            public int compare(Method o1, Method o2) {
                return o1.getAnnotation(ExcelDataCell.class).order() - o2.getAnnotation(ExcelDataCell.class).order();
            }
        }).collect(Collectors.toList());
        for (int i = 0; i < entities.size(); i++) {
            Row row = sheet.createRow(i + 1);
            Object entity = entities.get(i);
            for (int j = 0; j < cellsMethod.size(); j++) {
                Cell cell = row.createCell(j);
                setCellValueAndStyle(cell, cellsMethod.get(j), entity, workbook);
            }
        }
    }

    private static void setCellValueAndStyle(Cell cell, Method method, Object entity, Workbook workbook) {
        method.setAccessible(true);
        try {
            Object value = method.invoke(entity);
            ExcelDataCell.DataType dataType = method.getAnnotation(ExcelDataCell.class).dataType();
            if (dataType == ExcelDataCell.DataType.JAVA_TYPE) {
                setCellValueAndStyleJavaType(value, cell, workbook, method);
            } else {
                setCellValueAndStyleOthers(value, cell, workbook, dataType);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void setCellValueAndStyleOthers(Object value, Cell cell, Workbook workbook, ExcelDataCell.DataType dataType) {
        try {
            switch (dataType) {
                case PERCENTAGE:
                    break;
                case ENUM:
                    cell.setCellValue(((Enum)value).name());
                    break;
                default:
                    throw new RuntimeException("暂不支持该类型");
            }
        }catch (Exception e){
            System.out.println("Set value fail for row"+cell.getRowIndex()+"clomn"+cell.getColumnIndex());
        }
    }

    private static void setCellValueAndStyleJavaType(Object value, Cell cell, Workbook workbook, Method method) {
        try {
            String javaType = method.getReturnType().getName();
            switch (javaType) {
                case "java.lang.String":
                    cell.setCellValue((String) value);
                    break;
                case "java.lang.Integer":
                    cell.setCellValue((Integer) value);
                    break;
                case "java.lang.Long":
                    cell.setCellValue((Long) value);
                    break;
                case "java.lang.Double":
                    cell.setCellValue((Double)value);
                    break;
                default:
                    throw new RuntimeException("暂不支持该类型");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Set value fail for row"+cell.getRowIndex()+"clomn"+cell.getColumnIndex());
        }
    }
}
