package matrix;

import java.util.LinkedList;
import java.util.List;

public class RotateEachRingAnticlockwise {
    // https://www.geeksforgeeks.org/rotate-ring-matrix-anticlockwise-k-elements/

  private static void rotate(int[][] mat, int K) {
    List<List<Integer>> rings = new LinkedList<>();
    int count = 0;
    int direction = 0;
    int i=0, j=0;
    int M = mat.length;
    int N = mat[0].length;
    boolean[][] visited = new boolean[M][N];
    List<Integer> curRing = null;
    int start = -1;
    while (count < M * N) {
      if (direction == 0) {
        curRing = new LinkedList<>();
        start = mat[i][j];
        for (;j<N && !visited[i][j]; j++) {
          System.out.println("->"+mat[i][j]);
          curRing.add(mat[i][j]);
          count++;
          visited[i][j] = true;
        }
        j--;
        i++;
        direction++;
      } else if (direction == 1) {
        for (; i<M && !visited[i][j]; i++) {
          System.out.println("Down" + mat[i][j]);
          curRing.add(mat[i][j]);
          count++;
          visited[i][j] = true;
        }
        i--;
        j--;
        direction++;
      } else if (direction == 2) {
        for (; j>=0 && !visited[i][j]; j--) {
          System.out.println("<-" + mat[i][j]);
          curRing.add(mat[i][j]);
          count++;
          visited[i][j] = true;
        }
        j++;
        i--;
        direction++;
      } else {
        for (; i>=0 && !visited[i][j]; i--) {
          System.out.println("Up" + mat[i][j]);
          curRing.add(mat[i][j]);
          count++;
          visited[i][j] = true;
        }
        if (start == mat[i][j]) {
          rings.add(curRing);
        }
        i++;
        j++;
        direction = 0;
      }
    }
    rings.add(curRing);
    for (List<Integer> ring : rings) {
      for (int X : ring) {
        System.out.print(X + "->");
      }
      System.out.println();
    }
  }

  /*
  1   2   3   4    5
  6   7   8   9   10
 11  12  13  14   15
 16  17  18  19   20
 21  22  23  24   25
   */

  public static void main(String[] args) {
    // int[][] mat = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
    int[][] mat = {{1,2,3,4,5}, {6,7,8,9,10}, {11,12,13,14,15}, {16,17,18,19,20}, {21,22,23,24,25}};
    int K=3;
    rotate(mat, K);
  }
}
