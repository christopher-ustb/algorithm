package io.github.christopher.algorithm.exercise.basic.bag_queue_stack.exer1;

public class FixedCapacityStackOfStrings {
    private String[] a;

    private int N;

    public FixedCapacityStackOfStrings(int cap) {
        this.a = new String[cap];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void push(String item) {
        a[N ++] = item;
    }

    public String pop() {
        return a[--N];
    }

    public boolean isFull() {
        return this.N >= this.a.length;
    }
}
