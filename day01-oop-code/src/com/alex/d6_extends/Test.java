package com.alex.d6_extends;

public class Test {

    public static void main(String[] args) {


       B b = new B();

        System.out.println(b.i);
//        System.out.println(b.j); // error
//        System.out.println(b.k);//error private no access
        b.print1();
        b.print3();
    }
}
