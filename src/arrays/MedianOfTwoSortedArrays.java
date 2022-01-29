package arrays;


// Both Arrays are same length
public class MedianOfTwoSortedArrays {

  public static float getMedian(int[] a, int[] b) {
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
      System.out.println(prev + "---" + cur);
      return (prev + cur) / 2.0f;
    } else {
      return cur;
    }
  }


  public static void main(String[] args) {
    int[] a = {1,2,3,4,5,6,7,8,9,10};
    int[] b = {11,12,13,14};
    System.out.println("MEDIAN of two sorted array: " + getMedian(a,b));
  }
}
