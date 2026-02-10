package com.alex.d1_byte;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class FileOutputStreamDemo4 {

    public static void main(String[] args) throws Exception {

        //append true
        OutputStream os = new FileOutputStream("/Users/alexandarmay/Desktop/1/1/2/1.txt", true);

        os.write('Z');

        os.write(97);

        os.write("\r\n".getBytes());

        byte[] bytes = "abc我爱你111".getBytes();

        os.write(bytes);
        os.write("\r\n".getBytes());

        //start from 3 len 15 bytes
        os.write(bytes, 3, 9);
        os.write("\r\n".getBytes());

        String rs = new String(bytes);
        System.out.println(rs);

        os.close();
    }
}
