package com.alex.d4_algorithm;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] arr = {5, 3, 1, 9};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }

    public  static  int[] bubbleSort(int[] a){
        if (a == null || a.length <= 1) {
            return a;
        }

        for (int i = 0; i < a.length - 1 ; i++) {
            for (int j = 0; j < a.length - i -1 ; j++) {

                if(a[j] > a[j+1]){
                    int temp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }
}
