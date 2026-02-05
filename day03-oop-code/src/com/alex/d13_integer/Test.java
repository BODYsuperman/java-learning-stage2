package com.alex.d13_integer;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {


        int a = 12;

        //Auto boxing

        Integer a1 = a;
        System.out.println(a1);
        //Manual boxing
        Integer it1 = Integer.valueOf(a);
        System.out.println(it1);

        //The JVM creates and caches Integer objects for int values within
        // the range -128 to 127. For values outside this range, autoboxing will create new, separate Integer instances.

        Integer it2 = 128;
        Integer it3 = 128;
        System.out.println(it2 == it3);//false

        //Auto unboxing
        int it4 = it3;
        System.out.println(it4);

        int a5 = 23;
        String rs = Integer.toString(a5);
        System.out.println(rs + 1);

        Integer i = 23;
        String rs2 =  i.toString();
        System.out.println(rs2 + 1);

        int a2 = 23;
        String rs3 = a2 + "";
        System.out.println(rs3 + 1);

        String ageStr = "23";
        //int age = Integer.parseInt(ageStr);
        //recommend use valueof
        int age = Integer.valueOf(ageStr);
        System.out.println(age + 1);//24





    }
}
