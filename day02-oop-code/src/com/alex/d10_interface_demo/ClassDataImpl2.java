package com.alex.d10_interface_demo;

import com.alex.d9_interface.Doctor;

import java.util.ArrayList;

public class ClassDataImpl2 implements ClassData{
    public ClassDataImpl2() {
    }

    private ArrayList<Student> students;
    public ClassDataImpl2(ArrayList<Student> students) {
        this.students = students;
    }
    @Override
    public void printAllStudentsInfo() {

        int count = 0;
        System.out.println("Print all students' info");
        for (int i = 0; i < students.size(); i++) {
            Student s= students.get(i);
            System.out.println(s);
            if(s.getSex()=='男') count++;
        }
        System.out.println("男同学的人数" + count);
        System.out.println("女同学的人数" + (students.size() - count));
    }

    @Override
    public void printAllStudentAverageHeight() {

        if (students == null || students.size() == 0) {
            System.out.println("学生集合为空，无法计算身高数据！");
            return;
        }

        double totalHeight = 0; // 总身高（替换原avgHeight，命名更语义化）
        double maxHeight = 0;   // 最高身高
        double minHeight = Double.MAX_VALUE;

        for (Student s : students) {
            double height = s.getHeight();
            totalHeight += height; // 累加总身高

            // 计算最高身高：当前身高大于最大值，更新最大值
            if (height > maxHeight) {
                maxHeight = height;
            }
            // 计算最矮身高：当前身高小于最小值，更新最小值（独立判断，不和最高身高互斥）
            if (height < minHeight) {
                minHeight = height;
            }
        }

        // 计算平均身高：总身高 ÷ 学生人数，保留2位小数更贴合实际
        double avgHeight = totalHeight / students.size();
        avgHeight = Math.round(avgHeight * 100) / 100.0; // 四舍五入保留2位小数

        // 格式化打印结果，清晰易读
        System.out.println("===== 学生身高统计结果 =====");
        System.out.println("最矮身高：" + minHeight + " cm");
        System.out.println("最高身高：" + maxHeight + " cm");
        System.out.println("平均身高：" + avgHeight + " cm");
    }
}
