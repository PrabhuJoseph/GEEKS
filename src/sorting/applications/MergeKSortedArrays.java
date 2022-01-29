package sorting.applications;

// https://www.geeksforgeeks.org/merge-k-sorted-arrays/

// Min Heap

import java.util.Arrays;

public class MergeKSortedArrays {

    public static int getMin(int[] arr) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            minHeapify(arr, i, n);
        }
        System.out.println(arr[0]);
        return arr[0];
    }


    public static void sort(int[][] arrs) {
        int[] output = new int[arrs.length * arrs[0].length];
        int outLen = 0;

        int[] ptrs = new int[arrs.length];
        int[] tempArr = new int[arrs.length];

        // Initialize
        for (int i=0; i<arrs.length; i++) {
          tempArr[i] = arrs[i][0];
          ptrs[i] = 0;
        }

        while (outLen < output.length) {
          int curMin = getMin(tempArr);
          output[outLen++] = curMin;

          for (int i=0; i< ptrs.length; i++) {
            if (ptrs[i] < arrs[0].length && curMin == arrs[i][ptrs[i]]) {
              ptrs[i] = ptrs[i] + 1;
              if (ptrs[i] >= arrs[0].length) {
                tempArr[0] = Integer.MAX_VALUE;
              } else {
                tempArr[0] = arrs[i][ptrs[i]];
              }
              break;
            }
          }
        }
        System.out.println("OUTPUT ARRAY: " + Arrays.toString(output));
    }

    public static void minHeapify(int[] arr, int level, int n) {
        int left = 2*level + 1;
        int right = 2 * (level+1);
        int small = level;
        if (left < n && arr[small] > arr[left]) {
            small = left;
        }
        if (right < n && arr[small] > arr[right]) {
            small = right;
        }
        if (small != level) {
            int temp = arr[level];
            arr[level] = arr[small];
            arr[small] = temp;

            minHeapify(arr, small, n);
        }
    }


    public static void main(String[] args) {
        int[][] arrs = {{1,2,3,5}, {4, 5,6,12}, {7, 9,10,11}};
        sort(arrs);
    }

}