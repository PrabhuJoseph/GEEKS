package slidingwindow;

// https://www.youtube.com/watch?v=S6Xg-0uaODc
public class FindMinSubArrayWithGivenSum {

  public static void main(String[] args) {
    int[] arr = {2,3,1,3,4,3,8,9,1,3,4};
    int targetSum = 7;
    System.out.println(getMinSubArray(arr, targetSum));
  }

  private static int getMinSubArray(int[] arr, int target) {
    int left=0, right=0;
    int curSum = 0;
    int minLen = Integer.MAX_VALUE;
    while (right < arr.length) {
      while (curSum < target && right < arr.length) {
        curSum += arr[right++];
      }
      System.out.println("Right curSum: " + curSum);
      while (curSum >= target && left <= right) {
        curSum -= arr[left++];
      }
      System.out.println("Left curSum: " + (curSum + arr[left-1]));
      if (curSum + arr[left-1] >= target) {
        minLen = Math.min(minLen, right-left+1);
      }
      System.out.println(left + "----" + right);
    }
    return minLen;
  }
}
