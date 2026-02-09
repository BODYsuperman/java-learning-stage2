package com.alex.d1_stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {

    public static void main(String[] args) {

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("千与千寻", 9.4, "柊瑠美"));
        movieList.add(new Movie("星际穿越", 9.3, "马修·麦康纳"));
        movieList.add(new Movie("楚门的世界", 9.3, "金·凯瑞"));

        movieList.add(new Movie("星际穿越", 9.3, "马修·麦康纳"));
        movieList.add(new Movie("楚门的世界", 9.1, "金·凯瑞"));

        movieList.stream().forEach(System.out::println);

        long count = movieList.stream().skip(2).count();
        System.out.println(count);

        Movie max = movieList.stream().max(((o1, o2) -> Double.compare(o1.getScore(), o2.getScore()))).get();
        System.out.println(max);

        Movie min = movieList.stream().min(((o1, o2) -> Double.compare(o1.getScore(), o2.getScore()))).get();
        System.out.println(min);



        List<String> list =new ArrayList<>();
        list.add("alan");
        list.add("alex");
        list.add("james");
        list.add("tom");
        list.add("jessie");

        //stream  can only use once
        Stream<String> stream = list.stream();
        List<String> newList = stream.filter(s -> s.startsWith("a")&& s.length()>3).collect(Collectors.toList());
        System.out.println(newList);

        Stream<String> stream2 = list.stream();
        Set<String> set = stream2.filter(s -> s.startsWith("a")&& s.length()>3).collect(Collectors.toSet());
        System.out.println(set);

        Stream<String> stream3 = list.stream();
        Object[] as = stream3.filter(s -> s.startsWith("a")&& s.length()>3).toArray();
        System.out.println(Arrays.toString(as));

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("千与千寻", 9.4, "柊瑠美"));
        movies.add(new Movie("星际穿越", 9.3, "马修·麦康纳"));
        movies.add(new Movie("楚门的世界", 9.3, "金·凯瑞"));

        movies.add(new Movie("星际穿越", 9.3, "马修·麦康纳"));
        movies.add(new Movie("楚门的世界", 9.1, "金·凯瑞"));

        Map<String, Double> map = movies.stream().limit(4).collect(Collectors.toMap(m1->m1.getName(),
                m2->m2.getScore(),(v1,v2)->v2));

        map.forEach((name, score) ->
                System.out.println(name + " : " + score));







    }
}
