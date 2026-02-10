package com.alex.d7_thread_communication;

public class Test {

    public static void main(String[] args) {

        Desk desk= new Desk();


        new ConsumerThread(desk, "alan").start();

        new ConsumerThread(desk, "alex").start();

        new ProductionThread(desk, "a").start();
        new ProductionThread(desk, "b").start();
        new ProductionThread(desk, "c").start();
    }
}
