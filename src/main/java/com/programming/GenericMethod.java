package com.programming;

public class GenericMethod {

    public <T, V> void printItems(T t, V v) {
        System.out.println(t.toString());
        System.out.println(v.toString());
    }

    public <T> void showItems(T[] items) {
        for(T t : items) {
            System.out.println(t);
        }
    }

    public <T> T showItem(T item) {
        System.out.println("The item is: " + item.toString());
        return item;
    }

    public <T> boolean checkEquality(T t1, T t2) {
        return t1.equals(t2);
    }
}
