package arrays;

import java.util.ArrayList;
import java.util.HashSet;


// Number of sub arrays with negative product

// https://www.geeksforgeeks.org/number-of-sub-arrays-with-negative-product/

public class NegativeProductSubArray {

    public static int[] product(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i=0; i<arr.length; i++) {
            if (arr[i] < 0) {
                ret[i] = -1;
            } else {
                ret[i] = 1;
            }
        }
        for (int i=0; i<ret.length; i++) {
            int temp = ret[i];
            for (int j=i+1; j<ret.length; j++) {
                temp = temp * ret[j];
            }
            ret[i] = temp;
        }
        System.out.println("RET ARRAY");
        for (int i : ret) {
            System.out.println(i);
        }
        return ret;
    }

    public static int negativeProduct(int[] arr) {
        int[] ret = product(arr);
        int count = 0;
        for (int i=0; i<ret.length; i++) {
            if (ret[i] < 0) {
                count++;
            }
            int j = i+1;
            while (j < ret.length) {
                if ((ret[j] * ret[i]) < 0){
                    count++;
                }
                j++;
            }
        }
        return count;
    }

    public static int negativeProduct(int[] arr, int[] data, int i, int n, int index, int r, int sum) {
      if (index == r) {
        int product = 1;
        for (int x : data) {
         product = product * x;
        }
        if (product == -1) {
          sum+=1;
        }
        return sum;
      }
      if (i >= n) {
        return sum;
      }
      data[index] = arr[i];
      int sum1 = negativeProduct(arr, data, i+1, n, index+1, r, sum);
      int sum2 = negativeProduct(arr, data, i+1, n, index, r, sum);
      return sum1 + sum2;
    }

    public static int recursiveNegativeProduct(int[] arr) {
      int[] ret = new int[arr.length];
      for (int i=0; i<arr.length; i++) {
        if (arr[i] < 0) {
          ret[i] = -1;
        } else {
          ret[i] = 1;
        }
      }
      int sum = 0;
      for (int i=0; i<ret.length; i++) {
        int cur = negativeProduct(ret, new int[i], 0, ret.length, 0, i, 0);
        System.out.println("COMBINATION: "+ i+"---"+cur);
        sum += cur;
      }
      return sum;
    }

    public static void main(String[] args) {
        int[] arr = {5, -4, -3, 2, -5}; // OUTPUT: 8
        // int[] arr = {-1, 2, -2}; // OUTPUT: 4
        System.out.println("EFFICIENT APPROACH WITH SUBSEQUENT SUBARRAYS: " + negativeProduct(arr));
        System.out.println("ALL COMBINATONS APPROACH: " + recursiveNegativeProduct(arr));

    }
}
