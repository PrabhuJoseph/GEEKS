package sorting;

public class HeapSort {

    // O(nlogn)

    // Binary Heap = https://www.geeksforgeeks.org/binary-heap/

    // Min Heap and Max Heap


    public void sort(int[] arr) {
        int n = arr.length;
        for (int i = n/2 -1; i >=0; i--) {
            heapify(arr, i, n);
        }
        for (int i=n-1; i>=0;i--) {
            int temp = arr[i];
            arr[i]=arr[0];
            arr[0]=temp;
            heapify(arr, 0 ,i);
        }
    }

    public void heapify(int[] arr, int level, int n) {
        System.out.println("LEVEL="+level);
        int left = 2*level + 1;
        int right = 2 * (level+1);
        int large = level;
        if (left < n && arr[large] < arr[left]) {
            large = left;
        }
        if (right < n && arr[large] < arr[right]) {
            large = right;
        }
        if (large != level) {
            int temp = arr[level];
            arr[level] = arr[large];
            arr[large] = temp;

            printArray(arr);
            heapify(arr, large, n);
        }
    }

    public void printArray(int[] arr) {
        for (int i: arr) {
            System.out.println(i);
        }
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {2,8,5,3,9,1,6};
        int n = arr.length;

        HeapSort ob = new HeapSort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        ob.printArray(arr);
    }
}
