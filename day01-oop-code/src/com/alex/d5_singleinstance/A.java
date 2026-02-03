package com.alex.d5_singleinstance;

public class A {

    private static A a = new A();


    public static A getInstance(){
        return a;
    }

    private  A(){

    }
}
