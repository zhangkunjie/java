package com.java.threads.wait;

import java.util.Queue;
import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public class Producer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;
    private String name;

    public Producer(Queue<Integer> queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {

                        System.out.println("队列已经满了");
                        queue.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                Random r = new Random();
                int i = r.nextInt();
                System.out.println("生产出来了" + i);
                queue.add(i);
                queue.notify();
            }


        }
    }
}
