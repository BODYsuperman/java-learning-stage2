package com.alex.d2_lambda;

import com.alex.d1_array.Student;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.IntToDoubleFunction;

public class LamadaTest2 {

    public static void main(String[] args) {


        double[] scores = {99, 33, 32, 56, 99,33, 60};
        Arrays.setAll(scores, new IntToDoubleFunction() {
            @Override
            public double applyAsDouble(int value) {
                return scores[value] + 10;
            }
        });
        //omit it
        Arrays.setAll(scores, (i)-> scores[i] + 10);

        System.out.println(Arrays.toString(scores));

        Student[] students = new Student[15];
        // 随机姓名库（避免乱码，用常见姓+名）
        String[] surNames = {"张", "李", "王", "赵", "刘", "陈", "杨", "黄", "周", "吴"};
        String[] givenNames = {"伟", "芳", "杰", "宇", "涵", "琪", "瑶", "轩", "泽", "辰"};
        // 随机数工具：年龄15-20岁，分数60-100分
        java.util.Random random = new java.util.Random();

        for (int i = 0; i < 15; i++) {
            // 随机组合姓名
            String name = surNames[random.nextInt(surNames.length)] + givenNames[random.nextInt(givenNames.length)];
            int age = random.nextInt(6) + 15; // 15-20岁
            int score = random.nextInt(41) + 60; // 60-100分
            students[i] = new Student(name, age, score);
        }

        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return  Double.compare(o1.getScore(), o2.getScore());
            }
        });

        Arrays.sort(students, (o1, o2)->Double.compare(o1.getAge(), o2.getAge()));

        //static method reference
        Arrays.sort(students, Comparator.comparingDouble(Student::getAge));

        System.out.println(Arrays.toString(students));
    }
}
