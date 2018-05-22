package com.java.generic.bound;

/**
 * 泛型边界
 */
public class Generic<T extends Number> {
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
}
