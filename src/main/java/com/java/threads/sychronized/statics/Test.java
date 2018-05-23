package com.java.threads.sychronized.statics;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public class Test {
    /*syncThread1和syncThread2是SyncThread的两个对象，但在thread1和thread2
    并发执行时却保持了线程同步。这是因为run中调用了静态方法method，而静态方法是属于类的，
    所以syncThread1和syncThread2相当于用了同一把锁。这与Demo1是不同的。
   */
    public static void main(String[] args) {
        SyncThread syncThread1 = new SyncThread();
        SyncThread syncThread2 = new SyncThread();
        Thread thread1 = new Thread(syncThread1, "SyncThread1");
        Thread thread2 = new Thread(syncThread2, "SyncThread2");
        thread1.start();
        thread2.start();
    }
}
