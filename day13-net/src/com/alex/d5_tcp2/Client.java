package com.alex.d5_tcp2;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws  Exception{

        Socket socket = new Socket("127.0.0.1", 8888);

        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);


        Scanner scanner = new Scanner(System.in);

        while (true) {


            System.out.println("please send message you want to");
            String msg = scanner.nextLine();


            if(msg.equals("exit")){

                System.out.println("successfully exit");
                dataOutputStream.close();
                socket.close();
                break;
            }
            dataOutputStream.writeUTF(msg);
            dataOutputStream.flush();
        }

    }
}
