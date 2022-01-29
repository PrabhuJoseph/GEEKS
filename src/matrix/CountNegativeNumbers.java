package matrix;

// https://www.youtube.com/watch?v=5dJSZLmDsxk&list=PLBZBJbE_rGRVnpitdvpdY9952IsKMDuev&index=7
public class CountNegativeNumbers {
  public static void main(String[] args) {
    int[][] matrix = {{-3,-2,-1, 1},
                      {-2, -2, 3, 4},
                      {-1,  -1, 7, 8}};
    int rows = matrix.length;
    int cols = matrix[0].length;
    int i=0, j=cols-1;
    int count = 0;
    while (i<rows && j>=0) {
      if (matrix[i][j] < 0) {
        System.out.println(i + "--" + j);
        count += (j + 1);
        i++;
      } else {
        j--;
      }
    }
    System.out.println(count);
  }
}
