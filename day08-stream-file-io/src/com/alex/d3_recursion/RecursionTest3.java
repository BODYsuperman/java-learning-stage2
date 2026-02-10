package com.alex.d3_recursion;

public class RecursionTest3 {

    public static void main(String[] args) {

        System.out.println("sum of 1 to 5" + f(500));

    }


    public  static int f(int n){
        if(n == 1){
            return  1;
        }
        else{
            return f(n-1) + n;
        }
    }
}
