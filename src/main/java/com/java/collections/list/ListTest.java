package com.java.collections.list;

import org.junit.Test;

import java.util.*;

/**
 * list测试类
 */
public class ListTest {
    @Test
    public void arrayListTest() {
        /* 1）Vector的方法都是同步的(Synchronized),是线程安全的(thread-safe)，
        而ArrayList的方法不是，由于线程的同步必然要影响性能，因此,ArrayList的性能比Vector好。
        2）当Vector或ArrayList中的元素超过它的初始大小时,Vector会将它的容量翻倍, 而ArrayList只增加50%的大小，这样,ArrayList就有利于节约内存空间。
       */
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(2);
        l1.add(1);
        l1.add(3);
        for (Integer i : l1) {
            System.out.println(i);
        }
        List v1 = new Vector();
        /*1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
        2.对于随机访问get和set，ArrayList觉得优于LinkedList，因为LinkedList要移动指针。
        3.对于新增和删除操作add和remove，LinedList比较占优势，因为ArrayList要移动数据。*/
        List<Integer> l2 = new LinkedList<Integer>();
        l2.add(2);
        l2.add(1);
        l2.add(3);
        Collections.sort(l2);
        for (Integer i : l2) {
            System.out.println(i);
        }
        //栈是Vector的子类，先进后出的规则
        Stack<Integer> s = new Stack<Integer>();
        s.push(4);
        s.push(5);
        System.out.println(s.pop());
        List<User> userList = new ArrayList<User>();
        User u1 = new User(2, "zhangsan", 1);
        User u2 = new User(2, "tom", 2);
        User u3 = new User(1, "tom", 1);
        User u4 = new User(3, "tom", 3);
        userList.add(u1);
        userList.add(u2);
        userList.add(u3);
        userList.add(u4);
        for (User u : userList) {
            System.out.println(u);
        }
        Collections.sort(userList);
        for (User u : userList) {
            System.out.println(u);
        }
        Collections.sort(userList);
    }

}
