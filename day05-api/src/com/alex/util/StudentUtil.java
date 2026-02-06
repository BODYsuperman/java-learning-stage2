package com.alex.util;

import java.util.Random;

public final class StudentUtil {

    public  static  Student[] getStudents(int n){

        Student[] students = new Student[n];
        // 随机姓名库（避免乱码，用常见姓+名）
        String[] surNames = {"张", "李", "王", "赵", "刘", "陈", "杨", "黄", "周", "吴"};
        String[] givenNames = {"伟", "芳", "杰", "宇", "涵", "琪", "瑶", "轩", "泽", "辰"};
        // 随机数工具：年龄15-20岁，分数60-100分
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < n; i++) {
            // 随机组合姓名
            String name = surNames[random.nextInt(surNames.length)] + givenNames[random.nextInt(givenNames.length)];
            int age = random.nextInt(6) + 15; // 15-20岁
            int score = random.nextInt(41) + 60; // 60-100分
            students[i] = new Student(name, age, score);
        }

        return students;
    }



}
