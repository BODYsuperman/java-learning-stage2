package com.alex.d1_stringbuilder;

public class StringBuilderDemo1 {

    public static void main(String[] args) {


        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder("Alan");
        System.out.println(sb);
        System.out.println(sb2);

        //concatenate content
        sb.append("a").append("b").append("c");
        System.out.println(sb);

        sb.reverse();
        System.out.println(sb);


        //get the length of the string
        System.out.println(sb.length());

        //convert to String Object

        String res = sb.toString();
        System.out.println(res);


    }
}
