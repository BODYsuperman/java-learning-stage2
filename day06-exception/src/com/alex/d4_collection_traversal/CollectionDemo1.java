package com.alex.d4_collection_traversal;

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo1 {

    public static void main(String[] args) {

        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        System.out.println(sites);

        Iterator<String> iterator = sites.iterator();

        while (iterator.hasNext()){

            String ele = iterator.next();
            System.out.println(ele);
        }
    }

}
