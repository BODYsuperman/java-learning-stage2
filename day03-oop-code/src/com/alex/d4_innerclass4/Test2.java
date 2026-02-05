package com.alex.d4_innerclass4;

public class Test2 {
    public static void main(String[] args) {



        //Anonymous inner classes are often used when passed as arguments to methods.
        go(new Swimming() {
            @Override
            public void swim() {

                System.out.println("override this swim method;");
            }
        });
    }

    public static  void go(Swimming s){
        System.out.println("Start swimming");
        s.swim();
        System.out.println("Finish swimming");

    }
}

interface Swimming{

    void swim();
}

