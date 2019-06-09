package com.zh.ticket;

import java.util.concurrent.Callable;

public class MyTicketCallable implements Callable<String> {
   private int ticket=20;
    @Override
    public String call() throws Exception {
        while (this.ticket > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Thread.currentThread().getName() 那个线程在执行代码 ，返回线程的名字
            synchronized(this) {
                if (this.ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "买了一张票，剩余" + (--this.ticket));
                }
            }
        }
        return "票卖完了";
    }
    }

