package com.alex.d1_stream;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    private  String name;
    private  double score;
    private  String actor;

//    public Movie(String name, double score, String actor) {
//        this.name = name;
//        this.score = score;
//        this.actor = actor;
//    }
//
//    public Movie() {
//    }
//
//    public String getActor() {
//        return actor;
//    }
//
//    public void setActor(String actor) {
//        this.actor = actor;
//    }
//
//    public double getScore() {
//        return score;
//    }
//
//    public void setScore(double score) {
//        this.score = score;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public static Comparator<Movie> BY_SCORE_DESC =
            Comparator.comparingDouble(Movie::getScore).reversed();

    public static Comparator<Movie> BY_NAME_ASC =
            Comparator.comparing(Movie::getName);

    public static Comparator<Movie> BY_SCORE_THEN_NAME =
            Comparator.comparingDouble(Movie::getScore)
                    .reversed()
                    .thenComparing(Movie::getName);
}
