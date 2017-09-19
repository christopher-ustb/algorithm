package io.github.christopher.algorithm.graphs.directedgraphs;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 深度优先搜索判断有向图的可达性
 * @author Christopher.Wang 2017/9/18.
 */
public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph G, int s) {
        marked = new boolean[G.V()];
        dfs(G, s);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        for (Integer source : sources) {
            if (!marked[source]) {
                dfs(G, source);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean marked(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(new In("algs4-data\\tinyDG.txt"));
        int s = 2;
        DirectedDFS reachable = new DirectedDFS(G, s);
        for (int i = 0; i < G.V(); i++) {
            if (reachable.marked(i)) {
                StdOut.print(i + " ");
            }
        }
    }
}
