package matrix;

public class SpiralMatrix {

    public static void traverseSpiral(int[][] matrix, int M, int N) {
        int i=0;
        int j=0;
        int direction = 1;
        int count = 0;
        boolean[][] visibility = new boolean[M][N];
        while (count < (M*N)) {
            System.out.println(i+"---"+j+"---"+matrix[i][j]);
            visibility[i][j] = true;
            if (direction == 1) {
                if (i < M && (j+1)<N && !visibility[i][j+1]) {
                    j++;
                }
                else {
                    direction++;
                    i++;
                }
            } else if (direction == 2) {
                if (j<N && (i+1)<M && !visibility[i+1][j]) {
                    i++;
                }
                else {
                    direction++;
                    j--;
                }
            } else if (direction == 3) {
                if (i >= 0 && (j-1)>=0 && !visibility[i][j-1]) {
                    j--;
                } else {
                    i--;
                    direction++;
                }
            } else if (direction == 4) {
                if (j >= 0 && (i-1)>=0 && !visibility[i-1][j]) {
                    i--;
                } else {
                    j++;
                    direction=1;
                }
            }
            count++;
        }
    }

    public static void main(String[] args) {
       // int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};

        /*

        SPIRAL MATRIX:

        INPUT:
         1  2  3  4
         5  6  7  8
         9 10 11 12
        13 14 15 16

        OUTPUT:

        1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10

         */


        int M = 4;
        int N = 4;
        traverseSpiral(matrix, M, N);
    }
}
