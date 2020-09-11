package bitwise;

// https://www.geeksforgeeks.org/maximize-the-expression-bit-manipulation/?ref=leftbar-rightbar

public class MaximizeExpression {

  // B AND D = D and maximize A XOR D
  public static int maximize(int A, int B) {
    int D = 1;
    int max = Integer.MIN_VALUE;
    while (D <= B) {
      if ((B & D) == D) {
        max = Math.max(max, (A ^ D));
      }
      D++;
    }
    return max;
  }

  // Efficient Approach Using BitWise Operations - refer doc

  public static void main(String[] args) {
    int A = 9;
    int B = 13;
    int AXORD = maximize(A, B);
    System.out.println("MAXIMUM A XOR D: " + AXORD);
  }
}
