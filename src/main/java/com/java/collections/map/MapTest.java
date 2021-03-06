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
/*
Map主要用于存储健值对，根据键得到值，因此不允许键重复（重复了覆盖了），但允许值重复。


        HashMap

        　　HashMap 是一个最常用的Map，它根据键的HashCode 值存储数据，根据键可以直接获取它的值，具有很快的访问速度。遍历时，取得数据的顺序是完全随机的。
        　　HashMap最多只允许一条记录的键为Null；允许多条记录的值为 Null。
        　　HashMap不支持线程的同步（即任一时刻可以有多个线程同时写HashMap），可能会导致数据的不一致。如果需要同步，可以用 Collections的synchronizedMap方法使HashMap具有同步的能力，或者使用ConcurrentHashMap。
        　　Hashtable与 HashMap类似，它继承自Dictionary类。不同的是：它不允许记录的键或者值为空；它支持线程的同步（即任一时刻只有一个线程能写Hashtable），因此也导致了 Hashtable在写入时会比较慢。


        LinkedHashMap

        　　LinkedHashMap保存了记录的插入顺序，在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的。也可以在构造时带参数，按照应用次数排序。
        在遍历的时候会比HashMap慢，不过有种情况例外：当HashMap容量很大，实际数据较少时，遍历起来可能会比LinkedHashMap慢。因为LinkedHashMap的遍历速度只和实际数据有关，和容量无关，而HashMap的遍历速度和他的容量有关。


        TreeMap

        　　TreeMap实现SortMap接口，能够把它保存的记录根据键排序。
        　　默认是按键值的升序排序，也可以指定排序的比较器，当用Iterator 遍历TreeMap时，得到的记录是排过序的。


        三种类型分别在什么时候使用

        　　1、一般情况下，我们用的最多的是HashMap。HashMap里面存入的键值对在取出的时候是随机的，它根据键的HashCode值存储数据，根据键可以直接获取它的值，具有很快的访问速度。在Map 中插入、删除和定位元素，HashMap 是最好的选择。
        　　2、TreeMap取出来的是排序后的键值对。但如果您要按自然顺序或自定义顺序遍历键，那么TreeMap会更好。
        　　3、LinkedHashMap 是HashMap的一个子类，如果需要输出的顺序和输入的相同,那么用LinkedHashMap可以实现,它还可以按读取顺序来排列，像连接池中可以应用。


        其他

        1. HashSet是通过HashMap实现的,TreeSet是通过TreeMap实现的,只不过Set用的只是Map的key
        2. Map的key和Set都有一个共同的特性就是集合的唯一性.TreeMap更是多了一个排序的功能.
        3. hashCode和equal()是HashMap用的, 因为无需排序所以只需要关注定位和唯一性即可.
        　　a. hashCode是用来计算hash值的,hash值是用来确定hash表索引的.
        　　b. hash表中的一个索引处存放的是一张链表, 所以还要通过equal方法循环比较链上的每一个对象才可以真正定位到键值对应的Entry.
        　　c. put时,如果hash表中没定位到,就在链表前加一个Entry,如果定位到了,则更换Entry中的value,并返回旧value
        4. 由于TreeMap需要排序,所以需要一个Comparator为键值进行大小比较.当然也是用Comparator定位的.
        　　a. Comparator可以在创建TreeMap时指定
        　　b. 如果创建时没有确定,那么就会使用key.compareTo()方法,这就要求key必须实现Comparable接口.
        　　c. TreeMap是使用Tree数据结构实现的,所以使用compare接口就可以完成定位了.


        注意：

        　　1、Collection没有get()方法来取得某个元素。只能通过iterator()遍历元素。
        　　2、Set和Collection拥有一模一样的接口。
        　　3、List，可以通过get()方法来一次取出一个元素。使用数字来选择一堆对象中的一个，get(0)...。(add/get)
        　　4、一般使用ArrayList。用LinkedList构造堆栈stack、队列queue。
        　　5、Map用 put(k,v) / get(k)，还可以使用containsKey()/containsValue()来检查其中是否含有某个key/value。
        　　HashMap会利用对象的hashCode来快速找到key。哈希码就是将对象的信息经过一些转变形成一个独一无二的int值，这个值存储在一个array中。我们都知道所有存储结构中，array查找速度是最快的。所以，可以加速查找。 发生碰撞时，让array指向多个values。即，数组每个位置上又生成一个梿表。
        　　6、Map中元素，可以将key序列、value序列单独抽取出来。
        　　　　使用keySet()抽取key序列，将map中的所有keys生成一个Set。
        　　　　使用values()抽取value序列，将map中的所有values生成一个Collection。
        　　　　为什么一个生成Set，一个生成Collection？那是因为，key总是独一无二的，value允许重复。
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

