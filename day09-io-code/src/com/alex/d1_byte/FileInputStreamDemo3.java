package com.alex.d1_byte;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo3 {

    public static void main(String[] args) throws  Exception {

        InputStream is = new FileInputStream("/Users/alexandarmay/Desktop/1/1/2/1.txt");


        byte[] buffer = is.readAllBytes();

        String rs = new String(buffer);
        System.out.println(rs);

        is.close();
    }
}
