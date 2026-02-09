package com.alex.d2_file;

import java.io.File;

public class FileDemo1 {

    public static void main(String[] args) {

        File f1 = new File("/Users//alexandarmay/Desktop/1.png");
        System.out.println(f1.length());//get bytes

        File f2 = new File("/Users//alexandarmay/");

        System.out.println(f2.length());//get file itselft bytes

        File f3 = new File("/Users//alexandarmay/aaaa");//none exists file folder


        //absolute path
        File f4 = new File("/Users//alexandarmay/Desktop/1.png");

        //relative path recommended
        File f5 = new File("day08-stream-file-io");
        System.out.println(f5.length());



    }
}
