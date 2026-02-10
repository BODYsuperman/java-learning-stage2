package com.alex.d3_recursion;

public class RecursionTest4 {

    public static void main(String[] args) {

        System.out.println(f(1));
    }

    public  static  int f(int n ){

        if(n == 10){
            return 1;
        }
        return 2*f(n+1) + 2;
    }
}
