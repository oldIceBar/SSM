package com.excel.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelDataCell {
    int order();
    DataType dataType() default DataType.JAVA_TYPE;

    ActionType actionType() default ActionType.EXPORT;
    enum DataType{
        JAVA_TYPE,PERCENTAGE,ENUM
    }
    enum ActionType{
        EXPORT,IMPORT
    }
    int length() default 0;
}
