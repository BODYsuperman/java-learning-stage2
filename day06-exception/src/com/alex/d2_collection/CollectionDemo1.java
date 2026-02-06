package com.alex.d2_collection;

import java.util.ArrayList;
import java.util.HashSet;

public class CollectionDemo1 {
    public static void main(String[] args) {

        //in order, can be duplicated, index
        ArrayList<String> sites = new ArrayList<String>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Weibo");
        sites.add("Weibo");
        sites.add("Weibo");
        System.out.println(sites);
        System.out.println(sites.get(2));


        //set can't be duplicated , no order. no index
        HashSet<String> sites1 = new HashSet<String>();
        sites1.add("Google");
        sites1.add("Runoob");
        sites1.add("Taobao");
        sites1.add("Zhihu");
        sites1.add("Runoob");  // 重复的元素不会被添加
        System.out.println(sites1);
    }


}
