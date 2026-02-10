package com.alex.d7_thread_communication;

public class ProductionThread extends Thread{

    private  Desk desk;

    public  ProductionThread(Desk desk, String name){
        super(name);
        this.desk = desk;
    }
    @Override
    public void run() {

        while (true){
            try {
                Thread.sleep(1000);
                desk.put();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
