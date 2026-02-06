package com.alex.d1_stringbuilder;

public class StringBuilderDemo2 {
    public static void main(String[] args) {

//        String s= "";
//        for (int i = 0; i < 1000000; i++) {
//            s+="abc";
//        }
//
//        System.out.println(s);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append("abc");
        }

        System.out.println(sb);
        //use buffer as it's thread-safe
        StringBuffer sb2 = new StringBuffer();
        for (int i = 0; i < 1000000; i++) {
            sb2.append("abc");
        }

        System.out.println(sb2);

    }
}
