package com.alex.d12_objects;

import com.alex.d11_object.Student;

import java.util.Objects;

public class Test {

    public static void main(String[] args) {


        Student t1 = null;
        Student t2 = new Student("alan", 20 , 99);

//        t1.equals(t2)//null pointer reference exception

//        public static  boolean equals(Object a, Object b){
//            return(a == b)|| (a!=null && a.equals(b));
//        }
//

        System.out.println(Objects.equals(t1, t2));

        System.out.println(Objects.isNull(t1));//true

        System.out.println(Objects.nonNull(t1));//false


    }
}
