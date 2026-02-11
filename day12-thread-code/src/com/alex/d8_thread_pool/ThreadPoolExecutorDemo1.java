package com.alex.d8_thread_pool;

import java.util.concurrent.*;

public class ThreadPoolExecutorDemo1 {

    public static void main(String[] args) {


        ExecutorService pool = new ThreadPoolExecutor(3, 5, 1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(3), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        Runnable t = new MyRunnable();
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);
        pool.execute(t);//go to queue
        pool.execute(t);//2
        pool.execute(t);//3
        pool.execute(t);//4
        pool.execute(t);//5

    }
}
