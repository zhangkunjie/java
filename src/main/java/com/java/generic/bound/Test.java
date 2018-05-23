package com.java.generic.bound;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kunjie.zhang on 2018/5/21.
 */
public class Test {
    public static <T extends Number> void show10(T t) {
        System.out.println(t.intValue() * 10);
    }

    public static void main(String[] args) {
        Generic<Integer> integerGenerinc = new Generic<Integer>(12345);
        Generic<Number> numberGeneric = new Generic<Number>(6789);
        //报错，String不是Number的子类
        //Generic<String> stringGeneric = new Generic<String>("hello");
        System.out.println(integerGenerinc.getKey());
        show10(10);
        //报错：String不是Number的子类
        //show10("aa");
        List<?>[] list = new ArrayList<?>[10];
    }
}
