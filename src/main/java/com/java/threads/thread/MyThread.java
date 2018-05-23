package com.java.threads.thread;

/**
 * Created by kunjie.zhang on 2018/5/22.
 */
public class MyThread extends Thread {
    private String name;

    public MyThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name:" + name + "子线程ID:" + Thread.currentThread().getName());
    }
}
