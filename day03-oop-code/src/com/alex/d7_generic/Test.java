package com.alex.d7_generic;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {
        ArrayList<String> as = new ArrayList<>();
        as.add("A");
        as.add("B");
        as.add("C");

        for (int i = 0; i < as.size(); i++) {
            String ele = as.get(i);
            System.out.println(ele);
        }

    }
}
