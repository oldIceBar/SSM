package com.excel;

import com.excel.annotation.ExcelDataCell;
import com.excel.annotation.ExcelTableHead;

@ExcelTableHead(cells = {"名称","价格","描述","品质"})
public class Fruit {
    private String name ;
    private Double price;
    private String description;
    private Level level;

    public Fruit(String name, double price, String description, Level level) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.level = level;
    }

    @ExcelDataCell(order = 0,dataType = ExcelDataCell.DataType.JAVA_TYPE,actionType = ExcelDataCell.ActionType.EXPORT)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ExcelDataCell(order = 1,dataType = ExcelDataCell.DataType.JAVA_TYPE,actionType = ExcelDataCell.ActionType.EXPORT)
    public Double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @ExcelDataCell(order = 2,dataType = ExcelDataCell.DataType.JAVA_TYPE,actionType = ExcelDataCell.ActionType.EXPORT)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @ExcelDataCell(order = 3,dataType = ExcelDataCell.DataType.ENUM,actionType = ExcelDataCell.ActionType.EXPORT)
    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    enum Level{
        LOW,NORMAL,HIGH;
    }
}
