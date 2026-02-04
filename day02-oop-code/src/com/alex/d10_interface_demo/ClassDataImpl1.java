package com.alex.d10_interface_demo;

import java.util.ArrayList;

public class ClassDataImpl1 implements ClassData{

    private  ArrayList<Student> students;
    public ClassDataImpl1(ArrayList<Student> students) {
        this.students = students;
    }

    public ClassDataImpl1() {

    }

    @Override
    public void printAllStudentsInfo() {

        System.out.println("Print all students' info");
        for (int i = 0; i < students.size(); i++) {
            Student s= students.get(i);
            System.out.println(s);
        }
    }

    @Override
    public void printAllStudentAverageHeight() {

        int avgHeight = 0;
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            avgHeight+=s.getHeight();
        }

        System.out.println(avgHeight/students.size());
    }
}
