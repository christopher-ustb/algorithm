package io.github.christopher.algorithm.graphs.undirectedgraphs.exercises.e415;

import edu.princeton.cs.algs4.Bag;

/**
 * 不允许平行边、自环
 * @author Christopher.Wang 2017/9/14.
 */
public class GraphNoParallel {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public GraphNoParallel(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        // 不允许自环
        if (v == w) {
            return;
        }
        // 不允许平行边
        if (hasEdge(v, w)) {
            return;
        }
        adj[v].add(w);
        adj[w].add(v);
        E ++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public boolean hasEdge(int v, int w) {
        Bag<Integer> vAdj = adj[v];
        for (Integer a : vAdj) {
            if (w == a) {
                return true;
            }
        }
        return false;
    }
}
