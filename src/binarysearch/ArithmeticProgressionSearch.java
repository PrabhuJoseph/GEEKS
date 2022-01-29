package binarysearch;

class ArithmeticProgressionSearch {

  static int findMissingUtil(int arr[], int low,
      int high, int diff) {
    if (high <= low) {
      return -1;
    }
    int mid = high + low / 2;
    if (arr[mid] - arr[mid-1] != diff) {
       return arr[mid] - diff;
    }
    if ((mid+1) < arr.length && (arr[mid+1] - arr[mid]) != diff) {
      return arr[mid+1] - diff;
    }
    if (arr[mid] == (mid * diff) + arr[0]) {
     return findMissingUtil(arr, mid+1, high, diff);
    }
    return findMissingUtil(arr,low,mid-1,diff);
  }


  static int findMissing(int arr[], int n) {
    int diff = (arr[n - 1] - arr[0]) / n;
    System.out.println(diff);
    return findMissingUtil(arr, 0, n - 1, diff);
  }

  public static void main (String[] args) {
    int arr[] = {2, 4, 6, 8, 10, 14, 16};
    int n = arr.length;
    System.out.println("The missing element is "+
        findMissing(arr, n));
  }
}

