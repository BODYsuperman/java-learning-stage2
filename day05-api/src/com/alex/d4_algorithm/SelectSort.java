package com.alex.d4_algorithm;

import java.util.Arrays;

public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {5, 3, 1, 9};
        System.out.println(Arrays.toString(selectSort(arr)));
    }

    public  static  int[] selectSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {

            int minIndex = i;

            for (int j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }

            if(minIndex!=i){

                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        return arr;
    }
}
