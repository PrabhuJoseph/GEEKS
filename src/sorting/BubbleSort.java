package sorting;

public class BubbleSort {

    // BubbleSort takes O(n^2)
    public static void bubbleSort(int[] arr) {
        for (int i=0; i<arr.length; i++) {
            for (int j=i; j<arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {10, 7, 8, 9, 1, 5};
        bubbleSort(arr);
        for (int i: arr)
            System.out.println(i);
    }
}
