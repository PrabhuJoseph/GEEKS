package dynamicprogramming;

// https://www.youtube.com/watch?v=7qMMqAIve78
// https://www.hackerrank.com/challenges/sherlock-and-cost/problem
public class SherlockCost {

  /*
  3   5   10   2

  route1 => 3 to 1 to 10 to 1
  route2 => 1 to 5 to 1 to 2
   */

  public static int efficientCost(int[] points) {
    int routeA = 0, routeB = 0;
    int pointA1 = points[0], pointA2;
    int pointB1 = 1, pointB2;
    boolean toggle = true;
    for (int i=1; i<points.length; i++) {
      if (toggle) {
        pointA2 = 1;
        pointB2 = points[i];
      } else {
        pointA2 = points[i];
        pointB2 = 1;
      }
      routeA = routeA + Math.abs(pointA1 - pointA2);
      routeB = routeB + Math.abs(pointB1 - pointB2);
      pointA1 = pointA2;
      pointB1 = pointB2;
      toggle = !toggle;
    }
    return Math.max(routeA, routeB);
  }

  public static void main(String[] args) {
    int[] points = {3,5,10,2};
    //int[] points = {10,1,10,1,10,1,10};
    int[][] distances = new int[points.length][2];

    distances[0][0] = 0;
    distances[0][1] = 0;

    int prevMax = points[0];
    boolean swap = false;
    for (int i=1; i<points.length; i++) {
      int max = points[i];
      if (swap) {
         max = prevMax;
         prevMax = points[i];
      }
      distances[i][0] = Math.abs(max - 1) + distances[i-1][0];
      distances[i][1] = Math.abs(prevMax - 1) + distances[i-1][1];
      prevMax = points[i];
      swap = !swap;
    }
    System.out.println(Math.max(distances[points.length-1][0], distances[points.length-1][1]));
    System.out.println("Efficienct Cost: " + efficientCost(points));

  }
}
