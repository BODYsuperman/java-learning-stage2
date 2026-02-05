package com.alex.d5_enum;

public class Test {

    public static void main(String[] args) {
        A a1 = A.X;
        A a2 = A.Y;
        A a3 = A.Z;

        System.out.println("___________________");

        A[] as = A.values();
        for (int i = 0; i < as.length; i++) {
            A a = as[i];
            System.out.println(a);
        }

        A y = A.valueOf("Y");
        System.out.println(y == a2);

        //get the index of the object
        System.out.println(a1.ordinal());
        System.out.println(a2.ordinal());
    }
}
