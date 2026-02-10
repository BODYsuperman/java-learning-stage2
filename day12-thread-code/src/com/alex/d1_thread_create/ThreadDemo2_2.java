package com.alex.d1_thread_create;

public class ThreadDemo2_2 {

    public static void main(String[] args) {


        Runnable r = new Runnable() {
            @Override
            public void run() {
              for (int i = 0; i < 4 ; i++) {
                    System.out.println("child thread is running" + i);
                }
            }
        };

        Thread t = new Thread(r);
        t.start();

        new Thread( new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 4 ; i++) {
                    System.out.println("child thread is running" + i);
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 4 ; i++) {
                System.out.println("child thread is running" + i);
            }
        }).start();
    }
}
