package com.alex.d7_modifier;

public class Father {
    //Only accessible within the same class
    private void privateMethod(){
        System.out.println("Private");
    }

    //Package-level access — only within the same package.
    void method(){
        System.out.println("default method");
    }

//    Same class ✅
//
//    Same package ✅
//
//    Subclasses in other packages ✅
    protected  void protectedMethod(){
        System.out.println("protected method");
    }

    public   void publicdMethod(){
        System.out.println("public method");
    }
}
