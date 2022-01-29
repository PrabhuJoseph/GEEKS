package arrays.deeper;

public class CircleGasStation {
    // https://www.geeksforgeeks.org/find-a-tour-that-visits-all-stations/
    // https://www.youtube.com/watch?v=zcnVaVJkLhY

    public static void main(String[] args) {
      // Petrol, Distance
      int[][] pumps =  {{ 6, 4 }, { 3, 6 }, { 7, 3 }, {3,6}, {7,3}};
      getBestStartPoint(pumps);
    }

    private static void getBestStartPoint(int[][] pumps) {
      int capacity = 0;
      int totalCapacity = 0;
      int start = 0;
      for (int i=0; i< pumps.length; i++) {
        capacity += pumps[i][0] - pumps[i][1];
        totalCapacity += pumps[i][0] - pumps[i][1];
        if (capacity < 0) {
          start = i+1;
          capacity = 0;
        }
      }
      if (totalCapacity > 0) {
        System.out.println(start);
      } else {
        System.out.println(-1);
      }
    }

}
