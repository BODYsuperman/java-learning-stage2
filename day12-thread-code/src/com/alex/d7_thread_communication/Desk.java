package com.alex.d7_thread_communication;


import lombok.Data;

@Data
public class Desk {

    private  String data;

    public synchronized void put() throws  Exception{

        String name = Thread.currentThread().getName();

        if(data == null){
            data = name+ " make foods";
            System.out.println(name + " make one food");
            this.notifyAll();
            this.wait();
        }
        else{
            this.notifyAll();
            this.wait();
        }

    }

    public  synchronized   void get() throws  Exception{
        String name = Thread.currentThread().getName();
        if(data == null){
            this.notifyAll();
            this.wait();
        }
        else{
            System.out.println(name + " eat " + data );
            data = null;
            this.notifyAll();
            this.wait();
        }
    }
}
