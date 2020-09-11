package algorithms;

public class GoldMineProblem {
  // https://www.youtube.com/watch?v=GLoPeJRAtXU

  private static int mineMaxGold(int[][] mat) {
    int[][] temp = new int[mat.length][mat[0].length];

    for (int i=0; i<mat.length; i++) {
      temp[i][0] = mat[i][0];
    }

    int max;
    for (int i=1; i<mat[0].length; i++) {
      for (int j=0; j<mat.length; j++) {
        max = temp[j][i-1];
        if (j>0) {
          max = Math.max(max, temp[j-1][i-1]);
        }
        if (j<mat.length-1) {
          max = Math.max(max, temp[j+1][i-1]);
        }
        temp[j][i] = mat[j][i] + max;
      }
    }
    max = Integer.MIN_VALUE;
    for (int i=0; i<mat.length; i++) {
      System.out.println(temp[i][mat[0].length-1]);
      max = Math.max(temp[i][mat[0].length-1], max);
    }
    return max;
  }

  public static void main(String[] args) {
    int[][] mat = new int[][] {{1,3,3}, {2,1,4}, {0,6,4}};
    System.out.println("MAX GOLD MINED: " + mineMaxGold(mat));
  }
}
