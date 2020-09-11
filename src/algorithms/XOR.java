package algorithms;

public class XOR {

  public static void main(String[] args) {
      int[] input = new int[] {8, 7, 7, 8, 9};
      int unique = 0;
      for (int x : input) {
          unique ^= x;
      }
      System.out.println("UNIQUE="+unique);
  }
}
