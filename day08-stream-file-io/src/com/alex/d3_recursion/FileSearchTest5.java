package com.alex.d3_recursion;

import java.io.File;

public class FileSearchTest5 {

    public static void main(String[] args) {


       searchFile(new File("/Users/alexandarmay/Desktop/"), "1.txt");

        //System.out.println(result);
//        if (result != null) {
//            System.out.println("找到文件: " + result.getAbsolutePath());
//            System.out.println("文件大小: " + result.length() + " bytes");
//            System.out.println("最后修改: " + new java.util.Date(result.lastModified()));
//        } else {
//            System.out.println("未找到文件 1.txt");
//        }
    }

    public static File searchFile1(File directory, String fileName) {
        // 参数检查
        if (directory == null || fileName == null || !directory.exists()) {
            return null;
        }

        // 如果不是目录，检查是否是要找的文件
        if (!directory.isDirectory()) {
            if (directory.getName().equals(fileName)) {
                return directory;
            }
            return null;
        }

        // 获取目录下的所有文件和子目录
        File[] files = directory.listFiles();
        if (files == null) {
            return null;
        }

        // 首先检查当前目录下的文件
        for (File file : files) {
            if (file.isFile() && file.getName().equals(fileName)) {
                return file;
            }
        }

        // 递归搜索子目录
        for (File file : files) {
            if (file.isDirectory()) {
                File found = searchFile1(file, fileName);
                if (found != null) {
                    return found;
                }
            }
        }

        return null; // 没找到
    }

    /**
     *
     * @param dir
     * @param filename
     */

    public static  void searchFile(File dir, String filename){

        if(dir == null || !dir.exists()|| dir.isFile()){
            return ;
        }

        File[] files = dir.listFiles();

        //not a file folder
        if(files == null || files.length == 0){
            return ;
        }

        for(File file:files){
            if(file.isFile()){
                if(file.getName().contains(filename)){
                    System.out.println(file.getAbsoluteFile());
                }
            }else{
                searchFile(file, filename);
            }
        }


    }


}
