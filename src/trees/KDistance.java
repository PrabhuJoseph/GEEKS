package trees;

import java.util.LinkedList;

public class KDistance {

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

  public static void printKNodes(Node root, int k) {
    if (root == null) {
      return;
    }
    if (k==1) {
      System.out.println("Node="+root.data);
    }
    if (root.left !=null) {
      printKNodes(root.left, k-1);
    }
    if (root.right != null) {
      printKNodes(root.right, k-1);
    }
  }

  public static void printKNodesUsingLevelOrderTraversal(Node root, int k) {
    LinkedList<Node> queue = new LinkedList<>();
    queue.add(root);
    int level = 1;
    while (level < k) {
      LinkedList<Node> nextLevelQueue = new LinkedList<>();
      for (Node cur : queue) {
          if (cur.left != null) {
              nextLevelQueue.add(cur.left);
          }
          if (cur.right != null) {
              nextLevelQueue.add(cur.right);
          }
      }
      queue = nextLevelQueue;
      level++;
    }
    while (queue.size() > 0) {
      Node cur = queue.poll();
      System.out.println("NODE="+cur.data);
    }
  }

  public static void main(String[] args) {
    Node four = new Node(4, null, null);
    Node five = new Node(5, null, null);
    Node eight = new Node(8, null, null);
    Node two = new Node(2, four, five);
    Node three = new Node(3, eight, null);
    Node root = new Node(1, two, three);

    printKNodesUsingLevelOrderTraversal(root, 2);
  }
}
