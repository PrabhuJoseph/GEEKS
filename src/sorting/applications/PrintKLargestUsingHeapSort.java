package sorting.applications;

public class PrintKLargestUsingHeapSort {

    public void printKLargest(int[] arr, int K) {
        int n = arr.length;

        // Build Max Heap Tree in O(n)
        for (int i = n/2 -1; i >=0; i--) {
            heapify(arr, i, n);
        }

        // Get K Max Elements in O(k * log(n))
        for (int i=n-1; i>=0 && K>0; i--,K--) {
            int temp = arr[i];
            System.out.println(arr[0]);
            arr[i]=arr[0];
            arr[0]=temp;
            heapify(arr, 0 ,i);
        }
    }

    // Max Heap for ascending sort
    // Min Heap for descending sort
    public void heapify(int[] arr, int level, int n) {
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

            heapify(arr, large, n);
        }
    }

    // Driver program
    public static void main(String args[])
    {
        int arr[] = {2,8,5,3,9,1,6};
        int n = arr.length;

        int K=3;
        PrintKLargestUsingHeapSort ob = new PrintKLargestUsingHeapSort();
        ob.printKLargest(arr, K);

    }
}
