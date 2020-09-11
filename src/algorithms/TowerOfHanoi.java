package algorithms;

public class TowerOfHanoi {

  public static void move(int n, Character A, Character C, Character B) {
    if (n==1) {
      System.out.println("Move 1 disk from " + A + " to " + C);
      return;
    }
    move(n-1, A, B, C);
    System.out.println("Move " + (n-1) + " disk from " + A + " to " + C);
    move(n-1, B, C, A);
  }

  public static void main(String[] args) {
    move(2, 'A', 'C', 'B');
  }
}