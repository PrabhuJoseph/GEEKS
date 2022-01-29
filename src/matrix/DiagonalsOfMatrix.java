package matrix;

public class DiagonalsOfMatrix {

  private static void printDiagonals(int[][] matrix) {
    System.out.println("Principal Diagonal");
    for (int i=0; i<matrix.length; i++) {
      System.out.println(matrix[i][i]);
    }
    System.out.println("Secondary Diagonal");
    for (int i=0; i<matrix.length; i++) {
      System.out.println(matrix[i][matrix.length-1-i]);
    }
  }

  public static void main(String[] args) {
    int[][] matrix = new int[4][4];
    matrix[0] = new int[] {1,2,3,4};
    matrix[1] = new int[] {4,3,2,1};
    matrix[2] = new int[] {7,8,9,6};
    matrix[3] = new int[] {6,5,4,3};
    printDiagonals(matrix);
  }
}
