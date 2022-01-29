package matrix;

// https://www.geeksforgeeks.org/submatrix-sum-queries/

public class SumOfMatrixWithPreprocess {

  public static void preProcess(int[][] matrix, int M, int N, int[][] cache) {
    for (int i=0; i<N; i++) {
      cache[0][i] = matrix[0][i];
    }
    // Column Wise Sum - Leave First Row
    for (int i=1; i<M; i++) {
      for (int j=0; j<N; j++) {
        cache[i][j] = cache[i-1][j] + matrix[i][j];
      }
    }

    System.out.println("COLUMN WISE SUM MATRIX");
    for (int i=0; i<M; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(cache[i][j] + "\t");
      }
      System.out.println();
    }

    // Row Wise Sum - Leave First Column
    for (int i=0; i<M; i++) {
      for (int j=1; j<N; j++) {
        cache[i][j] = cache[i][j] + cache[i][j-1];
      }
    }

    System.out.println("ROW WISE SUM MATRIX");
    for (int i=0; i<M; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(cache[i][j] + "\t");
      }
      System.out.println();
    }

  }

  public static int querySum(int cache[][], int X1, int Y1, int X2, int Y2) {
    int sum = cache[X2][Y2];

    if (Y1 > 0) {
      sum -= cache[X2][Y1-1];
    }

    if (X1 > 0) {
      sum -= cache[X1-1][Y2];
    }

    if (X1>0 && Y1>0) {
      sum += cache[X1-1][Y1-1];
    }
    return sum;
  }

  public static void main(String[] args) {
    int M=5;
    int N=5;
    int[][] matrix = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
    int[][] cache = new int[M][N];

    System.out.println("INPUT MATRIX");
    for (int i=0; i<M; i++) {
      for (int j=0; j<N; j++) {
        System.out.print(matrix[i][j]+"\t");
      }
      System.out.println();
    }

    preProcess(matrix, M, N, cache);

    System.out.println("CACHE MATRIX");
    for (int i=0; i<M; i++) {
      for (int j = 0; j < N; j++) {
        System.out.print(cache[i][j] + "\t");
      }
      System.out.println();
    }

    System.out.println("QUERY MATRIX: " + querySum(cache, 1, 1, 4, 4));
  }
}
