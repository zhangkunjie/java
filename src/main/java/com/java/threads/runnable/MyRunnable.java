package com.java.threads.runnable;

/**
 * Created by kunjie.zhang on 2018/5/22.
 */
public class MyRunnable implements Runnable {
    public static void main(String[] args) {
        System.out.println("主线程ID：" + Thread.currentThread().getId());
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("子线程ID:" + Thread.currentThread().getId());
    }
}
