package com.alex.d6_test;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

public class Server {
    public static void main(String[] args) throws  Exception{


        ServerSocket socket = new ServerSocket(8080);
        System.out.println("Server service is starting...");

        ExecutorService pool = new ThreadPoolExecutor(3, 10, 10, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());


        while (true) {
            Socket socket1 = socket.accept();


            System.out.println("a new client has been alive!"+ socket1.getInetAddress().getHostAddress());

            pool.execute(new ServerReader(socket1));
        }


    }
}
