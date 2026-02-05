package com.alex.d4_innerclass4;

public class Test {

    public static void main(String[] args) {


        Animal a = new Animal() {
            @Override
            public void cry() {
                System.out.println("The dog is barking");
            }
        };
        a.cry();
    }
}

//class Dog extends Animal{
//
//    @Override
//    public void cry() {
//        System.out.println("The dog is barking");
//    }
//}


abstract class Animal{
    public  abstract void cry();
}