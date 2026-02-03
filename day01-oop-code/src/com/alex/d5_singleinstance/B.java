package com.alex.d5_singleinstance;

public class B {

    //lazy load
    private  static  B b;

    private  B(){

    }

    public  static  B getInstance(){
        if(b == null){
            b = new B();
        }
        return  b;
    }
}
