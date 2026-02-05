package com.alex.d1_innerclass1;

public class People {

    private  int heartBeat = 110;

    public  class Heart{
        private int heartBeat = 95;

        public  void show(){
            int heartBeat = 80;
            System.out.println(heartBeat);//80
            System.out.println(this.heartBeat);//95
            System.out.println(People.this.heartBeat);//110
        }



    }
}
