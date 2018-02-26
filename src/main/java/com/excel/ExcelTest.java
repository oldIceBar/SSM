package com.excel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExcelTest {
    public static void main(String[] args) {
        List fruits = new ArrayList();
//        fruits.add(new Fruit("orange",5,"橘子", Fruit.Level.HIGH));
//        fruits.add(new Fruit("peach",8,"桃子", Fruit.Level.HIGH));
//        fruits.add(new Fruit("apple",6,"苹果", Fruit.Level.LOW));
//        ExcelGenerator.generateExcel("entitySheeet",fruits,Fruit.class);
        char[] a = new char[5];
         Arrays.fill(a,'2');
        System.out.println(a);
        System.out.println(a.toString());

        System.out.println(new String(a));

    }
}
