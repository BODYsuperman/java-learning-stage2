package com.alex.d4_thread_synchronized_method;

public class Test {

    public static void main(String[] args) {


        Account acc = new Account("ABC", 10000);


        new DrawThread("alex", acc).start();
        new DrawThread("alan", acc).start();



    }
}
