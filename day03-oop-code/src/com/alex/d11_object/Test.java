package com.alex.d11_object;

public class Test {

    public static void main(String[] args) {
        Student s1 = new Student("alan", 20 , 99);
        System.out.println(s1);


        Student s2 = new Student("alan", 20 , 99);
        Student s3 = new Student("alan", 20 , 99);

        System.out.println(s2.equals(s3));//true
        System.out.println(s2 == s3);//false
    }
}
