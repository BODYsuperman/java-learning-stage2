package com.alex.d2_udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {

    public static void main(String[] args) throws  Exception{


        System.out.println("Server has been initiated");
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buffer = new byte[1024*64];

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);

        int len = packet.getLength();

        String msg = new String(buffer,0 , len);
        System.out.println(msg);
        InetAddress address = packet.getAddress();

        System.out.println("sender IP " + address.getHostAddress());
        System.out.println("sender port "+ packet.getPort());


        socket.close();

    }
}
