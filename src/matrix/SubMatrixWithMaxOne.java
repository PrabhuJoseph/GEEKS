package matrix;

public class SubMatrixWithMaxOne {
  // https://www.geeksforgeeks.org/submatrix-of-given-size-with-maximum-1s/?ref=leftbar-rightbar


  /* ALGORITHM:

  Example1:

1 0 1 1
0 0 1 1
0 1 0 0
0 0 0 0


Convert Given Input Matrix to below sliding window row wise:

2 2
1 2
1 1
0 0

Then Check the max count checking sliding window column wise

4 5
2 3

Or Opposite Direction also works fine

answer = 5



Example2:

1 0 1
1 1 0
1 1 1

=> Sliding Window Row Wise

1 1
2 1
2 2

=> Sliding Window Column Wise

3 2
4 3

answer: max = 4

   */

  private static int getMaxOne(int[][] matrix) {
    int[][] rows = new int[matrix.length][2];
    for (int i=0; i<matrix.length; i++) {
      for (int j = 0; j < 2; j++) {
        for (int k = j, x=0; x < matrix.length-1;x++, k++) {
          rows[i][j] = rows[i][j] + matrix[i][k];
        }
      }
    }

    for (int i=0;i<rows.length; i++) {
      for (int j=0; j<2; j++) {
        System.out.print(rows[i][j]+ " ");
      }
      System.out.println();
    }

    int max = Integer.MIN_VALUE;
    for (int i=0; i<2; i++) {
      for (int j = 0; j < 2; j++) {
        int count = 0;
        for (int k = j, x=0; x<matrix.length-1;x++, k++) {
          count = count + rows[k][i];
        }
        if (count > max) {
          max = count;
        }
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[][] matrix = new int[3][3];
    matrix[0] = new int[] {1,0,1};
    matrix[1] = new int[] {0,0,1};
    matrix[2] = new int[] {1,1,0};
    System.out.println("MAX ONE: " + getMaxOne(matrix));
  }
}
