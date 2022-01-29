package dynamicprogramming;

public class StaircaseProblem {

  // https://www.youtube.com/watch?v=5o-kdjv7FD0

  private static int getNumWays(int n, int[] x) {
    if (n==0) {
      return 1;
    }
    int[] temp = new int[n+1];
    temp[0] = 1;
    for (int i=1; i<=n; i++) {
      int total = 0;
      for (int j : x) {
        if (i-j>=0)
        total += temp[i-j];
      }
      temp[i] = total;
    }
    return temp[n];
  }

  public static void main(String[] args) {
    int n = 5;
    int[] x = {1, 2, 3};
    System.out.println(getNumWays(n, x));
  }
}
