package linkedlist;

public class SegregateEvenAndOdd {

  static class Node {
    Node next;
    int data;

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }


  static Node addNode(Node cur, int data) {
    Node node = new Node(data, null);
    cur.next = node;
    return node;
  }


  public static Node segregate(Node head) {
    Node evenRoot = new Node(-1, null);
    Node oddRoot = new Node(-1, null);

    Node temp = head;
    Node evenTemp = evenRoot;
    Node oddTemp = oddRoot;
    while (temp != null) {
      if (temp.data % 2 == 0) {
        evenTemp = addNode(evenTemp, temp.data);
      } else {
        oddTemp = addNode(oddTemp, temp.data);
      }
      temp = temp.next;
    }
    if (evenRoot.next == null) {
      oddTemp.next = null;
      return oddRoot.next;
    } else if (oddRoot.next == null){
      evenTemp.next = null;
      return evenRoot.next;
    } else {
      evenTemp.next = oddRoot.next;
      oddTemp.next = null;
      return evenRoot.next;
    }
  }

  public static void main(String[] args) {
    Node tail = new Node(6,null);
    Node seven = new Node(7, tail);
    Node one = new Node(1,seven);
    Node four = new Node(4, one);
    Node five = new Node(5,four);
    Node ten = new Node(10, five);
    Node twelve = new Node(12,ten);
    Node eight = new Node(8, twelve);
    Node fifteen = new Node(15, eight);
    Node head = new Node(17, fifteen);

    Node root = segregate(head);
    while (root != null) {
      System.out.println("NODE="+root.data);
      root = root.next;
    }

  }

}
