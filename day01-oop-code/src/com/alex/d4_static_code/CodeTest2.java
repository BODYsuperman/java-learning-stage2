package com.alex.d4_static_code;

import java.util.ArrayList;

public class CodeTest2 {
    private  String name;
    private ArrayList<String> names = new ArrayList<>();

    {

        names.add("AA");
        names.add("BB");
    }

    public CodeTest2(){
        System.out.println("Constructor");
    }

    public static void main(String[] args) {

        new CodeTest2();
        new CodeTest2();

        new CodeTest2();


    }
}
