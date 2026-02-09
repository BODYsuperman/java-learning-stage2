package com.alex.d4_map;

import java.util.HashMap;
import java.util.Map;

public class MapDemo2 {

    public static void main(String[] args) {


        Map<Integer, String> Sites = new HashMap<Integer, String>();
        // 添加键值对
        Sites.put(1, "Google");
        Sites.put(2, "Runoob");
        Sites.put(3, "Taobao");
        Sites.put(4, "Zhihu");
        System.out.println(Sites);
        System.out.println(Sites.get(3));

        //remove key
        Sites.remove(4);

        //Sites.clear();
        System.out.println(Sites);
        System.out.println(Sites.size());

        // 输出 key 和 value
        for (Integer i : Sites.keySet()) {
            System.out.println("key: " + i + " value: " + Sites.get(i));
        }
        // 返回所有 value 值
        for(String value: Sites.values()) {
            // 输出每一个value
            System.out.print(value + ", ");
        }
    }
}
