package com.alex.d1_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest1 {
    public static void main(String[] args) {


        List<String> list =new ArrayList<>();
        list.add("alan");
        list.add("alex");
        list.add("james");
        list.add("tom");
        list.add("jessie");


        List<String> newList = new ArrayList<>();
        for (String s: list){
            if(s.startsWith("a")&& s.length()>3){
                newList.add(s);
            }
        }

        //stream improvement
        List<String> newList2 = list.stream().filter(s -> s.startsWith("a")&& s.length()>3).collect(Collectors.toList());

        System.out.println(newList2);
    }
}
