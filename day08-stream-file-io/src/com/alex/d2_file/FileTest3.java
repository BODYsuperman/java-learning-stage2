package com.alex.d2_file;

import java.io.File;

public class FileTest3 {

    public static void main(String[] args) throws Exception {

        File f = new File("/Users/alexandarmay/Desktop/1.txt");

        System.out.println(f.createNewFile());

        File f2 = new File("/Users/alexandarmay/Desktop/1");
        System.out.println(f2.mkdir());


        File f3 = new File("/Users/alexandarmay/Desktop/1/1");
        System.out.println(f3.mkdirs());

        System.out.println(f3.delete());
        //delete can only delete files with empty folder


    }
}
