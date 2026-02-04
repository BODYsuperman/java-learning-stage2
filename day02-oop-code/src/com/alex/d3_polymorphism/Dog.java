package com.alex.d3_polymorphism;

public class Dog extends Animal {

    @Override
    public void cry() {
        System.out.println("Dog can bark!");
    }

    public  void lookDor(){
        System.out.println("Dog can lookDor");
    }
}
