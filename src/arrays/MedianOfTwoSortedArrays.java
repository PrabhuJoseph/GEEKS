package arrays;

public class MedianOfTwoSortedArrays {

  public static int getMedian(int[] a, int[] b) {
    int median = ((a.length + b.length) / 2);
    int start = 0;
    int prev = -1;
    int cur = -1;
    int i = 0;
    int j = 0;
    while (start <= median) {
      int low;
      if (a[i] <= b[j]) {
        low = a[i];
        i++;
      } else {
        low = b[j];
        j++;
      }
      System.out.println("LOW="+low);
      if (prev == -1) {
        prev = low;
        cur = low;
      } else {
        prev = cur;
        cur = low;
      }
      start++;
    }

    if ((a.length + b.length) % 2 == 0) {
      return (prev + cur) / 2;
    } else {
      return cur;
    }
  }


  public static void main(String[] args) {
    int[] a = {1,3,8,9,15,17};
    int[] b = {7,11,18,19,21,25};
    System.out.println("MEDIAN of two sorted array: " + getMedian(a,b));
  }
}
