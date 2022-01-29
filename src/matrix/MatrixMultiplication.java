package matrix;

public class MatrixMultiplication {


  /*

   A    B
  1 2  1 1
  3 4  1 1


         A*B
1*1 + 2*1   1*1 + 2*1
3*1 + 4*1   3*1 + 4*1


   */

  public static void main(String[] args) {
    int[][] A = new int[][] {{1,2}, {3,4}};
    int[][] B = new int[][] {{1,1}, {1,1}};

    int N = 2;

    int[][] C = new int[N][N];

    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        C[i][j] = 0;
        for (int k=0; k<N; k++) {
          C[i][j] += (A[i][k] * B[k][j]);
        }
      }
    }


    System.out.println("MULTIPLIED OUTPUT MATRIX");
    for (int i=0; i<N; i++) {
      for (int j=0; j<N; j++) {
        System.out.print(C[i][j]+" ");
      }
      System.out.println();
    }

  }
}
