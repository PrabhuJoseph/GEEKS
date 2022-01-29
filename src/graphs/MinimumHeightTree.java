package graphs;

// https://www.youtube.com/watch?v=ivl6BHJVcB0

import java.util.LinkedList;

public class MinimumHeightTree {

    public static void main(String[] args) {
        int input[][] = {{1,0},{1,2},{1,3}};
        int V = 4;
        int[] degree = new int[V];
        LinkedList<Integer>[] adj = new LinkedList[V];
        for (int i=0; i<V; i++) {
          adj[i] = new LinkedList<>();
        }
        for (int i=0; i<input.length; i++) {
            degree[input[i][0]]++;
            degree[input[i][1]]++;
            adj[input[i][0]].add(input[i][1]);
            adj[input[i][1]].add(input[i][0]);
        }
        int n = V;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i=0; i<degree.length; i++) {
          if (degree[i]==1) {
            System.out.println("Degree 1 : " + i);
            queue.add(i);
          }
        }

        while (n > 2) {
          int size = queue.size();
          n-=size;
          while (size-- > 0) {
            int x = queue.poll();
            for (int y : adj[x]) {
              degree[y]--;
              if (degree[y] == 1) {
                queue.add(y);
              }
            }
          }
        }
        for (int x : queue) {
            System.out.println(x);
        }

    }
}
