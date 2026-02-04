package com.alex.d6_abstract_demo;

import com.alex.d5_abstract.A;

public class Test {
    public static void main(String[] args) {


        Animal a = new Cat();
        a.cry();;

        Animal a2 = new Dog();
        a2.cry();


    }

    public  static  void go(Animal a){
        System.out.println("Start.........");

        a.cry();

        //Therefore, judge the object type first, then perform the type casting.
        if(a instanceof Dog){
            Dog d2 = (Dog) a;
            d2.lookDor();
        }
        else if(a instanceof Cat){
            Cat c1 = (Cat) a;
            c1.cathFish();
        }
        System.out.println("End............");
    }
}
