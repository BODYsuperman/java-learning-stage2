package com.alex.d8_thread_pool;

import java.util.concurrent.Callable;

class MyCallable implements Callable<String> {


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
        return Thread.currentThread().getName()+ "child thread sum of 1-"+n + " is " + sum;
    }
}