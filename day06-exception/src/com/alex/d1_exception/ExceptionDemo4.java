package com.alex.d1_exception;

import java.lang.Exception;

public class ExceptionDemo4 {
    public static void main(String[] args) {


        try {
            save(10);
            System.out.println("successfully");
        } catch (AgeIllegalException e) {
           e.printStackTrace();
            System.out.println("fail!");
        }
    }

    public  static void save(int age) throws AgeIllegalException {
        if(age <=0 || age > 150){
            throw new AgeIllegalException("Age parameter is illegal");
        }

        System.out.println("successfully" + age);
    }
}
