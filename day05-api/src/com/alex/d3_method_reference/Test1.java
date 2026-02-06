package com.alex.d3_method_reference;

import com.alex.util.Student;
import com.alex.util.StudentUtil;

import java.util.Arrays;

public class Test1 {

    public static void main(String[] args) {


        Student[] students =  StudentUtil.getStudents(20);

        System.out.println(Arrays.toString(students));

        Arrays.sort(students, ((o1, o2) -> Integer.compare(o1.getScore(), o2.getScore())));

        Arrays.sort(students, ((o1, o2) -> Student.compareByScore(o1,o2)));

        //static method reference
        Arrays.sort(students, Student::compareByScore);

        System.out.println(Arrays.toString(students));
    }
}
