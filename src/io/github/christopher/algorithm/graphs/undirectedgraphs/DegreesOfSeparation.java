package io.github.christopher.algorithm.graphs.undirectedgraphs;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * 间隔的度数
 * @author Christopher.Wang 2017/9/15.
 */
public class DegreesOfSeparation {
    public static void main(String[] args) {
        args = new String[3];
        args[0] = "algs4-data\\routes.txt";
        args[1] = " ";
        args[2] = "JFK";

        SymbolGraph sg = new SymbolGraph(args[0], args[1]);
        Graph G = sg.G();
        String source = args[2];
        if (!sg.contains(source)) {
            StdOut.println(source + " not in database");
            return;
        }
        int s = sg.index(source);
        BreadthFirstPaths bfs = new BreadthFirstPaths(G, s);
        while (!StdIn.isEmpty()) {
            String sink = StdIn.readLine();
            if (sg.contains(sink)) {
                int t = sg.index(sink);
                if (bfs.hasPathTo(t)) {
                    for (Integer v : bfs.pathTo(t)) {
                        StdOut.println(" " + sg.name(v));
                    }
                } else {
                    StdOut.println("Not connected");
                }
            } else {
                StdOut.println("Not in database");
            }
        }
    }
}
