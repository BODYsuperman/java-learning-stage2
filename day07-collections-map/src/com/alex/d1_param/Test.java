package com.alex.d1_param;

import java.util.Arrays;

public class Test {

    public static void main(String[] args) {

    }

    //essentially is an array
    //can only locate at the last params
    public  static  void sum(int...nums){
        System.out.println(nums.length);

        System.out.println(Arrays.toString(nums));
    }


}
