package com.alex.d4_thread_synchronized_method;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private String carId;
    private  double money;//balance

    public  void  drawMoney(double money){

       String name = Thread.currentThread().getName();


       synchronized (this) {
           if (this.money >= money) {

               /**
                * Thread A enters the method first and acquires the lock → other threads (e.g., B) have to wait;
                * Thread A verifies that the balance is sufficient → prints the "success prompt" → deducts the balance → releases the lock;
                * Thread B acquires the lock → checks the balance (which has been deducted by A at this point) → prompts "insufficient balance".
                */
               System.out.println(name + "successfully withdraw money " + money);
               this.money -= money;
               System.out.println(name + " balance: " + this.money);
           } else {

               System.out.println(name + " balance is not enough");
           }
       }
    }


}
