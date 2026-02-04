package com.alex.d4_final;

public class FinalDemo1 {

    public  static  final  String SCHOOL_NAME ;

    static {
        SCHOOL_NAME ="MIT";
    }
    public static void main(String[] args) {

/*        Java variable
local variable: function code block formal parameter list  method parameter

static member variable
member variable
        */

        final int a = 12;
//        a=15;error
        buy(10);

    }

    public  static  void buy(final int  a ){
//        a = 12;error
    }
}

//A final class cannot be inherited, and it is often used as a utility class. lile Math

//final class A{
//
//}
//class  B extends  A{
//
//}

//a final function can't be overriden

//class A{
//
//    public  final void run(){
//
//    }
//}
//class  B extends  A{
//
//    @Override
//    public void run() {
//
//    }
//}