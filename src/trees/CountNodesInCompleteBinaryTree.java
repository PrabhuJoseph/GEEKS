package trees;

// https://www.geeksforgeeks.org/count-number-of-nodes-in-a-complete-binary-tree/

public class CountNodesInCompleteBinaryTree {

  static class Node {
    int data;
    Node left;
    Node right;
  };

  public static Node newNode(int data) {
    Node node = new Node();
    node.data = data;
    return node;
  }

  /*

         1
     2      3
   4   5   9  8
 6  7

  */

  public static void main(String[] args) {
    Node root = newNode(1);
    root.left = newNode(2);
    root.right = newNode(3);
    root.left.left = newNode(4);
    root.left.right = newNode(5);
    root.right.left = newNode(9);
    root.right.right = newNode(8);
   // root.left.left.left = newNode(6);
   // root.left.left.right = newNode(7);

    System.out.print(getTotalNodes(root));
  }

  private static double getTotalNodes(Node root) {
    Node temp = root; int lH = 0;
    while (temp != null) {
     lH++;
     temp = temp.left;
    }
    temp = root; int rH = 0;
    while (temp != null) {
      rH++;
      temp = temp.right;
    }
    if (lH == rH) {
      return Math.pow(2, lH) - 1;
    }
    return 1 + getTotalNodes(root.left) + getTotalNodes(root.right);
  }
}
