package com.alex.d4_tcp1;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws  Exception{


        ServerSocket socket = new ServerSocket(8888);

        Socket socket1 = socket.accept();

        InputStream inputStream = socket1.getInputStream();

        DataInputStream stream = new DataInputStream(inputStream);

        int i = stream.readInt();
        String s = stream.readUTF();
        System.out.println(i);
        System.out.println(s);


    }
}
