package com.alex.d2_file;

import java.io.File;

public class FileTest4 {

    public static void main(String[] args) {


        File f = new File("/Users/alexandarmay/Desktop");

        String[] names = f.list();
        for (String name:names){
            System.out.println(name);
        }

        File f2 = new File("/Users/alexandarmay/Desktop");
        File[] files = f2.listFiles();

        //get file folder object not file
        for(File file :files){
            System.out.println(file);
        }


    }
}
