package com.alex.d6_set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetDemo1 {

    public static void main(String[] args) {
        //HashSet<String> sites = new HashSet<String>();

        //has order
        Set<String> sites = new LinkedHashSet<>();
        sites.add("Google");
        sites.add("Runoob");
        sites.add("Taobao");
        sites.add("Zhihu");
        sites.add("Runoob");  // 重复的元素不会被添加
        System.out.println(sites);
    }
}
