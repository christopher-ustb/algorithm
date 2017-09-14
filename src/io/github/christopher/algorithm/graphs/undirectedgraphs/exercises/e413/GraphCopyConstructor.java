package io.github.christopher.algorithm.graphs.undirectedgraphs.exercises.e413;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 增加一个复制构造函数，任何改动都不应该影响到副本
 * @author Christopher.Wang 2017/9/14.
 */
public class GraphCopyConstructor {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public GraphCopyConstructor(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public GraphCopyConstructor(In in) {
        this(in.readInt());
        int E = in.readInt();
        for (int i = 0; i < E; i++) {
            int v = in.readInt();
            int w = in.readInt();
            addEdge(v, w);
        }
    }

    public GraphCopyConstructor(GraphCopyConstructor g) {
        this(g.V());
        this.E = g.E();
        for (int i = 0; i < g.adj.length; i++) {
            Bag<Integer> adjBag = g.adj[i];
            for (Integer adj : adjBag) {
                this.adj[i].add(adj);
            }
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
        adj[w].add(v);
        E ++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }
}
