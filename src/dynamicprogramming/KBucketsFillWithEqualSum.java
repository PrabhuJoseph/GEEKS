package dynamicprogramming;

/*

Reference: https://www.youtube.com/watch?v=qpgqhp_9d1s

 */

import java.util.Arrays;

public class KBucketsFillWithEqualSum {

  public boolean canPartition(int[] arr, int curSum,
      int targetSum, int partitionCount, boolean[] used) {
    if (partitionCount == 1) {
      return true;
    }
    if (targetSum == curSum) {
      return canPartition(arr, 0, targetSum, partitionCount-1, used);
    }
    for (int i=0; i<arr.length; i++) {
      if (!used[i]) {
        used[i] = true;
        if (canPartition(arr, curSum+arr[i], targetSum, partitionCount, used)) {
          return true;
        } else {
          used[i] = false;
        }
      }
    }
    return false;
  }

  public static void main(String[] args) {
    int[] arr = {5, 5, 1, 5, 4};
    KBucketsFillWithEqualSum obj = new KBucketsFillWithEqualSum();
    int partition = 4;
    int targetSum = 5;
    if (Arrays.stream(arr).sum() == targetSum * partition) {
      System.out.println(obj.canPartition(arr,  0, targetSum, partition, new boolean[arr.length]));
    }
  }
}
