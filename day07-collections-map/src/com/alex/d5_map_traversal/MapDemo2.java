package com.alex.d5_map_traversal;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo2 {

    public static void main(String[] args) {


        Map<Integer, String> Sites = new HashMap<Integer, String>();
        // 添加键值对
        Sites.put(1, "Google");
        Sites.put(2, "Runoob");
        Sites.put(3, "Taobao");
        Sites.put(4, "Zhihu");

        Set<Map.Entry<Integer, String>> entries = Sites.entrySet();
        for (Map.Entry<Integer, String> entry: entries){
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "----" + value);
        }

    }
}
