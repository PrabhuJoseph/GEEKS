package arrays;


// https://www.geeksforgeeks.org/maximum-sum-of-elements-divisible-by-k-from-the-given-array/

public class MaximumSumDivisibleByK {

  static int X = 0;


  public static int maxSum(int[] arr, int K, int i, int n, int sum) {
    if (i >= n) {
      return sum;
    }

    int includeSum =  maxSum(arr, K, i+1, n, sum + arr[i]);
    if (!(includeSum!=0 && includeSum % K == 0)) {
      includeSum = Integer.MIN_VALUE;
    }
    int excludeSum = maxSum(arr, K, i+1, n, sum);
    if (!(excludeSum!=0 && excludeSum % K == 0)) {
      excludeSum = Integer.MIN_VALUE;
    }

    return Math.max(includeSum, excludeSum);
  }


  public static void main(String[] args) {

    int[] arr = new int[] {3, 6, 5};
    int K = 3;
    int maxSum = maxSum(arr, K, 0, arr.length, 0);
    System.out.println("Output: "+ maxSum);
  }
}
