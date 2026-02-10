package com.alex.d7_thread_communication;

public class ConsumerThread extends Thread{

    private  Desk desk;
    public  ConsumerThread(Desk desk, String name){
        super(name);
        this.desk = desk;

    }

    @Override
    public void run() {



        while (true){
            try {
                Thread.sleep(1000);
                desk.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
