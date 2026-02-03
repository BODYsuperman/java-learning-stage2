package com.alex.d8_modifier2;

import com.alex.d7_modifier.Father;

public class Demo2 {

    public static void main(String[] args) {
        Father f = new Father();

        //f.privateMethod(); error
        //f.method();
        //f.protectedMethod();
        f.publicdMethod();
    }
}
