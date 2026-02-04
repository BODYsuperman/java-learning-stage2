package com.alex.d12_extends_field;

public class Test {

    public static void main(String[] args) {

        Son s = new Son();
        s.showName();
    }
}

class Father{
    String name="Fathter";
    public  void showName(){
        String name = "local";
        System.out.println(name);

        System.out.println(this.name);
    }
}

class Son{
    String name = "Son";

    public  void showName(){
        String name = "local";
        System.out.println(name);

        System.out.println(this.name);
    }
}