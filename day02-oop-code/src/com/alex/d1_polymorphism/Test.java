package com.alex.d1_polymorphism;

public class Test {
    public static void main(String[] args) {

        //polymorphsim compile see left run see right the implementation class
        // only override method can implement polymorphsim property can't
        Animal cat = new Cat();
        cat.cry();

        Animal dog  = new Dog();
        dog.cry();
    }
}
