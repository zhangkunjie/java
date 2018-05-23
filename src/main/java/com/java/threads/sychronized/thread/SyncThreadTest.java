package com.java.threads.sychronized.thread;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public class SyncThreadTest {
    /*
    当两个并发线程(thread1和thread2)访问同一个对象(syncThread)中的s
    ynchronized代码块时，在同一时刻只能有一个线程得到执行，另一个线程受阻塞
    ，必须等待当前线程执行完这个代码块以后才能执行该代码块。Thread1和thread2是互斥的
    ，因为在执行synchronized代码块时会锁定当前的对象，
    只有执行完该代码块才能释放该对象锁，下一个线程才能执行并锁定该对象
     */
    public static void main(String[] args) {
        SyncThread syncThread = new SyncThread();
        //thread1和thread2锁定的是同一个对象syncThread
        Thread thread1 = new Thread(syncThread, "syncThread1");
        Thread thread2 = new Thread(syncThread, "syncThread2");
        thread1.start();
        thread2.start();
    }
}
