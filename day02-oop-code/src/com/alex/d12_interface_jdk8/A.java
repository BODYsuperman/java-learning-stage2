package com.alex.d12_interface_jdk8;

public interface A {

    default  void run(){
        go();
        System.out.println("run");
    }

    //jdk 9
    private  void go(){
        System.out.println("go");
    }

    static  void inAddr(){
        System.out.println("I'm here at MIT learning computer science");
    }
}
