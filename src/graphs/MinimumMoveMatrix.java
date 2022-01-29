package graphs;

// https://www.geeksforgeeks.org/find-minimum-numbers-moves-needed-move-one-cell-matrix-another/

import java.util.LinkedList;
import java.util.Queue;

public class MinimumMoveMatrix {
  static class Graph {
    int V;
    LinkedList<Integer>[] adj;
    public Graph(int V) {
      this.V = V;
      this.adj = new LinkedList[V];
      for (int i=0; i<V; i++) {
        adj[i] = new LinkedList();
      }
    }
    public void addEdge(int V1, int V2) {
      adj[V1].add(V2);
      adj[V2].add(V1);
    }
  }

  private static boolean isSafe(int x, int y, int[][] M) {
    if (x<0 || x >=M.length || y<0 || y>=M[0].length || M[x][y]==0) {
      return false;
    }
    return true;
  }

  private static int distanceThroughBFS(Graph g, int s, int d) {
    int[] level = new int[g.V+1];
    for (int i=0; i<level.length; i++) {
      level[i] = -1;
    }
    level[s] = 0;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);

    while (queue.size() > 0) {
      int cur = queue.poll();
      for (int adj : g.adj[cur]) {
        if (level[adj]<0 || level[adj] > level[cur]+1) {
          level[adj] = level[cur] + 1;
          // Traverse the adj if it level got changed so it's dependencies will also can be changed.
          queue.add(adj);
        }
      }
    }
    return level[d];
  }

  public static void main(String[] args) {

    /*

    Find distance between 1 and 2. 3 is the path through which they have to connect and 0 is the wall.

    0   3   2
    3   3   0
    1   3   0


     */

    int[][] M = { {0,3,2}, {3,3,0}, {1,3,0} };
    Graph g = new Graph(M.length * M[0].length);
    int k=1;
    int s=0 ,d =0;
    for (int i=0; i<M.length; i++) {
      for (int j=0; j<M[0].length; j++) {
        if (M[i][j] !=0) {
          if (isSafe(i, j+1, M)) {
            g.addEdge(k, k+1);
          }
          if (isSafe(i, j-1, M)) {
            g.addEdge(k, k-1);
          }
          if (isSafe(i+1, j, M)) {
            g.addEdge(k, k+ M.length);
          }
          if (isSafe(i-1, j, M)) {
            g.addEdge(k, k-M.length);
          }
        }
        if (M[i][j] == 1) {
         s = k;
        }
        if (M[i][j] == 2) {
         d = k;
        }
        k++;
      }
    }
    System.out.println("Distance between " + s + " and " + d + " is: "
        + distanceThroughBFS(g, s, d));
  }

}
