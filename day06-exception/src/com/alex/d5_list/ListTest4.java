package com.alex.d5_list;

import java.util.LinkedList;
import java.util.List;

public class ListTest4 {

    public static void main(String[] args) {


        List<String> queue = new LinkedList<>();

        for (int i = 1; i < 5; i++) {
            queue.add(i+ "");
        }

        System.out.println(queue);

        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());
        System.out.println(queue.removeFirst());

        System.out.println(queue);

        //implement stack
        List<String> stack = new LinkedList<>();
        for (int i = 1; i < 5; i++) {
            stack.addFirst(i + "");
        }

        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());
        System.out.println(stack.removeFirst());

        System.out.println(stack);

    }
}
