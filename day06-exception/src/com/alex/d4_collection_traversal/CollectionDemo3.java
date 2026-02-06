package com.alex.d4_collection_traversal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class CollectionDemo3 {

    public static void main(String[] args) {

        Collection<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");

        sites.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });

        sites.forEach(s ->  System.out.println(s));

        sites.forEach(System.out::println);
    }
}
