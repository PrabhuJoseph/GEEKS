package permutation;


/*
  2 pow n subsets

 */
public class SubSets {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        printSubArray(arr, new int[arr.length], 0, 0);
    }

    private static void printSubArray(int[] newarr) {
        for (int i=0; i<newarr.length; i++) {
          if (newarr[i] != -1) {
              System.out.print(newarr[i] + "\t");
          }
        }
        System.out.println();
    }

    private static void printSubArray(int[] arr, int[] newarr,
        int j, int k) {
      if (k==arr.length) {
        printSubArray(newarr);
        return;
      }
      newarr[k] = -1;
      printSubArray(arr, newarr, j+1, k+1);
      newarr[k] = arr[j];
      printSubArray(arr, newarr, j+1, k+1);
    }
}
