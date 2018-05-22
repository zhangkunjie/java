package com.java.generic.wildcard;

import com.java.generic.interfaces.Generator;

/**
 * 泛型类
 */
public class Generic<T> {
    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public void showKeyValue(Generic<Number> obj) {
        System.out.println(obj.getKey());
    }

    public void showKeyValue1(Generic<?> obj) {
        System.out.println(obj.getKey());
    }
}
