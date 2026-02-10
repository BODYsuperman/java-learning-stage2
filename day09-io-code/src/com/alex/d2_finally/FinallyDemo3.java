package com.alex.d2_finally;

import java.io.*;

public class FinallyDemo3 {

    public static void main(String[] args) {

        try ( InputStream is = new FileInputStream("/Users/alexandarmay/Desktop/1/1/2/1.txt");
              OutputStream os = new FileOutputStream("/Users/alexandarmay/Desktop/1/1/2/1-1.txt");)
        {

            //1KB everytime
            byte[] buffer = new byte[1024];

            int len;
            while ((len = is.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }

            os.close();
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}

