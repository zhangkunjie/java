package com.java.threads.sychronized.thread;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public class SyncThread1Test {
    public static void main(String[] args) {
        SyncThread1 thread = new SyncThread1();
        Thread thread1 = new Thread(thread, "A");
        Thread thread2 = new Thread(thread, "B");
        thread1.start();
        thread2.start();
    }
}
