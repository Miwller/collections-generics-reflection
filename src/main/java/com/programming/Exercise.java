package com.programming;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    public static void main(String[] args) {

        Library<Algorithm> library = new Library<>();
        library.add(new SearchAlgorithm());
        library.add(new SortingAlgorithm());
        library.add(new GraphAlgorithm());

        Algorithm item = library.getLast();

        while(item!=null) {
            item.execute();
            item = library.getLast();
        }

    }

}

class SearchAlgorithm implements Algorithm {
    @Override
    public void execute() {
        System.out.println("Execute SearchAlgorithm");
    }
}

class SortingAlgorithm implements Algorithm {
    @Override
    public void execute() {
        System.out.println("Execute SortingAlgorithm");
    }
}

class GraphAlgorithm implements Algorithm {
    @Override
    public void execute() {
        System.out.println("Execute GraphAlgorithm");
    }
}

class Library<T extends Algorithm> {
    private final List<T> algorithms;
    public Library() {
        algorithms = new ArrayList<>();
    }
    public T getLast() {
        if (algorithms.size() <= 0) return null;
        return this.algorithms.remove(algorithms.size()-1);
    }
    public void add(T algorithm) {
        this.algorithms.add(algorithm);
    }
}

interface Algorithm {
    void execute();
}
