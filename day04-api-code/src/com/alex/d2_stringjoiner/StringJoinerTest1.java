package com.alex.d2_stringjoiner;

import java.util.StringJoiner;

public class StringJoinerTest1 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33};
        System.out.println(getArrayData(arr));
    }

    public  static String getArrayData(int[] arr){
        if(arr== null){
            return  null;
        }

        StringJoiner sb = new StringJoiner(",", "[", "]");

        for (int i = 0; i < arr.length; i++) {

            int data = arr[i];
            sb.add(Integer.toString(data));

        }

        return sb.toString();
    }
}
