package io.github.christopher.algorithm.graphs.directedgraphs;

import edu.princeton.cs.algs4.Stack;

/**
 * 寻找有向环
 * @author Christopher.Wang 2017/9/18.
 */
public class DirectedCycle {
    private boolean[] marked;
    private int[] edgeTo;
    /**
     * 有向环中所有的顶点
     */
    private Stack<Integer> cycle;
    /**
     * 递归调用的栈上的所有顶点
     */
    private boolean[] onStack;

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if (this.hasCycle()) {
                return;
            } else if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            } else if (onStack[w]) {
                cycle = new Stack<Integer>();
                int x = v;
                while (x != w) {
                    cycle.push(x);
                    x = edgeTo[x];
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return this.cycle;
    }
}
