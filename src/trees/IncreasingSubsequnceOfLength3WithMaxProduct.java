package trees;


// https://github.com/mission-peace/interview/blob/master/src/com/interview/array/IncreasingSubsequnceOfLength3WithMaxProduct.java

// https://www.geeksforgeeks.org/maximum-product-increasing-subsequence-size-3/

// AVL Tree application
public class IncreasingSubsequnceOfLength3WithMaxProduct {

    public static void printSmallestElement(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<n; i++) {
          int temp = arr[i];
          arr[i] = min;
          min = Math.min(min, temp);
        }
        arr[0] = -1;
        for (int x : arr) {
          System.out.print(x + "\t");
        }
    }

        public static void printGreatestElement(int[] arr) {
            int n = arr.length;
            int max = -1;
            for (int i=n-1; i>=0; i--) {
                int temp = arr[i];
                arr[i] = max;
                max = Math.max(max, temp);
            }
            for (int x : arr) {
                System.out.print(x + "\t");
            }
        }

        public static void main(String[] args) {
            int[] arr = {10, 5, 7, 9, 2};
            printGreatestElement(arr);
            System.out.println();
            int[] arr1 = {10, 5, 7, 9, 2};
            printSmallestElement(arr1);
        }

    }

