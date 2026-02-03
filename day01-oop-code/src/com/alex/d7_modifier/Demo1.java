package com.alex.d7_modifier;

public class Demo1 {
    public static void main(String[] args) {

        Father f = new Father();

        //f.privateMethod(); error
        f.method();
        f.protectedMethod();
        f.publicdMethod();
    }
}
