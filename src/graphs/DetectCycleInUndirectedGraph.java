package graphs;

import java.util.*;

public class DetectCycleInUndirectedGraph {

  static class Graph {
    private int V;
    private LinkedList<Integer> adj[];

    Graph(int v) {
      V = v;
      adj = new LinkedList[v];
      for (int i = 0; i < v; ++i)
        adj[i] = new LinkedList();
    }

    void addEdge(int v, int w) {
      adj[v].add(w);
      adj[w].add(v);
    }
  }

  static boolean isCyclicUtil(Graph g, int v,
      boolean visited[], int parent) {
    System.out.println(v + "---" + parent);
    visited[v] = true;

    for (int child : g.adj[v]) {
      if (!visited[child]) {
        if (isCyclicUtil(g, child, visited, v))
          return true;
      }
      else if (child != parent) {
        System.out.println("Else " + child + "---" + parent);
        return true;
      }
    }
    return false;
  }


  static boolean isCyclic(Graph g) {
    boolean visited[] = new boolean[g.V];

    for (int u = 0; u < g.V; u++) {
      if (!visited[u])
        if (isCyclicUtil(g, u, visited, -1))
          return true;
    }
    return false;
  }


  public static void main(String args[]) {
    Graph g1 = new Graph(5);
    g1.addEdge(1, 0);
    g1.addEdge(0, 2);
    g1.addEdge(2, 1);
    g1.addEdge(0, 3);
    g1.addEdge(3, 4);
    if (isCyclic(g1))
      System.out.println("Graph contains cycle");
    else
      System.out.println("Graph doesn't contains cycle");

    Graph g2 = new Graph(3);
    g2.addEdge(0, 1);
    g2.addEdge(1, 2);
    if (isCyclic(g2))
      System.out.println("Graph contains cycle");
    else
      System.out.println("Graph doesn't contains cycle");
  }
}