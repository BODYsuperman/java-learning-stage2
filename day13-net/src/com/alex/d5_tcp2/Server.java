package com.alex.d5_tcp2;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws  Exception{


        ServerSocket socket = new ServerSocket(8888);
        System.out.println("Server service is starting...");

        while (true) {
            Socket socket1 = socket.accept();


            System.out.println("One client has been alive!"+ socket1.getInetAddress().getHostAddress());

            new ServerReader(socket1).start();
        }


    }
}
