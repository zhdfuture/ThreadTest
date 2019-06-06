package com.zh.R;

public class TestMyRunnable {
    public static void main1(String[] args) {
        System.out.println("这是main方法的开始");
        Runnable runnable1=new MyRunnable("MyRunnable1");
        Runnable runnable2=new MyRunnable("MyRunnable2");
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable1);
        thread1.start();
        thread2.start();


        System.out.println("这是main方法的结束");

    }

    public static void main2(String[] args) {
        System.out.println("main开始");

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread1  " + i);
                }
            }
        });


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread2  " + i);
                }
            }
        });

        thread1.start();// start0-> jvm -> native os thread
        thread2.start();

        System.out.println("main结束");
    }

    public static void main3(String[] args) {
        new Thread(()->{
            for (int i=0; i<10; i++){
                System.out.println("Thread1 "+i);
            }
        }).start();
            new Thread(() -> System.out.println("Hello Thread")).start();

        }

    public static void main(String[] args) {

            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Hello World");
                }
            }).start();
        }
    }





