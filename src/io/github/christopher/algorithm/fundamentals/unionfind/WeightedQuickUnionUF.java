package io.github.christopher.algorithm.fundamentals.unionfind;

/**
 * @author Christopher.Wang 2017/9/6.
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;
    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
        sz = new int[N];
        for (int i = 0; i < N; i++) {
            sz[i] = 1;
        }
    }
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int find(int p) {
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        if (sz[pRoot] > sz[qRoot]) {
            id[qRoot] = pRoot;
            sz[pRoot] += sz[qRoot];
        } else {
            id[pRoot] = qRoot;
            sz[qRoot] += sz[pRoot];
        }
        count --;
    }

    public int unionSize(int p) {
        return this.sz[find(p)];
    }
}
