package com.alex.d3_udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws  Exception {

        DatagramSocket socket = new DatagramSocket();

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Please input");

            String msg = sc.nextLine();
            byte[] buffer = msg.getBytes();

            if(msg.equals("exit")){

                socket.close();
                break;
            }
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(),8888);

            socket.send(packet);



            System.out.println("Client has been sent successfully!");
        }


    }
}
