package com.alex.d1_exception;

import java.lang.Exception;
import java.util.Scanner;

public class ExceptionDemo6 {
    public static void main(String[] args) {

        while (true){

            try {
                double p = getPrice();
                System.out.println("Price is "+ p);
                break;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public  static  double getPrice(){
        Scanner sc = new Scanner(System.in);
        System.out.println("please input a valid price:");
        double p = sc.nextDouble();
        return p;
    }
}
