package com.alex.d10_interface_demo;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<Student> studentList = new ArrayList<>();

        // 2. 手动创建10个学生对象，逐个添加到集合
        studentList.add(new Student("张三", '男', 175.5));
        studentList.add(new Student("李四", '女', 162.3));
        studentList.add(new Student("王五", '男', 180.0));
        studentList.add(new Student("赵六", '女', 158.8));
        studentList.add(new Student("孙七", '男', 178.2));
        studentList.add(new Student("周八", '女', 165.6));
        studentList.add(new Student("吴九", '男', 182.5));
        studentList.add(new Student("郑十", '女', 160.9));
        studentList.add(new Student("冯十一", '男', 172.4));
        studentList.add(new Student("陈十二", '女', 168.7));

        ClassData data = new ClassDataImpl2(studentList);
        data.printAllStudentsInfo();
        data.printAllStudentAverageHeight();
    }
}
