package com.alex.d6_extends;

public class B extends A{
    private int k;

    public  void print3(){
        //child objects can onluy extends father's non-private fields
        System.out.println(i);

    }
}
