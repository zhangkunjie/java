package com.java.threads.yield;

public class Run {
    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
}