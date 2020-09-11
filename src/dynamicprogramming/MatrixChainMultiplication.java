package dynamicprogramming;

class MatrixChainMultiplication
{
    // https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/

    // https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/MatrixMultiplicationCost.java

    // APPROAXH 1: Place Parenetheses at different places

    /*

    A = 2*3  1
    B = 3*6  2
    C = 6*4  3
    D = 4*5  4

    */



    private static int MatrixChainMultiplication(int[] dims, int i, int j) {
      if (i==j) {
        return 0;
      }
      int minCost = Integer.MAX_VALUE;
      for (int k=i; k<j; k++) {
        int cost = MatrixChainMultiplication(dims, i, k) + MatrixChainMultiplication(dims, k+1, j) + dims[i-1] * dims[k] * dims[j];
          minCost = Math.min(cost, minCost);
      }
      return minCost;
    }



    /*

LEVEL=2
I=0 J=2
I=0 K=1 J=2

I=1 J=3
I=1 K=2 J=3

I=2 J=4
I=2 K=3 J=4

LEVEL=3
I=0 J=3
I=0 K=1 J=3
I=0 K=2 J=3
I=1 J=4
I=1 K=2 J=4
I=1 K=3 J=4

LEVEL=4
I=0 J=4
I=0 K=1 J=4
I=0 K=2 J=4
I=0 K=3 J=4


     */

    public static int findCost(int[] arr) {
      int[][] temp = new int[arr.length][arr.length];
      int q = 0;
      for (int l=2; l<arr.length; l++) {
        for (int i=0; i<arr.length-l; i++) {
          int j = i+l;
          temp[i][j] = Integer.MAX_VALUE;
          for (int k=i+1; k<j;k++) {
            q = temp[i][k] + temp[k][j] + arr[i] * arr[k] * arr[j];
            if (q < temp[i][j]) {
              temp[i][j] = q;
            }
          }
        }
      }
      return temp[0][arr.length-1];
    }


    // main function
    public static void main(String[] args)
    {
        // Matrix M[i] has dimension dims[i-1] x dims[i] for i = 1..n
        // input is 10 × 30 matrix, 30 × 5 matrix, 5 × 60 matrix
        int[] dims = { 2, 3, 6, 4, 5 };

        System.out.println("Minimum Cost using Top Down (Recursion): " + MatrixChainMultiplication(dims, 1, dims.length-1));

        System.out.println("Minimum cost using Bottom Up: " + findCost(dims));
    }
}
