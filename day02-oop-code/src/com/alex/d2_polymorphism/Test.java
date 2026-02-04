package com.alex.d2_polymorphism;

public class Test {
    public static void main(String[] args) {

        // Polymorphism is for decoupling.
        Animal cat = new Cat();
        cat.cry();


        Cat c = new Cat();
        go(c);

        Dog d = new Dog();
        go(d);
    }

    public  static  void go(Animal a){
        System.out.println("Start.........");



        a.cry();
        System.out.println("End............");
    }
}
