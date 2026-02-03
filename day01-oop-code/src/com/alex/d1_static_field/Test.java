package com.alex.d1_static_field;

public class Test {

    public static void main(String[] args) {


        //static field is one copy in the RAM that's not related with new objects
        Student.name = "Tom";
        System.out.println(Student.name);

        //not recommended to set it like this
        Student s1 = new Student();
        s1.name = "alan";

        Student s2 = new Student();
        s1.name = "roger";

        s1.age = 23;
        s2.age = 18;

        System.out.println(s1.age);


    }
}
