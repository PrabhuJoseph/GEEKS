package sorting;

public class MergeSort {

    // Time Complexity: O(nlogn)

    public static void merge(int[] arr, int start, int middle, int end) {
        int i = start;
        int j = middle+1;
        int newarr[] = new int[end +1 - start];
        int k = 0;

        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                newarr[k] = arr[i];
                i++;
            } else {
                newarr[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= middle) {
            newarr[k]  = arr[i];
            i++;
            k++;
        }

        while (j <= end) {
            newarr[k]  = arr[j];
            j++;
            k++;
        }

        k =0;
        for (i=start; i <= end; i++) {
            arr[i] = newarr[k++];
        }
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, start, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, start, middle, end);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, arr.length-1);

        System.out.println("OUTPUT");
        for(int a : arr) {
            System.out.println(a);
        }

    }
}
