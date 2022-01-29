package graphs;

import java.util.LinkedList;

public class DetectCycleInDirectedGraph {

    static class Graph {

        int V;
        LinkedList<Integer> adj[];

        public Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adj[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dest) {
            adj[src].add(dest);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        if(isCyclic(graph))
            System.out.println("Graph contains cycle");
        else
            System.out.println("Graph doesn't "
                    + "contain cycle");
    }

    private static boolean isCyclic(int x, Graph graph, boolean[] visited,
       boolean[] recvStack) {
      if (recvStack[x])
          return true;
      if (visited[x])
          return false;

      recvStack[x] = true;
      visited[x] = true;

      for (int xchild : graph.adj[x]) {
          if (isCyclic(xchild, graph, visited, recvStack)) {
              return true;
          }
      }
      recvStack[x] = false;
      return false;
    }

    private static boolean isCyclic(Graph graph) {
      boolean[] visited = new boolean[graph.V];
      boolean[] recvStack = new boolean[graph.V];

      for (int i=0; i<graph.V; i++) {
        if (isCyclic(i, graph, visited, recvStack)) {
           return true;
        }
      }
      return false;
    }
}
