package com.alex.d1_param;

import util.Student;
import util.StudentUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CollectionTest1 {

    public static void main(String[] args) {


        List<String> res = new ArrayList<>();
        Collections.addAll(res, "a", "b","c");
        System.out.println(res);

        Collections.shuffle(res);
        System.out.println(res);

        List< Student> students = StudentUtil.getStudents(20);

        Collections.addAll(students);
        System.out.println(students.toString());
        Collections.sort(students);

        Collections.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Double.compare(o2.getScore(), o1.getScore());
            }
        });

        System.out.println(students.toString());





    }
}
