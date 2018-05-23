package com.java.threads.isalive;

/**
 * Created by kunjie.zhang on 2018/5/22.
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("run=" + this.isAlive());
    }
}
