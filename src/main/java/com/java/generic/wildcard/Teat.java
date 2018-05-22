package com.java.generic.wildcard;

/**
 * Created by kunjie.zhang on 2018/5/21.
 */
public class Teat {
    public static void main(String[] args) {
        Generic<Integer> g1 = new Generic<Integer>(123);
        Generic<Number> g2 = new Generic<Number>(456);
        //通过提示信息我们可以看到Generic<Integer>不能被看作为`Generic<Number>的子类。
        //由此可以看出:同一种泛型可以对应多个版本（因为参数类型是不确定的），不同版本的泛型类实例是不兼容的。
        //g1.showKeyValue(g1);
        g1.showKeyValue(g2);
        g1.showKeyValue1(g1);
        g1.showKeyValue1(g2);
    }
}
