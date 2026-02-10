package com.alex.d1_thread_create;

public class ThreadDemo1 {

    public static void main(String[] args) {

        Thread t = new MyThread();

        //don't use run CPU won't register thread
        t.start();

        for (int i = 0; i < 4 ; i++) {

            System.out.println("main thread is running" + i);
        }
    }
}

class MyThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 4 ; i++) {

            System.out.println("child thread is running" + i);
        }
    }
}
