package arrays.deeper;

import java.util.Arrays;

// https://www.geeksforgeeks.org/find-the-smallest-positive-number-missing-from-an-unsorted-array/
public class FirstPositiveMissing {

    
    // Driver code
    public static void main(String[] args)
    {
        int arr[] = { 2, 1, -10, -20, 0};
        int arr_size = arr.length;
        int missing = findMissing(arr, arr_size);
        System.out.println("The smallest positive missing number is " + missing);
    }

    private static int findMissing(int[] arr, int arr_size) {
      // Get a Seperate array with positive numbers
      int j=0;
      for (int i=0; i<arr.length; i++) {
        if (arr[i] <= 0) {
         int temp = arr[i];
         arr[i] = arr[j];
         arr[j] = temp;
         j++;
        }
      }
      System.out.println(Arrays.toString(arr));
      int[] arr1 = new int[arr.length-j];
      System.arraycopy(arr, j, arr1, 0, arr.length-j);

      System.out.println(Arrays.toString(arr1));

      // Mark the index as visited
      for (int i=0; i<arr1.length; i++) {
        int x = arr1[i];
        if (x-1 < arr1.length && x-1>=0) {
          arr1[x-1] = -arr1[x-1];
        }
      }

      System.out.println(Arrays.toString(arr1));

      for (int i=0; i<arr1.length; i++) {
        if (arr1[i] > 0) {
          return i+1;
        }
      }
      return arr1.length + 1;
    }
}
