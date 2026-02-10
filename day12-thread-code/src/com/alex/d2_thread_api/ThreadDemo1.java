package com.alex.d2_thread_api;

public class ThreadDemo1 {

    public static void main(String[] args) throws Exception {


        Thread t = new MyThread2("1.thread is running");

        t.start();
        for (int i = 0; i < 4; i++) {

            System.out.println("Main thread => "+ i);
            //Thread.sleep(1000);

            if(i == 2){
                t.join();
            }
        }
    }

  
}

class MyThread2 extends Thread {

    public  MyThread2(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 4 ; i++) {

            System.out.println(Thread.currentThread().getName()+ " => " + i);
            try {
                Thread.sleep(500); // 子
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

