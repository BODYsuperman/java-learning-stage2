package com.alex.d8_thread_pool;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 4 ; i++) {

            System.out.println(Thread.currentThread().getName()+ "child thread is running" + i);
        }
    }
}