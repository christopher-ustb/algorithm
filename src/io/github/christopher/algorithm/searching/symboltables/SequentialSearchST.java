package io.github.christopher.algorithm.searching.symboltables;

import edu.princeton.cs.algs4.Queue;

/**
 * @author Christopher.Wang 2017/9/11.
 */
public class SequentialSearchST<Key, Value> {
    private class Node {
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    private Node first;

    public Value get(Key key) {
        Node x = first;
        while (x != null) {
            if (key.equals(x.key)) {
                return x.val;
            }
            x = first.next;
        }
        return null;
    }

    public void put(Key key, Value val) {
        Node x = first;
        while (x != null) {
            if (key.equals(x.key)) {
                x.val = val;
                return;
            }
            x = first.next;
        }
        first = new Node(key, val, first);
    }

    public int size() {
        int size = 0;
        Node x = first;
        while (x != null) {
            size ++;
            x = first.next;
        }
        return size;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        Node x = first;
        while (x != null) {
            queue.enqueue(x.key);
            x = first.next;
        }
        return queue;
    }
}
