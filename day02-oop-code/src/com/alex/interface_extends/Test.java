package com.alex.interface_extends;

import java.time.ZoneId;

public class Test {

    public static void main(String[] args) {


        ZoneId z = ZoneId.systemDefault();
        System.out.println(z);

        Runtime r = Runtime.getRuntime();
        System.out.println(r.availableProcessors());

        System.out.println(r.totalMemory() / 1024 / 1024);
        //Processp =  r.exec("calc");
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

