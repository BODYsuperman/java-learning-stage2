package com.alex.d1_stream;

import java.util.*;
import java.util.stream.Stream;

public class StreamTest2 {

    public static void main(String[] args) {

        Collection<String> list = new ArrayList<>();
        Collections.addAll(list, "alan", "alex","jessie", "tom");

        Stream<String> s1 = list.stream();
        System.out.println(s1.count());

        Map<String, Integer> map = new HashMap<>();

        Stream<String> ks1 = map.keySet().stream();

        Stream<Integer> vs2 = map.values().stream();

        Stream<Map.Entry<String, Integer>> kv3 = map.entrySet().stream();


        String[] names = {"alan", "alex","jessie", "tom"};

        //get array stream
        Stream<String> as1 = Arrays.stream(names);
        Stream<String> as2 = Stream.of(names);

    }
}
