package com.java.threads.sleep;

import java.io.IOException;

/**
 * Created by kunjie.zhang on 2018/5/22.
 */
/*
加锁：sleep后线程依旧锁着资源，必须休眠结束之后其他线程才能获取执行资源
从上面输出结果可以看出，当Thread-0进入睡眠状态之后，Thread-1并没有去执行具体的任务。
只有当Thread-0执行完之后，此时Thread-0释放了对象锁，Thread-1才开始执行。
 */
public class SleepTest2 {
    private int i = 10;
    private Object object = new Object();

    public static void main(String[] args) throws IOException {
        SleepTest2 test = new SleepTest2();
        MyThread thread1 = test.new MyThread();
        MyThread thread2 = test.new MyThread();
        thread1.start();
        thread2.start();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            //同步代码块
            synchronized (object) {
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
}
