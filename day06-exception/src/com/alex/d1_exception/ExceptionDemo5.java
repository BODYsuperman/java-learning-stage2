package com.alex.d1_exception;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.Exception;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExceptionDemo5 {

    public static void main(String[] args) {


        try {
            parseDate("2023-11-11 11:11");
            System.out.println("successfully");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fail");
        }


    }

    public  static void parseDate(String s) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(s);
        System.out.println(d);

        InputStream is = new FileInputStream("D:/c.png");
    }
}
