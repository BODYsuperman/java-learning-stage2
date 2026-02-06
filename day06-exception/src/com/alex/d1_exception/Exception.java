package com.alex.d1_exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Exception {

    public Exception(String message) {
    }

    public static void main(String[] args) {


        parseData("2026-02-06 15:30:45"); // 正常解析
        parseData("2026-02-30 15:30:45"); // 无效日期（2月无30天），解析失败
        parseData("2026/02/06 15:30");    // 格式不匹配，解析失败

        int[] arr = {11, 22, 33};

        System.out.println(arr[3]);//ArrayIndexOutOfBoundsException

        String name = null;
        System.out.println(name.length());//NullPoniterException

        System.out.println(10 / 0);//ArithmeticException

        Object o = "Alan";
        Integer i = (Integer) o;//ClassCastException

        String s = "a23";
        int it = Integer.valueOf(s);//NumberFormatException
        System.out.println(it);

    }


    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void parseData(String s) {
        try {
            // 解析字符串为LocalDateTime对象（替代原Date）
            LocalDateTime dateTime = LocalDateTime.parse(s, FORMATTER);
            System.out.println("解析成功：" + dateTime);
            // 拓展：直接获取年、月、日等信息，无需额外处理（原Date需要Calendar，很繁琐）
            int year = dateTime.getYear();
            int month = dateTime.getMonthValue(); // 月份从1开始（符合日常认知）
            int day = dateTime.getDayOfMonth();
            System.out.printf("年：%d，月：%d，日：%d%n", year, month, day);
        } catch (DateTimeParseException e) {
            // 解析失败处理（格式不匹配、无效日期）
            System.out.println("日期解析失败！入参格式必须为：yyyy-MM-dd HH:mm:ss，错误原因：" + e.getMessage());
        }
    }




}
