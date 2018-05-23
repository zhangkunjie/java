package com.java.threads.isalive;

/**
 * Created by kunjie.zhang on 2018/5/22.
 */
public class RunTest {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        System.out.println("begin==" + myThread.isAlive());
        myThread.start();
        System.out.println("end==" + myThread.isAlive());
    }
}
