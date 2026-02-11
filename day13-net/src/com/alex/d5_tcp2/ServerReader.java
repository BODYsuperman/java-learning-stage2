package com.alex.d5_tcp2;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerReader extends Thread{

    private Socket socket;
    public  ServerReader(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();

            DataInputStream stream = new DataInputStream(inputStream);


            while (true) {
                String s = stream.readUTF();
                System.out.println("get message from client " + s);


                System.out.println(socket.getInetAddress().getHostAddress());
                System.out.println(socket.getPort());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Client is dead!");
        }
    }
}
