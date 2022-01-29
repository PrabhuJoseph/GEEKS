package arrays.deeper;


// Reference: https://github.com/mission-peace/interview/blob/master/src/com/interview/binarysearch/MedianOfTwoSortedArrayOfDifferentLength.java
// https://www.youtube.com/watch?v=LPFhl65R7ww

public class MedianOfTwoSortedArraysOfDifferentLength {

  public static double getMedian(int[] a, int[] b) {

    if (a.length > b.length) {
        return getMedian(b, a);
    }

    int start = 0;
    int end = a.length;

    int leftXMax, leftYMax, rightXMin, rightYMin;

    while (start <= end) {
      int partitionX = (start + end) / 2;
      int partitionY = ((a.length + b.length + 1)/ 2) - partitionX;

      leftXMax = (partitionX == 0) ? Integer.MIN_VALUE : a[partitionX - 1];
      rightXMin = (partitionX == a.length) ? Integer.MAX_VALUE : a[partitionX];

      leftYMax = (partitionY == 0) ? Integer.MIN_VALUE : b[partitionY - 1];
      rightYMin = (partitionY == b.length) ? Integer.MAX_VALUE : b[partitionY];


      if (leftXMax <= rightYMin && leftYMax <= rightXMin) {
        if ((a.length + b.length) % 2 == 0) {
          return (Math.max(leftXMax, leftYMax) + Math.min(rightXMin, rightYMin)) / 2;
        } else {
          return Math.max(leftXMax, leftYMax);
        }
      } else if (leftXMax > rightYMin) {
        end = partitionX - 1;
      } else {
        start = partitionX + 1;
      }
    }
    throw new IllegalArgumentException();
  }

  public static void main(String[] args) {
    int[] a = {1,3,8,9};
    int[] b = {7,11,15, 17,18,19,21,25};
    System.out.println("MEDIAN of two sorted array: " + getMedian(a,b));
  }
}
