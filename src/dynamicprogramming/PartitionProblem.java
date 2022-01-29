package dynamicprogramming;

import java.util.Arrays;

public class PartitionProblem {

  public static boolean subsetSum(int[] A, int n, int sum) {
    if (sum == 0) {
      return true;
    }
    if (sum < 0 || n<0) {
      return false;
    }
    return subsetSum(A, n-1, sum-A[n]) || subsetSum(A, n-1, sum);
  }


  public static boolean partition(int[] A) {
    int sum = Arrays.stream(A).sum();
    return (sum%2 == 0) && subsetSum(A, A.length-1, sum / 2);
  }

  public static void main(String[] args) {
    int[] A = { 7, 3, 2, 5, 1, 6 };
    System.out.println(partition(A));
  }
}
