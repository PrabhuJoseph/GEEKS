package graphs;

import java.util.*;
import java.util.LinkedList;

class GreedyColoring {
    private int V;
    private LinkedList<Integer> adj[];

    GreedyColoring (int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i=0; i<v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v,int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    void greedyColoring() {
      int[] color = new int[V];
      Arrays.fill(color, -1);
      color[0] = 0;

      boolean[] colorPicked = new boolean[V];

      for (int i=1; i<V; i++) {
        for (int x : adj[i]) {
          if (color[x] != -1) {
            colorPicked[color[x]] = true;
          }
        }

        for (int c=0; c<colorPicked.length; c++) {
          if (!colorPicked[c]) {
            color[i] = c;
            break;
          }
        }
        Arrays.fill(colorPicked, false);
      }

      for (int u = 0; u < V; u++)
        System.out.println("Vertex " + u + " --->  Color " + color[u]);

    }

    // Driver method
    public static void main(String args[])
    {
        GreedyColoring g1 = new GreedyColoring(5);
        g1.addEdge(0, 1);
        g1.addEdge(0, 2);
        g1.addEdge(1, 2);
        g1.addEdge(1, 3);
        g1.addEdge(2, 3);
        g1.addEdge(3, 4);
        System.out.println("Coloring of graph 1");
        g1.greedyColoring();

        System.out.println();
        GreedyColoring g2 = new GreedyColoring(5);
        g2.addEdge(0, 1);
        g2.addEdge(0, 2);
        g2.addEdge(1, 2);
        g2.addEdge(1, 4);
        g2.addEdge(2, 4);
        g2.addEdge(4, 3);
        System.out.println("Coloring of graph 2");
        g2.greedyColoring();
    }
}
// This code is contributed by Aakash Hasija

