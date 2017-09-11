package io.github.christopher.algorithm.searching.symboltables;

import edu.princeton.cs.algs4.Queue;

/**
 * @author Christopher.Wang 2017/9/11.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size() {
        return N;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public int rank(Key key) {
        return rank(key, 0, N - 1);
    }

    public int rank(Key key, int lo, int hi) {
        if (lo >= hi) {
            return lo;
        }
        int mid = lo + (lo + hi) / 2;
        int cmp = keys[mid].compareTo(key);
        if (cmp > 0) {
            return rank(key, lo, mid - 1);
        } else if (cmp < 0) {
            return rank(key, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j --) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public void delete(Key key) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            for (int j = i; j < N; j++) {
                keys[j] = keys[j + 1];
                vals[j] = vals[j - 1];
            }
        }
        N--;
    }

    public boolean isEmpty() {
        return keys.length == 0;
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key) {
        int i = rank(key);
        Key k = keys[i];
        if (key.compareTo(k) == 0) {
            return k;
        } else {
            return keys[i - 1];
        }
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        int hiRank = rank(hi);
        for (int i = rank(lo); i < hiRank; i++) {
            q.enqueue(keys[i]);
        }
        if (contains(hi)) {
            q.enqueue(keys[hiRank]);
        }
        return q;
    }

    public boolean contains(Key key) {return null != this.get(key);}
}
