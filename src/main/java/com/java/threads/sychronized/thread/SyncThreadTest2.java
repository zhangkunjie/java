package com.java.threads.sychronized.thread;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public class SyncThreadTest2 {
    /*
这时创建了两个SyncThread的对象syncThread1和syncThread2，
线程thread1执行的是syncThread1对象中的synchronized代码(run)，
而线程thread2执行的是syncThread2对象中的synchronized代码(run)；
我们知道synchronized锁定的是对象，这时会有两把锁分别锁定syncThread1对象和syncThread2对象，
而这两把锁是互不干扰的，不形成互斥，所以两个线程可以同时执行。
     */
    public static void main(String[] args) {
        //thread1和thread2锁定的不是同一个对象
        Thread thread1 = new Thread(new SyncThread(), "SyncThread1");
        Thread thread2 = new Thread(new SyncThread(), "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
