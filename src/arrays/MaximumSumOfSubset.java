package arrays;


// Includes Neagative Element so sum of elements won't be right

public class MaximumSumOfSubset {

    public static int maxSum(int[] arr, int i, int n, int sum) {
        if (i >= n) {
            return sum;
        }
        int includeSum =  maxSum(arr,i+1, n, sum + arr[i]);
        int excludeSum = maxSum(arr, i+1, n, sum);
        return Math.max(includeSum, excludeSum);
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 6, 5, 1, 8, -9};
        int maxSum = maxSum(arr, 0, arr.length, 0);
        System.out.println("Output: "+ maxSum);
    }
}
