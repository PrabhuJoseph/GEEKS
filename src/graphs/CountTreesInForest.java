package graphs;

// https://www.geeksforgeeks.org/count-number-trees-forest/

import java.util.Iterator;
import java.util.LinkedList;

public class CountTreesInForest {

  static class Graph {
    LinkedList<Integer>[] adj;
    int V;
    Graph(int V) {
      adj = new LinkedList[V];
      for (int i=0; i<V; i++) {
        adj[i] = new LinkedList();
      }
      this.V = V;
    }

    public void addEdge(int x, int y) {
      adj[x].add(y);
    }
  }

  public static void dfs(Graph g, int X, boolean[] visited) {
    visited[X] = true;
    Iterator<Integer> adjs = g.adj[X].listIterator();
    while (adjs.hasNext()) {
      int Y = adjs.next();
      if (!visited[Y]) {
        dfs(g, Y, visited);
      }
    }
  }

  public static int countTrees(Graph g) {
    int count = 0;
    boolean[] visited = new boolean[g.V];
    for (int i=0; i<g.V; i++) {
      if (!visited[i]) {
        dfs(g, i, visited);
        count++;
      }
    }
    return count;
  }


  public static void main(String[] args) {
    Graph graph = new Graph(5);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(3, 4);

    System.out.println("Count of Trees in the Forest: " + countTrees(graph));

  }
}
