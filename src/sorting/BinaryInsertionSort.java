package sorting;

public class BinaryInsertionSort {

  // Worst Case = O(n2) and Best Case O(nlogn)

  public static void binaryInsertionSort(int[] arr) {
    int high = arr.length;
    for (int i=0; i<high; i++) {
      binarySort(arr, i);
    }
  }

  public static void binarySort(int[] arr, int high) {
    if (high==0) {
      return;
    }
    if (high == 1 && arr[0] > arr[1]) {
      int temp = arr[1];
      arr[1] = arr[0];
      arr[0] = temp;
      return;
    }
    int position = findPlaceToInsert(arr, 0, high-1, high);
    int element = arr[high];
    for (int i=high; i>position; i--) {
      arr[i] = arr[i-1];
    }
    arr[position] = element;
  }

  private static int findPlaceToInsert(int[] arr, int start, int end, int high) {
    if (start == end) {
      return start;
    }
    int mid = (start + end) / 2;
    if (arr[mid] > arr[high]) {
      return findPlaceToInsert(arr, start, mid-1, high);
    } else {
      return findPlaceToInsert(arr, mid+1, end, high);
    }
  }


  public static void main(String[] args) {
    int arr[] = {10, 7, 8, 9, 1, 5};
    binaryInsertionSort(arr);
    for (int i: arr)
      System.out.println(i);
    }
}
