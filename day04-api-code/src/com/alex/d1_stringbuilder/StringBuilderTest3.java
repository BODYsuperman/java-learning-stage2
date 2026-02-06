package com.alex.d1_stringbuilder;

public class StringBuilderTest3 {
    public static void main(String[] args) {
        int[] arr = {11, 22, 33};
        System.out.println(getArrayData(arr));
    }

    public  static String getArrayData(int[] arr){
        if(arr== null){
            return  null;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < arr.length; i++) {

            int data = arr[i];
            sb.append(data).append(i==arr.length-1 ?" ": ", ");

        }
        sb.append("]");
        return sb.toString();
    }
}
