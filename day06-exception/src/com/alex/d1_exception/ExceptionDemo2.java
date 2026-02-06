package com.alex.d1_exception;

import java.lang.Exception;

public class ExceptionDemo2 {

    public static void main(String[] args) {


        try {
            divide(1, 0);
            System.out.println("successfully");
        } catch (Exception e) {
            System.out.println("fail" + e.getMessage());
            e.printStackTrace();

        }
    }

    public  static  int divide(int a , int b){
        if(b==0){
            System.out.println("除数b不能为0，当前传入b=" + b);
            throw new RuntimeException("/ by 0");
        }

        int c = a/b;
        return  c;
    }
}
