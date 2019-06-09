package com.zh.ticket;

public class MyTicketRunnable implements Runnable {
    private int ticket = 20;

    @Override
    public void run() {
        while (this.ticket > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Thread.currentThread().getName() 那个线程在执行代码 ，返回线程的名字
            synchronized (this) {
                if (this.ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + "买了一张票，剩余" + (--this.ticket));
                }
            }
        }
    }
}