package dynamicprogramming;

// https://www.youtube.com/watch?v=IFNibRVgFBo

public class BalloonBurst {

  static int getMaxValue(int[] balloons) {
    int bLen = balloons.length;
    int[][] dp = new int[bLen][bLen];

    for (int level=1; level<=bLen; level++) {
      System.out.println("Level: " + level);
      for (int i=0; i<=bLen-level; i++) {
        System.out.println("I: " + i);
        int max = Integer.MIN_VALUE;
        for (int k=i; k<=i+level-1; k++) {
          System.out.println("K="+ k);
          int left, right;
          if (k==i) {
            left = 0;
          } else {
            if (k-1>=0) {
              left = dp[i][k - 1];
            } else {
              left = 0;
            }
          }
          if (k==i+level-1) {
            right = 0;
          } else {
            right = dp[k+1][i+level-1];
          }
          int leftMul, rightMul;
          if (i-1<0) {
            leftMul = 1;
          } else {
            leftMul = balloons[i-1];
          }
          if (i+level>=bLen) {
            rightMul = 1;
          } else {
            if (i + level > bLen) {
              rightMul = 1;
            } else {
              rightMul = balloons[i + level];
            }
          }
          System.out.println(left + "---" + right + "---" + leftMul + "---"+ rightMul + "---" + balloons[k]);
          max = Math.max(max, left + right + (leftMul * rightMul * balloons[k]));
        }
        System.out.println("Storing : " + i + "---" + (i+level-1) + "---" + max);
        dp[i][i+level-1] = max;
      }
    }
    return dp[0][bLen-1];
  }

  public static void main(String[] args) {
    // int[] balloons = {3, 1, 5, 8}; // OUTPUT: 167
    int[] balloons = {1, 5}; // OUTPUT: 10
    System.out.println(getMaxValue(balloons));
  }

 }
