package com.alex.d10_generic_method;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args) {

        ArrayList<TSL> tsls = new ArrayList<>();
        tsls.add(new TSL());
        tsls.add(new TSL());
        tsls.add(new TSL());
        tsls.add(new TSL());

        go(tsls);

        ArrayList<LX> lxes = new ArrayList<>();
        lxes.add(new LX());
        lxes.add(new LX());
        lxes.add(new LX());
        lxes.add(new LX());



        go(lxes);
    }

    //Wildcard ？ use when represents any object
    public  static void go( ArrayList<? extends Car> cars){


    }


}

class Car{

}

class TSL extends  Car{

}

class LX extends  Car{

}
