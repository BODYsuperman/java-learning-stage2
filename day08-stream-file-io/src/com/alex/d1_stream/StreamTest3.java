package com.alex.d1_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest3 {

    public static void main(String[] args) {

        List<String> list =new ArrayList<>();
        list.add("alan");
        list.add("alex");
        list.add("james");
        list.add("tom");
        list.add("jessie");

        list.stream().filter(s -> s.startsWith("a")&& s.length()>3).forEach(System.out::println);


    List<Movie> movieList = new ArrayList<>();
    movieList.add(new Movie("千与千寻", 9.4, "柊瑠美"));
    movieList.add(new Movie("星际穿越", 9.3, "马修·麦康纳"));
    movieList.add(new Movie("楚门的世界", 9.3, "金·凯瑞"));

        movieList.add(new Movie("星际穿越", 9.3, "马修·麦康纳"));
        movieList.add(new Movie("楚门的世界", 9.1, "金·凯瑞"));

        movieList.add(new Movie("星际穿越", 8.9, "马修·麦康纳"));
        movieList.add(new Movie("楚门的世界", 9.8, "金·凯瑞"));

    movieList.stream().sorted(Movie.BY_SCORE_DESC).forEach(System.out::println);


        System.out.println("--------------limit 3");
    movieList.stream().sorted(Movie.BY_SCORE_DESC).limit(3).forEach(System.out::println);
        System.out.println("----------skip 6");
        movieList.stream().sorted(Movie.BY_SCORE_DESC).skip(6).forEach(System.out::println);

        System.out.println("---------distinct");
        movieList.stream().sorted(Movie.BY_SCORE_DESC).distinct().forEach(System.out::println);

        System.out.println("----------map");

        movieList.stream().sorted(Movie.BY_SCORE_DESC).map(m->m.getName() + " ==>"+ m.getScore()).forEach(System.out::println);

        //contact two streams

        Stream<String> s1 = Stream.of("alan","alex");
        Stream<Integer> s2 = Stream.of(12, 22,1);
        Stream<Object> allStream = Stream.concat(s1, s2);

        System.out.println(allStream.count());
    }
}
