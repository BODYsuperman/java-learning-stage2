package com.alex.d2_finally;

import java.io.*;

public class FinallyDemo2 {
    public static void main(String[] args){

        InputStream is = null;
        OutputStream os = null;
        try
        {
        is = new FileInputStream("/Users/alexandarmay/Desktop/1/1/2/1.txt");
           os = new FileOutputStream("/Users/alexandarmay/Desktop/1/1/2/1-1.txt");

            //1KB everytime
            byte[] buffer = new byte[1024];

            int len;
            while ((len = is.read(buffer)) != -1){
                os.write(buffer, 0, len);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {

            try{
                if(os!=null) os.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            try{
                if(is!=null) is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
