package com.excel.util;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Properties;

public class PropertiesLoader {

    final private static String EXCEL_DIR = "excel.properties";
    private static Properties properties;

    private static Properties loadProperties(String propetyFileName){
        final Properties  properties = new Properties();
        try {
            properties.load(new InputStreamReader(PropertiesLoader.class.getClassLoader().getResourceAsStream(propetyFileName),"UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
    public static String getProperty(String key){
        if(Objects.isNull(properties)){
            initialProperties();
        }
        return properties.getProperty(key);
    }
    private static void initialProperties(){
        properties = new Properties();
        properties.putAll(loadProperties(EXCEL_DIR));
    }

}
