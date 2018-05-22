package com.java.generic.methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 泛型方法
 */
public class GenericMethod {
    // 泛型方法 printArray
    public static <E> void printArray(E[] inputArray) {
        // 输出数组元素
        for (E element : inputArray) {
            System.out.printf("%s ", element);
        }
        System.out.println();
    }

    //获取类的名字
    public static <T> void f(T t) {
        System.out.println(t.getClass().getName());
    }

    //创建不同类型的list对象
    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <k, v> Map<k, v> newHashMap() {
        return new HashMap<k, v>();
    }

    public static void main(String args[]) {
        // 创建不同类型数组： Integer, Double 和 Character
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        Character[] charArray = {'H', 'E', 'L', 'L', 'O'};

        System.out.println("整型数组元素为:");
        printArray(intArray); // 传递一个整型数组

        System.out.println("\n双精度型数组元素为:");
        printArray(doubleArray); // 传递一个双精度型数组

        System.out.println("\n字符型数组元素为:");
        printArray(charArray); // 传递一个字符型数组

        String s = new String();
        f(s);
        Integer i = new Integer(4);
        f(i);
        List<Integer> list = newArrayList();
    }
}
