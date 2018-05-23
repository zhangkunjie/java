package com.java.threads.sychronized.classes;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }
    //synchronized作用于一个类T时，是给这个类T加锁，T的所有对象用的是同一把锁。
    public void method() {
        synchronized (SyncThread.class) {
            for (int i = 0; i < 5; i++) {
                try {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void run() {
        method();
    }
}
