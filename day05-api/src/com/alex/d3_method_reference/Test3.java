package com.alex.d3_method_reference;

import com.alex.util.Student;

import java.util.Arrays;
import java.util.Comparator;

public class Test3 {

    public static void main(String[] args) {

        String[] names = {"dlei", "Angela", "baby", "alab","alan","四川"};

        Arrays.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        System.out.println(Arrays.toString(names));
        Arrays.sort(names, ((o1, o2) -> o1.compareToIgnoreCase(o2)));

        Arrays.sort(names, String::compareToIgnoreCase);

        System.out.println(Arrays.toString(names));
    }
}
