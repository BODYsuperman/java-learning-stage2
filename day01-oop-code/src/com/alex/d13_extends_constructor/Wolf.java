package com.alex.d13_extends_constructor;

public class Wolf extends Animal{

    public  Wolf(){
        //default is there
        super();
        System.out.println("child class none parameter constructor executed");
    }

    public Wolf(String n ) {

        super(n);
        System.out.println("child class of one  parameter constructor executed" + n);
    }
}
