package com.programming;

class Store<T> {

    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return this.item;
    }

}

class HashTable<K, V> {
    private final K key;
    private final V value;

    public HashTable(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "key=" + key +
                ", value=" + value +
                '}';
    }
}

class Person implements Comparable<Person> {

    private final int age;
    private final String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        return Integer.compare(age, otherPerson.getAge());
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

public class Main {

    public static <T extends Comparable<T>> T calculateMin(T num1, T num2) {
        if (num1.compareTo(num2) < 0) {
            return num1;
        }
        return num2;
    }

    public static <T extends Number> double add(T num1, T num2) {
        return num1.doubleValue() + num2.doubleValue();
    }

    public static <T extends Comparable<T>> int countGreaterItems(T[] items, T value) {
        int count = 0;
        for (T item : items) {
            if(item.compareTo(value) > 0) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        System.out.println(countGreaterItems(new Integer[]{1, 2, 3, 4, 5}, 3));
        System.out.println(countGreaterItems(new Double[]{1.4, 2.1, 3.9, 4.3, 5.1}, 2.0));
        System.out.println(countGreaterItems(new String[]{"a", "b", "f", "d", "e"}, "c"));

        Store<String> store = new Store<>();

        store.setItem("Hello");
        String item = store.getItem();
        System.out.println(item);

        HashTable<String, Integer> hashTable = new HashTable<>("Hello", 23);
        System.out.println(hashTable);

        GenericMethod method = new GenericMethod();
        System.out.println("The item returned is: " + method.showItem(80));

        Integer[] numbers = {1,2,5,4,3};
        method.showItems(numbers);

        System.out.println(method.checkEquality(12, 8));
        System.out.println(method.checkEquality(10.5, 10.5));
        System.out.println(method.checkEquality("Joe", "Joe"));

        System.out.println(calculateMin(23, 54));
        System.out.println(calculateMin('f', 'e'));
        System.out.println(calculateMin("Kevin", "Ana"));
        System.out.println(calculateMin(new Person("Kevin", 12), new Person("Ada", 124)));

        System.out.println(add(2,40));
        System.out.println(add(1, 4.5f));

    }

}