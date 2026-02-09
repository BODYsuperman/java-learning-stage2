package com.alex.d2_file;

import java.io.File;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FileTest2 {

    public static void main(String[] args) {


        File f = new File("/Users//alexandarmay/Desktop/1.png");

        System.out.println(f.exists());

        System.out.println(f.isFile());

        System.out.println(f.isDirectory());

        System.out.println(f.getName());

        System.out.println(f.length());//get bytes

        System.out.println(f.lastModified());

        long lastModified = f.lastModified();
        Instant instant = Instant.ofEpochMilli(lastModified);

        // 方式1：默认格式
        LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        System.out.println("最后修改时间: " + dateTime.format(formatter));


        System.out.println(f.getPath());
        System.out.println(f.getAbsolutePath());
    }
}
