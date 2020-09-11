package linkedlist;

public class ListAlternative {

  class Node {
    Node next;
    int val;

    public Node(int val) {
      this.val = val;
      this.next = null;
    }
  }

  public Node addNode(int val) {
    Node node = new Node(val);
    return node;
  }

  public static void traverse(Node head) {
    while (head != null) {
        System.out.println(head.val);
        head = head.next;
    }
  }

  public static void main(String[] args) {
    ListAlternative alt = new ListAlternative();
    Node one = alt.addNode(1);
    Node two = alt.addNode(2);
    Node three = alt.addNode(3);
    Node four = alt.addNode(4);
    Node five = alt.addNode(5);
    Node six = alt.addNode(6);
    one.next = two;
    two.next = three;
    three.next = four;
    four.next = five;
    five.next = six;
    six.next = null;

    Node listA = alt.addNode(one.val);
    Node listB = alt.addNode(two.val);

    Node tempA = listA;
    Node tempB = listB;

    Node cur = two;
    while (cur.next != null) {
      tempA.next = alt.addNode(cur.next.val);
      tempA = tempA.next;
      cur = cur.next;
      if (cur.next != null) {
          tempB.next = alt.addNode(cur.next.val);
          tempB = tempB.next;
          cur = cur.next;
      }
    }
    tempA.next = null;
    tempB.next = null;

    System.out.println("PRINTING LISTA");
    traverse(listA);

    System.out.println("PRINTING LISTB");
    traverse(listB);

  }
}
