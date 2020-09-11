package linkedlist;

public class ReverseList {

  static class Node {
    int val;
    Node next;

    public Node(int val) {
      this.val = val;
      this.next = null;
    }

    public void setNext(Node n) {
      this.next = n;
    }
  }

  public static Node reverse(Node root) {
    Node cur = root;
    Node prev = null;
    Node next = null;

    while (cur != null) {
      next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

  public static void main(String[] args) {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    one.setNext(two);
    two.setNext(three);
    three.setNext(four);
    four.setNext(null);

    Node head = one;
    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }

    System.out.println("REVERSE");
    head = reverse(one);

    while (head != null) {
      System.out.println(head.val);
      head = head.next;
    }

  }
}
