package com.alex.d3_method_reference;

import com.alex.util.Student;
import com.alex.util.StudentUtil;

import java.util.Arrays;

public class Test2 {

    public static void main(String[] args) {


        Student[] students = StudentUtil.getStudents(99);

        Test2 t = new Test2();

        Arrays.sort(students, ((o1, o2) -> Integer.compare(o1.getScore(), o2.getScore())));
        Arrays.sort(students, t::compareByScore);
    }

    public  int compareByScore(Student o1, Student o2){
        return Integer.compare(o1.getScore(), o2.getScore());
    }
}
