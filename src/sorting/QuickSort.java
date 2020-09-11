package sorting;

public class QuickSort {

    // Time Complexity: O(n2) for worst case, and O(nlogn) for best case


    private static int partition(int[] arr, int start, int end) {
      int pivot = arr[end];
      int i=start-1;
      for (int j=start; j<end; j++) {
        if (arr[j] < pivot) {
          i++;
          int temp = arr[i];
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
      arr[end] = arr[i+1];
      arr[i+1] = pivot;
      return i+1;
    }

    private static void quickSort(int[] arr, int start, int end) {
      if (start < end) {
        int pi = partition(arr, start, end);
        quickSort(arr, start, pi-1);
        quickSort(arr, pi+1, end);
      }
    }

    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        quickSort(arr, 0, arr.length-1);

        for (int i: arr)
            System.out.println(i);
    }
}

