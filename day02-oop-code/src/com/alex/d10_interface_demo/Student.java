package com.alex.d10_interface_demo;

public class Student {


    private  String name;
    private  char sex;
    private double height;


    public Student() {
    }

    public Student(String name, char sex, double height) {
        this.name = name;
        this.sex = sex;
        this.height = height;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", height=" + height +
                '}';
    }
}
