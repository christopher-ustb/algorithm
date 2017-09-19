package io.github.christopher.algorithm.graphs.directedgraphs;

import edu.princeton.cs.algs4.StdOut;

/**
 * 拓扑排序
 * @author Christopher.Wang 2017/9/18.
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G);
        if (!cyclefinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }

    public static void main(String[] args) {
        String filename = "algs4-data\\jobs.txt";
        String separator = "/";

        SymbolDigraph sg = new SymbolDigraph(filename, separator);

        Topological top = new Topological(sg.G());

        for (Integer v : top.order()) {
            StdOut.println(sg.name(v));
        }
    }
}
