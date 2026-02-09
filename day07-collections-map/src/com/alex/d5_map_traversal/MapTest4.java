package com.alex.d5_map_traversal;

import java.util.*;

public class MapTest4 {

    public static void main(String[] args) {



        String[] locations = {"DC", "LA", "New York", "Houston"};

        List<String> places = new ArrayList<>();
        Random r = new Random();

        for (int i = 0; i < 80 ; i++) {
            places.add(locations[r.nextInt(locations.length )]);
        }

        System.out.println(places);

        Map<String, Integer> res = new HashMap<>();

        for (String s: places){
            if (res.containsKey(s)) {

                res.put(s, res.get(s) +1);
            }
            else{
                res.put(s, 1);
            }
        }

        res.forEach((k,v)-> System.out.println(k+ "----" + v));




    }
}
