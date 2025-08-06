package com.programming;

import java.util.ArrayList;
import java.util.List;

class Bucket<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}

public class Inference {

    public static <T> void addStore(T t, List<Bucket<T>> list) {
        Bucket<T> bucket = new Bucket<>();
        bucket.setItem(t);
        list.add(bucket);
        System.out.println(t.toString() + " has been added to the list...");
    }

    static <T> List<T> add(List<T> list, T item1, T item2) {
        list.add(item1);
        list.add(item2);
        return list;
    }

    public static void main(String[] args) {

        List<Integer> list1 = add(new ArrayList<>(), 20, 30);
        System.out.println(list1);

        List<String> list2 = add(new ArrayList<>(), "Kevin", "Adam");
        System.out.println(list2);

        List<Bucket<String>> list = new ArrayList<>();

        Inference.addStore("Adan", list);

        Inference.<String>addStore("Daniel", list);
    }

}
