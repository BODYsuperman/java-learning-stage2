package com.alex.d1_innerclass1;

public class Test {

    public static void main(String[] args) {
        Outer.Inner in = new Outer().new Inner();
        in.setName("Alan");
        in.show();

        People.Heart h = new People().new Heart();
        h.show();
    }
}
