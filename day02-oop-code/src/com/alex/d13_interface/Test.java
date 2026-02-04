package com.alex.d13_interface;

public class Test {

    public static void main(String[] args) {

        Cat c = new Cat();
        c.test();
    }
}




interface A3{
    default void run(){
        System.out.println("run A3");
    }
}

interface A4{
    default void run(){
        System.out.println("run A4");
    }
}

class  C3 implements A3, A4{

    @Override
    public void run() {
        System.out.println("C3 run");
        A3.super.run();
        A4.super.run();
    }
}

class Animal{
    public  void run(){
        System.out.println("run");
    }
}

interface Go{
    default void run(){
        System.out.println("go");

    }
}

class Cat extends Animal implements  Go{

    public  void test(){
       // run();
        Go.super.run();
    }
}
