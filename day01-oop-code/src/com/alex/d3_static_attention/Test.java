package com.alex.d3_static_attention;

public class Test {

    public static String schoolName = "MIT";

    public  static void inAddr(){
        System.out.println("I'm here at MIT");
    }
    private  String name;

    public  void printInfo(){
        System.out.println(name);
    }
    public static void main(String[] args) {


        Test t = new Test();
        t.testNoStatic();

    }


    public  void testNoStatic(){
        System.out.println(schoolName);
        inAddr();
        //can use this
        System.out.println(name);
        printInfo();
    }

    public  static  void testStatic(){
        System.out.println(schoolName);
        inAddr();
        //can't appear this

        //printInfo(); error
    }
}
