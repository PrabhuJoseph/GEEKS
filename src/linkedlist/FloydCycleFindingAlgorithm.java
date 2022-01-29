package linkedlist;

public class FloydCycleFindingAlgorithm {

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

  public static boolean detectLoop(Node root) {
    Node first = root;
    Node second = root;

    while (first!=null && second != null && second.next!=null) {
      first = first.next;
      second = second.next.next;
      if (first == second) {
        return true;
      }
    }
    return false;
  }


  public static void main(String[] args) {
    Node one = new Node(1);
    Node two = new Node(2);
    Node three = new Node(3);
    Node four = new Node(4);
    one.setNext(two);
    two.setNext(three);
    three.setNext(four);
    four.setNext(one); // LOOP EXISTS
   // four.setNext(null); // LOOP DOES NOT EXIST
    System.out.println("LOOP EXIST="+detectLoop(one));
  }

}
