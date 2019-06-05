package com.zh.R;

public class TestMyThread {
    public static void main(String[] args) {
        Thread thread=new MyThread("A");
        thread.start();  //创建并启动线程
        }
}
