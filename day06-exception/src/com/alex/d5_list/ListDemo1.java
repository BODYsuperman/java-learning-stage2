package com.alex.d5_list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListDemo1 {

    public static void main(String[] args) {

        //Polymorphism
        List<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");

        System.out.println(sites);


        //add at index
        sites.add(1, "x");
        System.out.println(sites);

        System.out.println(sites.remove(2));
        System.out.println(sites);

        //change data at index
        sites.set(2, "Wiki");
        System.out.println(sites);

        for (int i = 0; i < sites.size(); i++) {
            String ele = sites.get(i);
            System.out.println(ele);
        }

        Iterator<String> it = sites.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        for (String site : sites) {
            System.out.println(site);
        }
        sites.forEach(System.out::println);

    }
}
