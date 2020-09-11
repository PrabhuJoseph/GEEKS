package graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class Graph {

  int V;
  LinkedList<Integer> adj[];

  public Graph(int V) {
    this.V = V;
    adj = new LinkedList[V];
    for (int i=0; i<V; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int src, int dest) {
    adj[src].add(dest);
  }

  public void dfs(int v, boolean[] visited) {
      if (!visited[v]) {
          visited[v] = true;
          System.out.println(v);

          LinkedList list = adj[v];
          Iterator<Integer> itr = list.listIterator();
          while (itr.hasNext()) {
              dfs(itr.next(), visited);
          }
      }
  }


    public void bfs(int v, boolean[] visited) {

     LinkedList<Integer> queue = new LinkedList();
     queue.add(v);
     visited[v] = true;

     while (queue.size() != 0) {
         int s = queue.poll();
         System.out.println(s);

             LinkedList list = adj[s];
             Iterator<Integer> itr = list.listIterator();
             while (itr.hasNext()) {
                 int n = itr.next();
                 if (!visited[n]) {
                     visited[n] = true;
                     queue.add(n);
                 }
             }
         }
    }


    public static void main(String[] args) {
    Graph g = new Graph(3);
    boolean visited[] = new boolean[3];
    g.addEdge(0,1);
    g.addEdge(0,2);
    g.addEdge(1,2);
    g.dfs(0, visited);

    visited = new boolean[3];
    g.bfs(0, visited);
  }

}
