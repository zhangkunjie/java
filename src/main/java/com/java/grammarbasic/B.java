package com.java.grammarbasic;

/**
 * Created by kunjie.zhang on 2018/5/11.
 */
public class B extends A {
    public String show(B obj) {
        return ("B and B");
    }
    @Override
    public String show(A obj) {
        return ("B and A");
    }

}
