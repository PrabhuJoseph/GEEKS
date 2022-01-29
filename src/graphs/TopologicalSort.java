package graphs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {

  /* Used for Package Dependency */

  // https://www.youtube.com/watch?v=ddTC4Zovtbc

  // https://www.geeksforgeeks.org/topological-sorting/

  static class Graph {
    int V;
    LinkedList<Integer>[] adj;

    public Graph(int V) {
      this.V = V;
      this.adj = new LinkedList[V];
      for (int i = 0; i < adj.length; i++) {
        adj[i] = new LinkedList<>();
      }
    }

    public void addEdge(int S, int D) {
      adj[S].add(D);
    }
  }

  public static Stack<Integer> topologicalSort(HashSet<Integer> visited,
      Stack<Integer> vertexes, Graph graph) {
    for (int i=0; i<graph.V; i++) {
      if (!visited.contains(i)) {
        topSortUtil(i, graph, visited, vertexes);
      }
    }
    return vertexes;
  }

  public static void topSortUtil(int x, Graph g,
      HashSet<Integer> visited, Stack<Integer> vertexes) {
    visited.add(x);
    for (int vertex : g.adj[x]) {
      if (visited.contains(vertex)) {
          continue;
      }
      topSortUtil(vertex, g, visited, vertexes);
    }
    vertexes.add(x);
  }

  public static void main(String[] args) {
      Graph graph = new Graph(8);
      graph.addEdge(0, 2);
      graph.addEdge(0, 1);
      graph.addEdge(2, 3);
      graph.addEdge(4, 5);
      graph.addEdge(5, 2);
      graph.addEdge(2, 6);
      graph.addEdge(6, 7);
      Stack<Integer> vertexes = new Stack<>();
      topologicalSort(new HashSet<>(), vertexes, graph);
      for (int x : vertexes) {
          System.out.println(x);
      }
  }
}
