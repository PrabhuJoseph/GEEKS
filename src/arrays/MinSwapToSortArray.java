package arrays;

class MinSwapToSortArray {

    // https://www.youtube.com/watch?v=J9ikRMK8Yhs

    // This is only for elements between a range example 1 to 5.

  private int minSwaps(int arr[]) {
    boolean[] visited = new boolean[arr.length];
    int swaps = 0;

    for (int i=0; i<arr.length; i++) {
      if (!visited[i]) {
        visited[i] = true;
        if (arr[i] - 1 == i) {
          continue;
        } else {
          int j = arr[i] - 1;
          while (!visited[j]) {
            visited[j] = true;
            j = arr[j] - 1;
            swaps++;
          }
        }
      }
    }
    return swaps;
  }

  public static void main(String[] args) {
    int []a = {1, 5, 4, 3, 2};
    MinSwapToSortArray g = new MinSwapToSortArray();
    System.out.println(g.minSwaps(a));
  }
}


