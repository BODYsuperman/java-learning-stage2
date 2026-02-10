package com.alex.d1_byte;

import java.io.FileInputStream;
import java.io.InputStream;

public class FileInputStreamDemo2 {

    public static void main(String[] args) throws Exception {

        InputStream is = new FileInputStream("/Users/alexandarmay/Desktop/1/1/2/1.txt");


        byte[] buffer = new byte[3];
        int len;

        while ((len = is.read(buffer))!= -1){
            String  rs = new String(buffer, 0, len);
            System.out.print(rs);
        }
        is.close();
    }
}
