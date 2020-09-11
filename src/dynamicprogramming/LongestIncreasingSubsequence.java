package dynamicprogramming;

public class LongestIncreasingSubsequence {

  // https://www.techiedelight.com/longest-increasing-subsequence-using-dynamic-programming/


  private static int findLIS(int[] arr, int start, int n, int prev) {
    if (start == n) {
      return 0;
    }
    int include = 0;
    if (arr[start] > prev) {
      include = 1 + findLIS(arr, start+1, n, arr[start]);
    }
    int exclude = findLIS(arr, start+1, n, prev);
    return Math.max(include, exclude);
  }

  public static void main(String[] args) {
    int[] arr = new int[] {1, 3, 5, 6, 2, 4, 8, 10, 17};
    int result = findLIS(arr, 0, arr.length, Integer.MIN_VALUE);
    System.out.println("LongestIncreasingSubsequence="+ result);
  }
}
