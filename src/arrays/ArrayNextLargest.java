package arrays;

public class ArrayNextLargest {

    // 1. Sorted Array
    // 2. Use Binary Search to find the element.

    public static int findSmallest(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while (start <=end) {
            int mid = (start+ end) / 2;
            if (arr[mid] >= target) {
                end = mid-1;
            } else {
                ans = mid;
                start = mid+1;
            }
        }
        return ans!=-1 ? arr[ans] : -1;
    }

    public static int findLargest(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        int ans = -1;

        while (start <= end) {
            int mid = (start+ end) / 2;
            if (arr[mid] <= target) {
                start = mid+1;
            } else {
                ans = mid;
                end = mid-1;
            }
        }
        return ans!=-1 ? arr[ans] : -1;
    }


    public static void main(String[] args) {
        int[] input = new int[]{1,4,5,5,5,5,5,7,9,9,15};
        int n = 5;
        System.out.println("SMALLEST="+findSmallest(input, n)+"---LARGEST="+findLargest(input, n));
    }
}
