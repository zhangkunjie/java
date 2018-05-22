package com.java.collections.map;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.*;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by kunjie.zhang on 2018/5/21.
 */
public class MapTest {
    public static ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<Integer, Integer>();

    @Test
    public void mapTest() {
        //hashmap不能保证输入key的顺序
        Map<String, String> m1 = new HashMap<String, String>();
        m1.put("1", "a");
        m1.put("2", "b");
        m1.put("3", "c");
        m1.put("4", "d");
        m1.put("5", "e");
        //for遍历
        for (Entry<String, String> entry : m1.entrySet()) {
            System.out.println(entry);
        }
        for (String str : m1.keySet()) {
            System.out.println("key:" + str + " value:" + m1.get(str));
        }
        for (String str : m1.values()) {
            System.out.println("key:" + str + " value:" + m1.get(str));
        }
        //Iterator
        Iterator it = m1.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        //HashMap本事不是线程安全的，但是可以使用Collection变成线程安全的


    }

    @Test
    public void hashTableTest() {
        //HashTable产生于JDK 1.1，而HashMap产生于JDK 1.2。从时间的维度上来看，HashMap要比HashTable出现得晚一些。
        //HashMap是支持null键和null值的，而HashTable在遇到null时，会抛出NullPointerException异常
        //我们说HashTable是同步的，HashMap不是，也就是说HashTable在多线程使用的情况下，不需要做额外的同步，而HashMap则不行
        Map<String, String> m1 = new Hashtable<String, String>();
        m1.put("1", "a");
        m1.put("2", "b");
        m1.put("3", "c");
        m1.put("4", "d");
        m1.put("5", "e");
        //for遍历
        for (Entry<String, String> entry : m1.entrySet()) {
            System.out.println(entry);
        }
        for (String str : m1.keySet()) {
            System.out.println("key:" + str + " value:" + m1.get(str));
        }
        for (String str : m1.values()) {
            System.out.println("key:" + str + " value:" + m1.get(str));
        }

        //Iterator
        Iterator it = m1.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

    }

    @Test
    public void treeMapTest() {
        //hashmap不能保证输入key的顺序
        Map<String, String> m1 = new TreeMap<String, String>();
        m1.put("1", "a");
        m1.put("2", "b");
        m1.put("3", "c");
        m1.put("4", "d");
        m1.put("5", "e");
        //for遍历
        for (Entry<String, String> entry : m1.entrySet()) {
            System.out.println(entry);
        }
        for (String str : m1.keySet()) {
            System.out.println("key:" + str + " value:" + m1.get(str));
        }
        for (String str : m1.values()) {
            System.out.println("key:" + str + " value:" + m1.get(str));
        }

        //Iterator
        Iterator it = m1.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Test
    public void sortedMapTest() {
        //hashmap不能保证输入key的顺序
        SortedMap<String, String> m1 = new TreeMap<String, String>();
        m1.put("2", "b");
        m1.put("2", "b");
        m1.put("3", "c");
        m1.put("5", "e");
        m1.put("1", "a");
        m1.put("4", "d");
        //for遍历
        for (Entry<String, String> entry : m1.entrySet()) {
            System.out.println(entry);
        }
        for (String str : m1.keySet()) {
            System.out.println("key:" + str + " value:" + m1.get(str));
        }
        for (String str : m1.values()) {
            System.out.println("key:" + str + " value:" + m1.get(str));
        }

        //Iterator
        Iterator it = m1.entrySet().iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Test
    //Properties：HashTable的子类，用于读取配置文件
    public void propertiesTest() throws Exception {
        Properties p = new Properties();
        InputStream in = new BufferedInputStream(new FileInputStream(new File("src/resource/properties.properties")));
        p.load(in);
        System.out.println(p.getProperty("user"));
    }

    @Test
    public void linkedHashMapTest() {
        //hashMap输出顺序，顺序不能够保证
        Map<String, String> map = new HashMap<String, String>();
        map.put("aa", "aa");
        map.put("bb", "bb");
        map.put("cc", "cc");
        for (Iterator iterator = map.values().iterator(); iterator.hasNext(); ) {
            String name = (String) iterator.next();
            System.out.println(name);
        }
        //LinkedHashMap:保证输入的时候和插入的时候的顺序一致
        Map<String, String> map1 = new LinkedHashMap<String, String>();
        map1.put("bb", "bb");
        map1.put("aa", "aa");
        map1.put("cc", "cc");
        for (Iterator iterator = map1.values().iterator(); iterator.hasNext(); ) {
            String name = (String) iterator.next();
            System.out.println(name);
        }
        //treeMap:会按照默认key顺序进行排序
        Map<String, String> map2 = new TreeMap<String, String>();
        map2.put("bb", "bb");
        map2.put("aa", "aa");
        map2.put("cc", "cc");
        for (Iterator iterator = map2.values().iterator(); iterator.hasNext(); ) {
            String name = (String) iterator.next();
            System.out.println(name);
        }

    }

    @Test
    public void currentHashMapTest() {
        new Thread("Thread1") {
            @Override
            public void run() {
                map.put(3, 33);
            }
        };

        new Thread("Thread2") {
            @Override
            public void run() {
                map.put(4, 44);
            }
        };

        new Thread("Thread3") {
            @Override
            public void run() {
                map.put(7, 77);
            }
        };
        System.out.println(map);
    }
}

