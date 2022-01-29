package hackerrank;

// https://www.hackerrank.com/challenges/bomber-man/problem?isFullScreen=true

public class BomberMan {

    private static void printField(int[][] field) {
        for (int i=0; i<field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
      int[][] field = {{-1,-1,-1},{-1,3,-1},{-1,-1,-1}};
      int n = 3;
      // First Second
      for (int i=0; i<field.length; i++) {
        for (int j=0; j< field[0].length; j++) {
          if (field[i][j] != -1) {
           field[i][j]-=1;
          }
        }
      }
      printField(field);
      n--;
      while (n>0) {
          // Second Second => Plant and reduce the second
          for (int i=0; i<field.length; i++) {
              for (int j=0; j< field[0].length; j++) {
                  if (field[i][j] != -1) {
                      field[i][j]-=1;
                  } else {
                      field[i][j]=3;
                  }
              }
          }
          printField(field);
          n--;
        // Third Second => Burst
        if (n>0) {
            for (int i=0; i<field.length; i++) {
                for (int j=0; j< field[0].length; j++) {
                    if (field[i][j]==1) {
                      field[i][j] = -1;
                      if (j-1 >= 0) {
                        field[i][j-1] = -1;
                      }
                      if (j+1 < field[0].length) {
                          field[i][j+1] = -1;
                      }
                      if (i+1 < field.length) {
                          field[i+1][j] = -1;
                      }
                      if (i-1 >= 0) {
                          field[i-1][j] = -1;
                      }
                    }
                }
            }
            // Reduce the second
            for (int i=0; i<field.length; i++) {
                for (int j=0; j< field[0].length; j++) {
                    if (field[i][j] != -1) {
                        field[i][j]-=1;
                    }
                }
            }
        }
        printField(field);
        n--;
      }
    }

}
