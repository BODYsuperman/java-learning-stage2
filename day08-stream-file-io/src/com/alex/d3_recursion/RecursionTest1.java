package com.alex.d3_recursion;

public class RecursionTest1 {

    public static void main(String[] args) {


       // test1();//ava.lang.StackOverflowError

        test2();//indirect recursion
    }

    public  static  void test1(){

        System.out.println("test1");
        test1();
    }

    public  static  void test2(){
        System.out.println("test2");
        test3();
    }

    private static void test3() {
        System.out.println("test3");
        test2();
    }

}
