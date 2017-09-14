package io.github.christopher.algorithm.graphs.undirectedgraphs.exercises.e418;

import io.github.christopher.algorithm.fundamentals.unionfind.WeightedQuickUnionUF;
import io.github.christopher.algorithm.graphs.undirectedgraphs.Graph;

/**
 * @author Christopher.Wang 2017/9/14.
 */
public class UnionFindSearch {
    private Graph G;
    private int s;

    private WeightedQuickUnionUF uf;

    public UnionFindSearch(Graph G, int s) {
        this.G = G;
        this.s = s;
        this.uf = new WeightedQuickUnionUF(G.V());
        for (Integer a : G.adj(s)) {
            this.uf.connected(a, s);
        }
    }

    public boolean marked(int v) {
        return this.uf.connected(s, v);
    }

    public int count() {
        return this.uf.unionSize(s);
    }
}
