package com.alex.d4_static_code;

import java.util.ArrayList;

public class CodeTest1 {

    public  static  String schoolName = "MIT";
    public  static ArrayList<String> names = new ArrayList<>();
    //static code block only load  and execute once
    static {
        names.add("A");
        names.add("B");

    }

    public static void main(String[] args) {

        System.out.println(names);
    }
}
