package algorithms;

public class IntervalScheduling {

  public static int getMax(int[][] lectures) {
    int max = Integer.MIN_VALUE;
    for (int i=0; i<lectures.length; i++) {
      max = Math.max(max, lectures[i][1]);
    }
    return max;
  }

  public static int minHalls(int[][] lectures, int n) {
    int max = getMax(lectures);
    int[] halls = new int[max + 2];
    for (int i=0; i<lectures.length; i++) {
      halls[lectures[i][0]] += 1;
      halls[lectures[i][1] + 1] -= 1;
    }
    int minHalls = Integer.MIN_VALUE;
    for (int i=1; i<halls.length; i++) {
      halls[i] = halls[i] + halls[i-1];
      minHalls = Math.max(halls[i], minHalls);
    }
    return minHalls;
  }

  public static void main(String[] args) {
      int lectures[][] = {{ 0, 5 },
              { 1, 2 },
              { 1, 10 }};
      int n = lectures.length;
      System.out.println(minHalls(lectures, n));
  }
}
