package com.alex.d1_thread_create;

public class ThreadDemo2 {

    public static void main(String[] args) {
        Runnable target = new MyRunnable();
        Thread t = new Thread(target);
        t.start();

        for (int i = 0; i < 4 ; i++) {

            System.out.println("main thread is running" + i);
        }

    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 4 ; i++) {

            System.out.println("child thread is running" + i);
        }
    }
}
