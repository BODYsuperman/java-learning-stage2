package com.alex.d5_map_traversal;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapDemo3 {
    public static void main(String[] args) {


        Map<Integer, String> Sites = new HashMap<Integer, String>();
        // 添加键值对
        Sites.put(1, "Google");
        Sites.put(2, "Runoob");
        Sites.put(3, "Taobao");
        Sites.put(4, "Zhihu");

        Sites.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println(integer + "-----" + s);
            }
        });

        Sites.forEach((k,v)-> System.out.println(k+ "----" + v));

    }
}
