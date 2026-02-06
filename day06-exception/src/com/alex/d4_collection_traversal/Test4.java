package com.alex.d4_collection_traversal;

import java.util.ArrayList;
import java.util.Collection;

public class Test4 {
    public static void main(String[] args) {

        Collection<Movie> movies = new ArrayList<>();
        movies.add(new Movie("ShawnShank's redemption", "alan", 100));

        movies.add(new Movie("ShawnShank's redemption", "alan", 100));

        movies.add(new Movie("ShawnShank's redemption", "alan", 100));
        movies.add(new Movie("ShawnShank's redemption", "alan", 100));
        movies.add(new Movie("ShawnShank's redemption", "alan", 100));


        for (Movie movie : movies) {
            System.out.println(movie);
        }

        movies.forEach(System.out::println);

    }
}
