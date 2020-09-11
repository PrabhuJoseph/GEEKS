package sorting;

public class SelectionSort {

    // Selection Sort takes o(n^2) Worst case, best case O(nlogn)
    public static int findMinIndex(int[] arr, int low, int high) {
        int min_index = low;
        int min = arr[low];

        if (low == high) {
            return min_index;
        }
        for (int i=low+1; i<high; i++) {
            if (arr[i] < min) {
                min = arr[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static void selectionSort(int[] arr) {
        int high = arr.length;
        int min_index;
        int temp;
        for (int i=0; i<high; i++) {
            min_index = findMinIndex(arr, i, high);
            temp = arr[i];
            arr[i] = arr[min_index];
            arr[min_index] = temp;
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        selectionSort(arr);
        for (int i: arr)
            System.out.println(i);
    }
}
