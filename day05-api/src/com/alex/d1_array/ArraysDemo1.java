package com.alex.d1_array;

import java.util.Arrays;
import java.util.function.IntToDoubleFunction;

public class ArraysDemo1 {
    public static void main(String[] args) {

        //toString
        int[] arr = {11, 33, 55, 32, 98};
        String res = Arrays.toString(arr);
        System.out.println(res);

        //copy array
        int[] arr2 = Arrays.copyOfRange(arr, 1, 4);
        System.out.println(Arrays.toString(arr2));

        //expand capacity of array
        int[] arr3 = Arrays.copyOf(arr, 10);
        System.out.println(Arrays.toString(arr3));

        //change arry data
        double [] scores = {99.5, 90, 87.4, 78, 99};

        Arrays.setAll(scores, new IntToDoubleFunction() {
            @Override
            public double applyAsDouble(int value) {
                return scores[value] + 10;
            }
        });

        Arrays.setAll(scores, i-> scores[i] + 10);

        System.out.println(Arrays.toString(scores));
        Arrays.sort(scores);
        System.out.println(Arrays.toString(scores));


    }
}
