package linkedlist;

public class SwapVowels {

  private static class Node {
    Character data;
    Node next;

    private Node(Character data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private static boolean isVowel(Character input) {
    switch (input) {
      case 'a':
      case 'e':
      case 'i':
      case 'o':
      case 'u':
      case 'A':
      case 'E':
      case 'I':
      case 'O':
      case 'U':
          return true;
      default:
          return false;
    }
  }

  private static void swapNodes(Node A, Node B) {
    Character temp = A.data;
    A.data = B.data;
    B.data = temp;
  }

  private static void swapVowels(Node root) {
    Node prev = null, cur = null;
    while (root != null) {
      if (isVowel(root.data)) {
        if (prev == null) {
          prev = root;
        } else {
          cur = root;
          swapNodes(prev, cur);
          prev = null;
        }
      }
      root = root.next;
    }
  }

  private static void traverse(Node head) {
    while (head != null) {
      System.out.print(head.data + "->");
      head = head.next;
    }
    System.out.println("NULL");
  }

  public static void main(String[] args) {
    Node last = new Node('e', null);
    Node second = new Node('d', last);
    Node third = new Node('c', second);
    Node fourth = new Node('b', third);
    Node head = new Node('a', fourth);

    System.out.println("INPUT DATA:");
    traverse(head);
    swapVowels(head);
    System.out.println("OUTPUT DATA:");
    traverse(head);
  }

}
