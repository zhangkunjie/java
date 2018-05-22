package com.java.generic.classes;

import org.apache.log4j.Logger;

/**
 * Created by kunjie.zhang on 2018/5/21.
 */
public class Test {
    public static void main(String[] args) {
        Generic<Integer> integerGenerinc = new Generic<Integer>(12345);
        Generic<String> stringGeneric = new Generic<String>("hello");
        System.out.println(integerGenerinc.getKey());
        System.out.println(stringGeneric.getKey());
        Generic g1 = new Generic(123);
        Generic g2 = new Generic(123.4);
        Generic g3 = new Generic(true);
        System.out.println(g1.getKey());
        System.out.println(g2.getKey());
        System.out.println(g3.getKey());

    }
}
