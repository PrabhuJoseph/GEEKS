package recursion;

public class SumRecursion {

  // COUNT ALL SUBSET MATCHES SUM

  public static int subsetSum(int[] arr, int n, int sum, int count) {
    if (sum == 0) {
      count++;
      return count;
    }
    if (sum < 0 || n < 0) {
      return count;
    }

    count = subsetSum(arr, n-1, sum-arr[n], count);
    count = subsetSum(arr, n-1, sum, count);
    return count;
  }


  public static void main(String[] args) {
    int[] arr = new int[] {1, 2, 3, 3};
    int sum = 4;
    System.out.println(subsetSum(arr, arr.length-1,  sum, 0));

  }

}