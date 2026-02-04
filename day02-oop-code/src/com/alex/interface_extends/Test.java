package com.alex.interface_extends;

public class Test {

    public static void main(String[] args) {

    }
}

class D implements  A{


    @Override
    public void run() {

    }

    @Override
    public void eat() {

    }

    @Override
    public void a() {

    }
}


interface  A  extends  B, C{

    void a();
}
interface  B{
    void  run();
}
interface C{
    void eat();
}

