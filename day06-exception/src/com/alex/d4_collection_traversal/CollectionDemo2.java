package com.alex.d4_collection_traversal;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionDemo2 {

    public static void main(String[] args) {

        Collection<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");

        for (String site : sites) {
            System.out.println(site);
        }

        int[] a = {11,22, 33};
        for (int i : a) {
            System.out.println(i);
        }
    }
}
