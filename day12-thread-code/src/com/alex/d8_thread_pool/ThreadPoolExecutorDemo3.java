package com.alex.d8_thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolExecutorDemo3 {

    public static void main(String[] args) {


        ExecutorService pool = Executors.newFixedThreadPool(3);
        Future<String> s1 = pool.submit(new MyCallable(100));
        Future<String> s2 = pool.submit(new MyCallable(200));
        Future<String> s3 = pool.submit(new MyCallable(300));


        try {
            String s  = s1.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String s  = s2.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String s  = s3.get();
            System.out.println(s);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
