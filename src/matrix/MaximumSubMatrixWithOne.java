package matrix;

public class MaximumSubMatrixWithOne {

   private static void printMaxSubSquare(int[][] M) {
     int R = M.length;
     int C = M[0].length;

     System.out.println("INPUT");

     for (int i = 0; i < R; i++) {
       for (int j = 0; j < C; j++) {
         System.out.print(M[i][j] + "\t");
       }
       System.out.println();
     }

     int[][] S = new int[R][C];

     for (int i=0; i<R; i++) {
       S[i][0] = M[i][0];
     }

     for (int i=0; i<C; i++) {
       S[0][i] = M[0][i];
     }

     for (int i=1; i<R; i++) {
       for (int j=1; j<C; j++) {
         if (M[i][j] == 1) {
           S[i][j] = 1 + Math.min(Math.min(S[i][j-1], S[i-1][j]), S[i-1][j-1]);
         } else {
           S[i][j] = 0;
         }
       }
     }

     System.out.println("CACHE");

     for (int i = 0; i < R; i++) {
       for (int j = 0; j < C; j++) {
         System.out.print(S[i][j] + "\t");
       }
       System.out.println();
     }

     int max=-1, max_i=0, max_j=0;
     for (int i=0; i<R; i++) {
       for (int j=0; j<C; j++) {
         if (S[i][j] > max) {
           max = S[i][j];
           max_i = i;
           max_j = j;
         }
       }
     }


     System.out.println("Maximum size sub-matrix is: "+ max_i+ "---"+max_j+"----"+max);

     for (int i=max_i-max+1; i<=max_i; i++) {
       for (int j=max_j-max+1; j<=max_j; j++) {
         System.out.print(M[i][j] + " ");
       }
       System.out.println();
     }

     // OR

     for (int i = max_i; i > max_i - max; i--) {
       for (int j = max_j; j > max_j - max; j--) {
         System.out.print(M[i][j] + " ");
       }
       System.out.println();
     }
   }

    // Driver program
    public static void main(String[] args)
    {
        int[][] M = {{0, 1, 0, 0, 1},
                     {1, 1, 1, 0, 0},
                     {0, 1, 1, 1, 0},
                     {1, 1, 1, 1, 0},
                     {1, 1, 1, 1, 1},
                     {0, 0, 0, 0, 0}};

        printMaxSubSquare(M);
    }

}
