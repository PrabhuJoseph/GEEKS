package recursion;

public class PrintPattern {
  private static void printPattern(int x) {
    for (int i=0; i<x; i++) {
      System.out.print("* ");
    }
    System.out.println();
    if (x-1 > 0)
    printPattern(x-1);
  }

  public static void main(String[] args) {
    printPattern(5);
  }
}
