package com.java.collections.list;

import javax.swing.*;
import java.io.Serializable;

/**
 * Created by kunjie.zhang on 2018/5/22.
 */
public class User implements Serializable, Comparable {
    public User(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;

    }

    private int id;
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        int i = this.getId() - ((User) o).getId();
        if (i == 0) {
            return ((User) o).getAge() - this.getAge();
        }
        return i;
    }
}
