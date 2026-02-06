package com.alex.d1_exception;

import java.lang.Exception;

public class ExceptionDemo3 {

    public static void main(String[] args) {


        try {
            save(151);
        } catch (Exception e) {
            System.out.println( e.getMessage());
            e.printStackTrace();
        }


    }

    public  static void save(int age){
        if(age <=0 || age > 150){
            throw new AgeIllegalRunTimeException("Age parameter is illegal");
        }

        System.out.println("successfully");
    }
}
