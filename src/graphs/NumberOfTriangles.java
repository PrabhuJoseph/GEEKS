package graphs;

import java.util.LinkedList;


/*

For Both Directed and Undirected Graph - https://www.geeksforgeeks.org/number-of-triangles-in-directed-and-undirected-graphs/

 */
public class NumberOfTriangles {

  static class Graph {
    int V;
    LinkedList<Integer>[] adj;

    public Graph(int V) {
      this.V = V;
      adj = new LinkedList[V];
      for (int i=0; i<V; i++) {
        adj[i] = new LinkedList<>();
      }
    }

    public void addEdge(int s, int d) {
      adj[s].add(d);
    }

  }

  public static int getNumberOfTriangles(Graph g, boolean isDirected) {
   int count = 0;
   for (int i=0; i<g.V; i++) {
     for (int j=0; j<g.V; j++) {
       for (int k=0; k<g.V; k++) {
           if (g.adj[i].contains(j)
             && g.adj[j].contains(k)
               && g.adj[k].contains(i)) {
            count++;
         }
       }
     }
   }
   return isDirected ? count/3 : count/6;
  }

  public static int getNumberOfTriangles(Graph g) {
    boolean[] visited = new boolean[g.V];
    int count = 0;
    for (int i=0; i<g.V; i++) {
      count += dfs(g, visited, i, -1);
    }
    return count;
  }

  private static int dfs(Graph g, boolean[] visited, int vertex, int parent) {
    if (visited[vertex]) {
     return 0;
    }
    visited[vertex] = true;
    int count = 0;
    for (int child : g.adj[vertex]) {
      if (!visited[child]) {
        count += dfs(g, visited, child, vertex);
      } else {
        count += g.adj[child].contains(parent) ? 1 : 0;
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Graph g = new Graph(4);
    g.addEdge(0, 2);
    g.addEdge(1, 0);
    g.addEdge(2, 1);
    g.addEdge(1, 3);
    g.addEdge(3, 2);

    System.out.println("Using Three For loop: " + getNumberOfTriangles(g, true));
    System.out.println("Using Efficient Algorithm: " + getNumberOfTriangles(g));
  }
}
