package trees;

import java.util.Deque;
import java.util.LinkedList;

public class IsBST {

  static class Node {
    int data;
    Node left;
    Node right;

    public Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  static class Pair {
    int min;
    int max;

    public Pair(int min, int max) {
      this.min = min;
      this.max = max;
    }
  }

  public static Pair getMinMax(Node node) {
    LinkedList<Node> queue = new LinkedList<>();
    queue.add(node);
    int min = node.data;
    int max = node.data;
    while (queue.size() > 0) {
      Node cur = queue.poll();
      if (cur.data < min) {
        min = cur.data;
      }
      if (cur.data > max) {
        max = cur.data;
      }
      if(cur.left != null) queue.add(cur.left);
      if(cur.right != null) queue.add(cur.right);
    }
    return new Pair(min, max);
  }

  public static boolean isBST(Node node) {
    if (node == null) {
      return true;
    }
    if (node.left!=null && getMinMax(node.left).max > node.data)
      return false;
    if (node.right!=null && getMinMax(node.right).min < node.data)
      return false;
    if(!isBST(node.left) || !isBST(node.right)) {
      return false;
    }
    return true;
  }

  public static boolean isBSTUsingEfficient(Node node, int min, int max) {
    if (node == null) {
       return true;
    }
    if (node.data < min || node.data > max) {
       return false;
    }
    return isBSTUsingEfficient(node.left, min, node.data-1)
            && isBSTUsingEfficient(node.right, node.data+1, max);
  }

  public static void main(String args[]) {
    Node one = new Node(3, null, null);
    Node three = new Node(5, null, null);
    Node five = new Node(4, one, three);
    Node two = new Node(7, null, null);
    Node four = new Node(2, two, five);

    Pair pair = getMinMax(four);

    if (isBST(four))
      System.out.println("IS BST");
    else
      System.out.println("Not a BST");

    if (isBSTUsingEfficient(four, Integer.MIN_VALUE, Integer.MAX_VALUE))
      System.out.println("IS BST");
    else
      System.out.println("Not a BST");

  }
}
