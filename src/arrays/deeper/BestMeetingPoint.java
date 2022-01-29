package arrays.deeper;

/*

References:

https://www.youtube.com/watch?v=6U0mIJjLzHw

https://github.com/mission-peace/interview/blob/master/src/com/interview/array/BestMeetingPoint.java

 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BestMeetingPoint {

  public static int minDistance(int[][] grid) {

    if (grid.length == 0 || grid[0].length == 0) {
      return 0;
    }

    // Get the rows and cols for the houses
    int rowLen = grid.length;
    int colLen = grid[0].length;

    List<Integer> rows = new ArrayList<>();
    List<Integer> cols = new ArrayList<>();

    for (int a=0; a<rowLen; a++) {
      for (int b=0; b<colLen; b++) {
        if (grid[a][b] == 1) {
          rows.add(a);
          cols.add(b);
          System.out.println(a + "---" + b);
        }
      }
    }

    // Sort the houses points to find the median
    Collections.sort(rows);
    Collections.sort(cols);

    int middlePoint = rows.size() / 2;
    int rowMedian = rows.get(middlePoint);
    int colMedian = cols.get(middlePoint);

    System.out.println(rowMedian + "---" + colMedian);

    int sum = 0;
    for (int rowPoint : rows) {
      sum += Math.abs(rowMedian - rowPoint);
    }

    for (int colPoint : cols) {
      sum += Math.abs(colMedian - colPoint);
    }

    return sum;
  }

  public static void main(String[] args) {
    int[][] grid = {{1, 0, 0, 0, 1}, {0, 0, 0, 0, 0},{0, 0, 1, 0, 0}};
    System.out.println(minDistance(grid));
  }
}
