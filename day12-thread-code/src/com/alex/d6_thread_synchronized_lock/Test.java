package com.alex.d6_thread_synchronized_lock;

public class Test {

    public static void main(String[] args) {


        Account acc = new Account("ABC", 10000);


        new DrawThread("alex", acc).start();
        new DrawThread("alan", acc).start();



    }
}
