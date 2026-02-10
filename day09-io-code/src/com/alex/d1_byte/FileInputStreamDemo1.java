package com.alex.d1_byte;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo1 {

    public static void main(String[] args) throws Exception {

        InputStream is = new FileInputStream("/Users/alexandarmay/Desktop/1/1/2/1.txt");


        int b;

        while ((b = is.read())!= -1){
            System.out.print((char)b);
        }

        is.close();


    }
}
