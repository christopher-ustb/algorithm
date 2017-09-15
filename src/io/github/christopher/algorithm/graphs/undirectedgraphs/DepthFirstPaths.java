package io.github.christopher.algorithm.graphs.undirectedgraphs;


import edu.princeton.cs.algs4.Stack;

/**
 * 深度优先搜索查找图中的路径
 * @author Christopher.Wang 2017/9/15.
 */
public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int w) {
        return marked[w];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> path = new Stack<Integer>();
        int x = v;
        while (x != s) {
            path.push(x);
            x = edgeTo[x];
        }
        path.push(s);
        return path;
    }
}
