package io.github.christopher.algorithm.searching.hashtables;

import edu.princeton.cs.algs4.Queue;
import io.github.christopher.algorithm.searching.symboltables.SequentialSearchST;

/**
 * @author Christopher.Wang 2017/9/14.
 */
public class SeparateChainingHashST<Key, Value> {
    private int N;
    private int M;
    private SequentialSearchST<Key, Value>[] st;

    public SeparateChainingHashST() {
        this(997);
    }

    public SeparateChainingHashST(int M) {
        this.M = M;
        st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
        for (int i = 0; i < M; i++) {
            st[i] = new SequentialSearchST<Key, Value>();
        }
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public Value get(Key key) {
        return st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key, val);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for (SequentialSearchST<Key, Value> ssst : st) {
            Iterable<Key> keys = ssst.keys();
            for (Key key : keys) {
                queue.enqueue(key);
            }
        }
        return queue;
    }
}
