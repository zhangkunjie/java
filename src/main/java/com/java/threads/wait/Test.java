package com.java.threads.wait;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by kunjie.zhang on 2018/5/23.
 */
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int maxSize = 10;
        Thread producer = new Producer(queue, maxSize, "生产者");
        Thread consumer = new Consumer(queue, maxSize, "消费者");
        producer.start();
        consumer.start();

    }
}
