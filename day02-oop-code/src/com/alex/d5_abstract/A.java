package com.alex.d5_abstract;

public abstract class A {

    private  String name;
    private  int age;

    public A() {
    }

    public A(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public  abstract  void go();
    public   abstract void run();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
