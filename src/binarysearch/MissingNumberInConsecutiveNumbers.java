package binarysearch;

public class MissingNumberInConsecutiveNumbers {

  public static void main(String args[]){
    int arr[] = {3,5,6,7,8,9,10,11,12};
    MissingNumberInConsecutiveNumbers mn = new MissingNumberInConsecutiveNumbers();
    System.out.println(mn.findMissing(arr));
  }

  private int findMissing(int[] arr) {
    int low = 0;
    int high = arr.length;
    int lownum = arr[0];
    while (low <= high) {
      int mid = (low + high) / 2;
      if (arr[mid] == lownum + mid + 1 && (mid-1>=0) && (arr[mid-1] == lownum + mid - 1)) {
        return lownum + mid;
      }
      else if (arr[mid] == lownum + mid) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return -1;
  }
}
