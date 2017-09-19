package io.github.christopher.algorithm.graphs.directedgraphs;

import io.github.christopher.algorithm.graphs.undirectedgraphs.Graph;

/**
 * 计算强连通分量的Kosaraju算法
 * @author Christopher.Wang 2017/9/18.
 */
public class KosarajuSCC {
    private boolean[] marked;
    private int count;
    private int[] id;

    public KosarajuSCC(Graph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                dfs(G, s);
            }
        }
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        count ++;
        id[v] = this.count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean connected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }
}
