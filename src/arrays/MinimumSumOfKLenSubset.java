package arrays;

public class MinimumSumOfKLenSubset {
  // https://www.geeksforgeeks.org/number-of-k-length-subsequences-with-minimum-sum/?ref=leftbar-rightbar

  // Another Approach is to sort and then pick first K elements

  public static int getMinSum(int[] arr, int[] data, int K, int i, int n, int index) {
    if (index == K) {
      int sum = 0;
      for (int q=0; q<K; q++) {
        sum += data[q];
      }
      return sum;
    }
    if (i >= n) {
      return Integer.MAX_VALUE;
    }
    data[index] = arr[i];
    int sum1 = getMinSum(arr, data, K, i+1, n, index+1);
    int sum2 = getMinSum(arr, data, K, i+1, n, index);
    return Math.min(sum1, sum2);
  }

  public static void main(String[] args) {
    int[] arr = new int[] {6,2,3,4,7};
    int K =3;
    System.out.println("MIN SUM: " + getMinSum(arr, new int[K], K, 0, arr.length, 0));
  }
}
