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

    // https://www.geeksforgeeks.org/matrix-chain-multiplication-dp-8/

    */



    // TIME: Expononential 2 power (m+n)
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
      for (int level=2; level<arr.length; level++) {
        for (int i=0; i<arr.length-level; i++) {
          int j = i+level;
          temp[i][j] = Integer.MAX_VALUE;
          for (int k=i+1; k<j;k++) {
            q = temp[i][k] + temp[k][j] + arr[i] * arr[k] * arr[j];
            if (q < temp[i][j]) {
              temp[i][j] = q;
            }
          }
          System.out.println(i + "---" + j + "---" + temp[i][j]);
        }
      }

      for (int i=0; i<arr.length; i++) {
        for (int j=0; j<arr.length; j++) {
          System.out.print(temp[i][j] + "\t");
        }
        System.out.println();
      }

      return temp[0][arr.length-1];
    }




    // Time: O(n3) Space: O(n2)

    /*


         0    1     2     3
    0    0   36    84    124

    1        0     72    132

    2               0    120

    3                    0



Level 1
    0 => 0 to 1
             => (0 to 0) * (1 to 1)
    1 => 1 to 2
             => (1 to 1) * (2 to 2)
    2 => 2 to 3
             => (2 to 2) * (3 * 3)

Level 2
    0 => 0 to 2
             => (0 to 0) * (1 to 2)
             => (0 to 1) * (2 to 2)
    1 => 1 to 3
             => (1 to 1) * (2 to 3)
             => (1 to 2) * (3 to 3)

Level 3
    0 => 0 to 3
             => (0 to 0) * (1 to 3)
             => (0 to 1) * (2 to 3)
             => (0 to 2) * (3 to 3)


     Three types:

     i to i+k and i+K+1 to i+level

     if i and i+k are same
     i+k and i+level are same
     else
     i to i+k is one range and i+k+1 to i+level is another range



     */

    public static int findCostMine(int[][] matrices) {
      int[][] temp = new int[matrices.length][matrices.length];
      for (int level=1; level<matrices.length; level++) {
        for (int i=0; i<matrices.length-level; i++) {
          int min = Integer.MAX_VALUE;
          for (int k=0; k<=level-1; k++) {
            int part;
            if (i==i+k) {
              part = matrices[i][0] * matrices[i][1] * matrices[i+level][1] + temp[i+k+1][i+level];
            } else if (i+k == i+level) {
              part = matrices[i][0] * matrices[i+k][1] * matrices[i+level][1] + temp[i][i+k];
            } else {
              // Two ranges are there
              part = temp[i][i+k] + temp[i+k+1][i+level] + matrices[i][0] * matrices[i+k][1] * matrices[i+level][1];
            }
            min = Math.min(min, part);
          }
          temp[i][i+level] = min;
        }
      }


      for (int i=0; i<temp.length; i++) {
        for (int j=0; j<temp.length; j++) {
          System.out.print(temp[i][j] + "\t");
        }
        System.out.println();
      }

      return temp[0][matrices.length-1];
    }



    // main function
    public static void main(String[] args)
    {
        // Matrix M[i] has dimension dims[i-1] x dims[i] for i = 1..n
        // input is 10 × 30 matrix, 30 × 5 matrix, 5 × 60 matrix
        int[] dims = { 2, 3, 6, 4, 5 };

        System.out.println("Minimum Cost using Top Down (Recursion): " + MatrixChainMultiplication(dims, 1, dims.length-1));

        System.out.println("Minimum Cost using Bottom Up: " + findCost(dims));


        int[][] matrices = {{2,3}, {3,6}, {6,4}, {4,5}};
        System.out.println("Minimum cost using Bottom Up - My Version: " + findCostMine(matrices));
    }
}
