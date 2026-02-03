package com.alex.d1_static_method;

public class Student {

    double score;

    public static void printHelloWorld(){
        for (int i = 0; i < 3; i++) {
            System.out.println("HelloWorld");
        }
    }

    public  void printPass(){
        System.out.println(score>=60?"Pass":"Fail");
    }
}
