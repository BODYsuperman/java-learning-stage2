package com.alex.d2_udp1;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {

    public static void main(String[] args) throws  Exception {

        DatagramSocket socket = new DatagramSocket();

        byte[] buffer = "I'm here at MIT!".getBytes();

        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(),8888);

        socket.send(packet);

        socket.close();

        System.out.println("Client has been sent successfully!");



    }
}
