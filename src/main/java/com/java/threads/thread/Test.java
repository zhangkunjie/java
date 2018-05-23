package com.java.threads.thread;

/**
 * Created by kunjie.zhang on 2018/5/22.
 */
public class Test {
    /*1）thread1和thread2的线程ID不同，thread2和主线程ID相同，说明通过run方法调用并不会创建新的线程，
        而是在主线程中直接运行run方法，跟普通的方法调用没有任何区别；
     2）虽然thread1的start方法调用在thread2的run方法前面调用，
        但是先输出的是thread2的run方法调用的相关信息，说明新线程创建的过程不会阻塞主线程的后续执行。
     */
    public static void main(String[] args) {
        System.out.println("主线程的ID:" + Thread.currentThread().getName());
        MyThread thread1 = new MyThread("Thread1");
        thread1.start();
        MyThread thread2 = new MyThread("Thread2");
        thread2.run();
        System.out.println("主线程的ID:" + Thread.currentThread().getName());
    }
}
