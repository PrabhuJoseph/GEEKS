package arrays;


// https://www.geeksforgeeks.org/maximum-sum-of-elements-divisible-by-k-from-the-given-array/

import java.util.Arrays;

public class MaximumSumDivisibleByK {

  static int X = 0;



  // Use Memoization
  public static int maxSum(int[] arr, int K, int i, int n, int sum, int[][] dp) {
    if (i >= n) {
      return sum;
    }

    if (dp[i][sum] != -1) {
      return dp[i][sum];
    }

    int includeSum =  maxSum(arr, K, i+1, n, sum + arr[i], dp);
    if (!(includeSum!=0 && includeSum % K == 0)) {
      includeSum = Integer.MIN_VALUE;
    }
    int excludeSum = maxSum(arr, K, i+1, n, sum, dp);
    if (!(excludeSum!=0 && excludeSum % K == 0)) {
      excludeSum = Integer.MIN_VALUE;
    }

    return dp[i][sum] = Math.max(includeSum, excludeSum);
  }


  // Time Complexity O(nk)
  private static int efficientMethod(int[] arr, int K) {
    int[] dp = new int[K];
    Arrays.fill(dp, -1);
    dp[arr[0]%K] = arr[0];

    for (int i=1; i<arr.length; i++) {
      int[] temp = new int[K];
      System.arraycopy(dp, 0, temp, 0, dp.length);
      for (int y : dp) {
        if (y != -1) {
          int newNum = y + arr[i];
          temp[newNum%K] = Math.max(temp[newNum%K], newNum);
        }
      }
      dp = temp;
    }
    return dp[0];
  }

  public static void main(String[] args) {

    //int[] arr = new int[] {3, 6, 5};
    int[] arr = new int[] {1,3,5,6,8};
    int K = 3;
    int[][] dp = new int[1001][1001];
    for (int i = 0; i < dp.length; i++)
      for (int j = 0; j < dp[0].length; j++)
        dp[i][j] = -1;
    int maxSum = maxSum(arr, K, 0, arr.length, 0, dp);
    System.out.println("Output: "+ maxSum);
    System.out.println("Efficient Method with O(nk) : " + efficientMethod(arr, K));
  }
}
