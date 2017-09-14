package io.github.christopher.algorithm.graphs.undirectedgraphs.exercises.e414;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * 判断hashEdge，是否含有边
 * @author Christopher.Wang 2017/9/14.
 */
public class GraphHasEdge {
    private final int V;
    private int E;
    private Bag<Integer>[] adj;

    public GraphHasEdge(int V) {
        this.V = V;
        this.E = 0;
        adj = (Bag<Integer>[]) new Bag[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public GraphHasEdge(In in) {
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
