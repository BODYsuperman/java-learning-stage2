package com.alex.d2_lambda;

public class LambdaTest1 {

    public static void main(String[] args) {

        Swimming s1 = new Swimming() {
            @Override
            public void swim() {
                System.out.println("Alan is swimming");
            }
        };
        s1.swim();

        Swimming s2 = ()->{
            System.out.println("Alan1 is swimming");
        };

        s2.swim();
    }
}

@FunctionalInterface
interface Swimming{
    void swim();
}
