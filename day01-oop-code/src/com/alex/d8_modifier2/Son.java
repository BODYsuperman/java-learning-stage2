package com.alex.d8_modifier2;

import com.alex.d7_modifier.Father;

public class Son extends Father {

public  void print(){

    protectedMethod();
    publicdMethod();
}

    public static void main(String[] args) {
        Son son = new Son();

        //f.privateMethod(); error
        //f.method();
        son.protectedMethod();
        son.publicdMethod();
    }
}
