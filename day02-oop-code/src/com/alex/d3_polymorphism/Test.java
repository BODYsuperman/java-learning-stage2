package com.alex.d3_polymorphism;

public class Test {
    public static void main(String[] args) {

        // Polymorphism is for decoupling.

        //Type casting solves the
        // problem of subclasses calling their own unique methods under polymorphism.
        Animal a = new Dog();
        Dog d1 = (Dog) a;
        d1.lookDor();

        //Therefore, judge the object type first, then perform the type casting.
        if(a instanceof  Dog){
            Dog d2 = (Dog) a;
            d2.lookDor();
        }
        else if(a instanceof  Cat){
            Cat c1 = (Cat) a;
            c1.cathFish();
        }


    }

    public  static  void go(Animal a){
        System.out.println("Start.........");

        a.cry();

        //Therefore, judge the object type first, then perform the type casting.
        if(a instanceof  Dog){
            Dog d2 = (Dog) a;
            d2.lookDor();
        }
        else if(a instanceof  Cat){
            Cat c1 = (Cat) a;
            c1.cathFish();
        }
        System.out.println("End............");
    }
}
