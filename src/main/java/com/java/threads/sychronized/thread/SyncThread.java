package com.java.threads.sychronized.thread;

import org.junit.Test;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
//一个线程访问一个对象中的synchronized(this)同步代码块时，
// 其他试图访问该对象的线程将被阻塞。我们看下面一个例子
public class SyncThread implements Runnable {
    private static int count;

    public SyncThread() {
        count = 0;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(1000);
                }
            } catch (InterruptedException
                    e
                    ) {
                e.printStackTrace();
            }
        }

    }
}
