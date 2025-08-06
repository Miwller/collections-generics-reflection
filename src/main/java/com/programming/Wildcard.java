package com.programming;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Wildcard {

    public static void drawAllWildcard(List<? extends Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public static <T extends Shape> void drawAll(List<T> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    public static void printListWildcard(List<? extends Number> list) {
        for (Number o : list) {
            System.out.println(o.toString());
        }
    }

    public static <T> void printList(List<T> list) {
        for (T item : list) {
            System.out.println(item.toString());
        }
    }

    public static void print(List<?> list) {
        for (Object item : list) {
            System.out.println(item.toString());
        }
    }

    public static void showAll(List<? extends Number> list) {
        for (Number n : list) {
            System.out.println(n.toString());
        }
    }

    public static double sumAll(List<? extends Number> list) {
        double result = 0;
        for (Number n : list) {
            result += n.doubleValue();
        }
        return result;
    }

    public static void showAllLower(List<? super Number> list) {
        for (Object num : list) {
            System.out.println(num);
        }
    }

    public static <T> void copy(List<? extends T> source,
                         List<? super T> destination) {
        for (T t : source) {
            destination.add(t);
        }
    }

    public static void main(String[] args) {

        List<Integer> numbs = Arrays.asList(1,2,3);
        print(numbs);
        printListWildcard(numbs);
        printList(numbs);

        List<Rectangle> rectangles = List.of(new Rectangle());
        drawAll(rectangles);
        drawAllWildcard(rectangles);

        // we can create ArrayList like this
        List<? extends Number> l1 = new ArrayList<Integer>();
        List<? extends Number> l2 = new ArrayList<Double>();
        List<? extends Number> l3 = new ArrayList<Float>();

        // we use upper bounded wildcards to read items
        showAll(l2);
        System.out.println(sumAll(Arrays.asList(1,2,3,4)));

        List<? super Integer> l4 = new ArrayList<Integer>();
        List<? super Integer> l5 = new ArrayList<Number>();
        List<? super Integer> l6 = new ArrayList<Object>();

        // how to read items using lower bounded wildcard
        List<Serializable> list = new ArrayList<>();
        list.add("Adam");
        list.add("Kevin");
        list.add("Ana");
        showAllLower(list);

        // insert items
        List<? super Number> numbers = new ArrayList<>();
        numbers.add(3);
        numbers.add(3.3);
        numbers.add(3.5f);

        List<Integer> list1 = Arrays.asList(1,2,3);
        List<Integer> list2 = new ArrayList<>();
        copy(list1, list2);
        System.out.println(list2);
    }

}
