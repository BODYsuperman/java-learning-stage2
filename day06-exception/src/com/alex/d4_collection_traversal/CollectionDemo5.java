package com.alex.d4_collection_traversal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo5 {

    public static void main(String[] args) {


        Collection<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");

        Iterator<String> iterator = sites.iterator();

        while (iterator.hasNext()){
            String s = iterator.next();
            if(s.contains("oo")){

                iterator.remove();
//                sites.remove(s);
            }
        }

        System.out.println(sites);

        //not secure
        Collection<String> sites2 = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        for (String site : sites2) {
            if(site.contains("oo")){

                sites2.remove(site);
            }
        }
        System.out.println(sites2);

        //not secure
        sites2.forEach(name->{
            if(name.contains("oo")){
                sites2.remove(name);
            }
        });


    }
}
