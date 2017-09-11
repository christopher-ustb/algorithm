package io.github.christopher.algorithm.searching.symboltables;

/**
 * @author Christopher.Wang 2017/9/11.
 */
public class ST<Key, Value> {
    public ST() {}

    public void put(Key key, Value val) {}

    public Value get(Key key) {return null;}

    public void delete(Key key) {put(key, null);}

    public boolean contains(Key key) {return null != this.get(key);}

    public boolean isEmpty() {return size() == 0;}

    public int size() {return 0;}

    public Iterable<Key> keys() {return null;}
}
