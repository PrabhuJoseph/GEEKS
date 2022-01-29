package practise;

public class Practiser {
  public static void main(String[] args) {
    int[] arr = {1,2,3,4};
    printSubArray(arr, new int[arr.length], 0, 0);
  }

  private static void printSubArray(int[] newarr, int k) {
    for (int i=0; i<k; i++) {
      System.out.print(newarr[i] + "\t");
    }
    System.out.println();
  }

  private static void printSubArray(int[] arr, int[] newarr, int j, int k) {
    for (int i=j; i<arr.length; i++) {
      newarr[k] = arr[i];
      printSubArray(newarr, k+1);
      printSubArray(arr, newarr, i+1, k+1);
    }
  }
}
