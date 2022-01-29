package arrays;

public class IJK {

  // To do in Efficient way in O(n2) - Use way similar to Maximum Sum Triplets.

  // O(n3)

  public static boolean threeLoop(int[] arr) {
    boolean check = false;
    outer: for (int i=0; i<arr.length; i++) {
      for (int j=i+1; j<arr.length; j++) {
        for (int k=j+1; k<arr.length; k++) {
          if (arr[i] < arr[j] && arr[j] < arr[k]) {
            System.out.println(arr[i] + "---" + arr[j] + "---" + arr[k]);
            check = true;
            break outer;
          }
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] arr = new int[]{2,1,3,4,5};

    boolean check = threeLoop(arr);
  }
}
