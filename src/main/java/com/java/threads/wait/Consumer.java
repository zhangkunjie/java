package com.java.threads.wait;

import java.util.Queue;
import java.util.Random;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public class Consumer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;
    private String name;

    public Consumer(Queue<Integer> queue, int maxSize, String name) {
        this.queue = queue;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    try {

                        System.out.println("队列已经被消耗完了，停止消耗");
                        queue.wait();

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                int i = queue.remove();
                System.out.println("消耗掉了" + i);
                queue.notify();


            }


        }
    }
}
