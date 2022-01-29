package trees;

import java.util.Deque;
import java.util.LinkedList;

public class CountLeavesBinaryTree {

  static class Node {
    Node left;
    Node right;
    int data;

    public Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public static int countLeaves(Node root) {
    int count = 0;
    Deque<Node> deck = new LinkedList<>();
    deck.addLast(root);
    while(deck.size() > 0) {
      Node cur = deck.removeFirst();
      if (cur.left == null && cur.right == null) {
          count++;
      }
      if (cur.left != null) {
        deck.addLast(cur.left);
      }
      if (cur.right != null) {
        deck.addLast(cur.right);
      }
    }
    return count;
  }

  public static void main(String[] args) {
    Node five = new Node(5, null, null);
    Node thirty = new Node(30, null, null);
    Node ten = new Node(10, five, null);
    Node one = new Node(1, ten, thirty);
    System.out.println("NUMBER OF LEAF NODES="+countLeaves(one));
  }

}
