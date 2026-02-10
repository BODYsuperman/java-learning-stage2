package com.alex.d1_thread_create;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadDemo3 {

    public static void main(String[] args) {
        Callable<String> call = new MyCallable(100);
        FutureTask<String> task = new FutureTask<>(call);

        Thread t = new Thread(task);
        t.start();

        Callable<String> call2 = new MyCallable(200);
        FutureTask<String> task2 = new FutureTask<>(call2);

        Thread t2 = new Thread(task2);
        t2.start();

        try {
            String s = task.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String s2 = task2.get();
            System.out.println(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class MyCallable implements Callable<String>{


    private  int n;
    public  MyCallable(int n){
        this.n = n;
    }
    @Override
    public String call() throws Exception {

        int sum = 0;

        for (int i = 1; i <= n ; i++) {
            sum+=n;
        }
        return "child thread sum of 1-"+n + " is " + sum;
    }
}
