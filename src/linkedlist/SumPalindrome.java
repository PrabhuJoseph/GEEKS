package linkedlist;

public class SumPalindrome {

  private static class Node {
    int data;
    Node next;

    private Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private static boolean isPalindrome(int x) {
    int rem = 0;
    int reverseNum = 0;
    int actual = x;
    while (x > 0) {
      rem = x % 10;
      reverseNum = 10 * reverseNum + rem;
      x = x / 10;
    }
    System.out.println("ACTUAL: " + actual + " REVERSE: " + reverseNum);
    return (actual == reverseNum);
  }

  private static int sumOfPalindrome(Node root) {
    int sum = 0;
    while (root != null) {
      int data = root.data;
      if (isPalindrome(data)) {
        sum = sum + data;
      }
      root = root.next;
    }
    return sum;
  }

  public static void main(String[] args) {
    Node last = new Node(141, null);
    Node second = new Node(2, last);
    Node third = new Node(33, second);
    Node fourth = new Node(166, third);
    Node head = new Node(78, fourth);

    System.out.println("SUM OF PALINDROME: " + sumOfPalindrome(head));
  }
}
