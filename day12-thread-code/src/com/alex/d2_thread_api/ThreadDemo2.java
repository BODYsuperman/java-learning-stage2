package com.alex.d2_thread_api;

public class ThreadDemo2 {

    public static void main(String[] args) {


    }
}

class MyThread extends Thread{

    public  MyThread(String name){

        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 4 ; i++) {

            System.out.println(Thread.currentThread().getName()+ " => " + i);
        }
    }
}