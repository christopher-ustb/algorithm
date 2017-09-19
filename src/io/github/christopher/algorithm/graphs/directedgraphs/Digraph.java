package io.github.christopher.algorithm.graphs.directedgraphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 有向图
 * @author Christopher.Wang 2017/9/18.
 */
public class Digraph {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public Digraph(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Digraph(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        E ++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    /**
     * 有向图取反
     * @return 有向图的副本
     */
    public Digraph reverse() {
        Digraph R = new Digraph(this.V);
        for (int i = 0; i < this.V; i++) {
            for (Integer w : this.adj(i)) {
                R.addEdge(w, i);
            }
        }
        return R;
    }
}
