package com.alex.d1_array;

import java.util.*;
import java.util.Comparator;

public class ArraysDemo2 {

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();
        Random random = new Random(); // 随机数工具，用于生成年龄和分数

        // 循环生成15个学生
        for (int i = 1; i <= 15; i++) {
            String name = "学生" + i; // 姓名：学生1、学生2...学生15
            int age = random.nextInt(6) + 15; // 年龄：15-20岁（nextInt(6)生成0-5，+15后15-20）
            int score = random.nextInt(41) + 60; // 分数：60-100分（nextInt(41)生成0-40，+60后60-100）
            // 创建学生对象并加入集合
            studentList.add(new Student(name, age, score));
        }


        // 删掉Arrays.sort，换成这个（按年龄升序，极简Lambda）
        Collections.sort(studentList, (s1, s2) -> s1.getAge() - s2.getAge());

        studentList.sort(Comparator.comparingInt(Student::getAge));

// 写法2：Lambda基础版（易理解）
        studentList.sort((s1, s2) -> s1.getAge() - s2.getAge());

// 写法3：Lambda降序（调换s1/s2，年龄从大到小）
        studentList.sort((s1, s2) -> s2.getAge() - s1.getAge());

    }
}
