package com.alex.d4_char_set;

import java.util.Arrays;

public class CharSetDemo1 {
    public static void main(String[] args) throws Exception {

        String info = "I'm here at MIT ";

        byte[] bytes = info.getBytes();
        System.out.println(Arrays.toString(bytes));
        byte[] bytes1 = info.getBytes("GBK");
        System.out.println(Arrays.toString(bytes1));

        //platform default is utf-8

        String rs1 = new String(bytes);
        System.out.println(rs1);

        String rs2 = new String(bytes, "GBK");
        System.out.println(rs2);



    }
}
