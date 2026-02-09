package com.alex.d1_stream;

import java.util.ArrayList;
import java.util.List;

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


    }
}
