package graphs;

import java.util.*;

public class MaxClique {

  static class Graph {
    int V;
    LinkedList<Integer> adj[];
    int[] vertexes;

    public Graph(int V) {
      this.V = V;
      adj = new LinkedList[V];
      vertexes = new int[V];
      for (int i=0; i<V; i++) {
        vertexes[i] = i+1;
        adj[i] = new LinkedList<>();
      }
    }

    public void addEdge(int src, int dst) {
      adj[src-1].add(dst);
    }
  }

  public static boolean isClique(int[] subset, Graph g) {
    for (int i=0; i<subset.length; i++) {
      for (int j=0; j<subset.length; j++) {
        if (subset[i] != subset[j]) {
          if (!(g.adj[subset[i] - 1].contains(subset[j]) || (g.adj[subset[j] - 1].contains(subset[i])))) {
            return false;
          }
        }
      }
    }
    for (int x : subset) {
      System.out.println(x);
    }
    return true;
  }

  public static boolean isClique(int[] arr, int i, int n, int index, int r, int[] data, Graph g) {
    if (index == r) {
      return isClique(data, g);
    }
    if (i >= n) {
      return false;
    }
    data[index] = arr[i];
    return isClique(arr, i+1, n, index+1, r, data, g) || isClique(arr, i+1, n, index, r, data, g);
  }


  public static int maxClique(Graph g) {
    for (int i=g.V-1; i>0; i--) {
      if (isClique(g.vertexes, 0, g.vertexes.length, 0, i, new int[i], g)) {
        return i;
      }
    }
    return -1;
  }


  public static void main(String args[] ) throws Exception {
    Graph g = new Graph(4);
    boolean visited[] = new boolean[4];
    g.addEdge(1,2);
    g.addEdge(3,1);
    g.addEdge(4,3);
    g.addEdge(4,1);
    g.addEdge(4,2);
    System.out.println("MAX CLIQUE: " + maxClique(g));
  }
}