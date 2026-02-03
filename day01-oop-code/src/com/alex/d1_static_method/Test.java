package com.alex.d1_static_method;

public class Test {
    public static void main(String[] args) {

        //Object directly to call static method
        Student.printHelloWorld();

        Student s = new Student();
        s.score = 100;
        s.printPass();
    }
}
