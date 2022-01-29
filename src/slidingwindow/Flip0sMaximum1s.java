package slidingwindow;


// https://www.geeksforgeeks.org/find-zeroes-to-be-flipped-so-that-number-of-consecutive-1s-is-maximized/

public class Flip0sMaximum1s {


    // Driver method to test the above function
    public static void main(String[] args)
    {
        int m = 2;
        int arr[] = new int[]{1, 0, 0, 1, 1, 0, 1, 0, 1, 1};
        System.out.println("Indexes of zeroes to be flipped are ");
        findZeroes(arr, m);
    }

    private static void findZeroes(int[] arr, int m) {
      int wS=0, wE=0, bestWindowSize=0, bestWindowStart=0;
      int curZeroCount = 0;

      while (wE < arr.length) {
        if (curZeroCount <= m) {
          if (arr[wE] == 0) {
            curZeroCount++;
          }
          wE++;
        }
        if (curZeroCount > m) {
         if (arr[wS] == 0) {
           curZeroCount--;
         }
         wS++;
        }
        if (wE-wS > bestWindowSize && curZeroCount<=m) {
           bestWindowSize = wE-wS;
           bestWindowStart = wS;
        }
      }

      //Print Window
      for (int i=bestWindowStart; i<bestWindowStart+bestWindowSize; i++) {
        System.out.print(arr[i] + "\t");
      }
      System.out.println();

      for (int i=bestWindowStart; i<bestWindowStart+bestWindowSize; i++) {
        if (arr[i] == 0) {
          System.out.print(i + "\t");
        }
      }

    }
}
