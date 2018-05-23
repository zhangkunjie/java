package com.java.threads.sleep;

import java.io.IOException;

/**
 * Created by kunjie.zhang on 2018/5/22.
 */
/*
不加锁：sleep线程相互独立，同步开始执行
 */
public class SleepTest1 {
    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args) throws IOException {
        SleepTest1 test = new SleepTest1();
        MyThread thread1 = test.new MyThread();
        MyThread thread2 = test.new MyThread();
        thread1.start();
        thread2.start();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            i++;
            System.out.println("i:" + i);
            try {
                System.out.println("线程" + Thread.currentThread().getName() + "进入睡眠状态");
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {
                // TODO: handle exception
            }
            System.out.println("线程" + Thread.currentThread().getName() + "睡眠结束");
            i++;
            System.out.println("i:" + i);
        }
    }
}
