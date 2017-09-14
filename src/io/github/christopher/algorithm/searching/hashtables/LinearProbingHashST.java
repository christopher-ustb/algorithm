package io.github.christopher.algorithm.searching.hashtables;

/**
 * @author Christopher.Wang 2017/9/14.
 */
public class LinearProbingHashST<Key, Value> {
    private int N;
    private int M = 16;
    private Key[] keys;
    private Value[] vals;

    public LinearProbingHashST() {
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    public LinearProbingHashST(int cap) {
        this.M = cap;
        keys = (Key[]) new Object[M];
        vals = (Value[]) new Object[M];
    }

    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % M;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t = new LinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++) {
            if (keys[i] != null) {
                t.put(keys[i], vals[i]);
            }
        }
        keys = t.keys;
        vals = t.vals;
        M = t.M;
    }

    public void put(Key key, Value val) {
        if (N >= M / 2) {
            resize(2 * M);
        }
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                vals[i] = val;
                return;
            }
            i = (i + 1) % M;
        }
        keys[i] = key;
        vals[i] = val;
        N ++;
    }

    public Value get(Key key) {
        int i = hash(key);
        while (keys[i] != null) {
            if (keys[i].equals(key)) {
                return vals[i];
            }
            i = (i + 1) % M;
        }
        return null;
    }

    public void delete(Key key) {
        if (!contains(key)) {
            return;
        }
        int i = hash(key);
        while (!key.equals(keys[i])) {
            i = (i + 1) % M;
        }
        keys[i] = null;
        vals[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = vals[i];
            keys[i] = null;
            vals[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M / 8) {
            resize(M / 2);
        }
    }

    public boolean contains(Key key) {
        return null != get(key);
    }
}
