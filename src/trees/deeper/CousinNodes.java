package trees.deeper;

// https://www.geeksforgeeks.org/check-two-nodes-cousins-binary-tree/

public class CousinNodes {


  static class Node {
    int data;
    Node left, right;

    Node(int item) {
      data = item;
      left = right = null;
    }
  }

  Node root;


  static int level(Node node, Node a, int level) {
    if (node == null) {
      return 0;
    }
    if (node == a) {
      return level;
    }
    if (node.left != null) {
      return 1 + level(node.left, a, level);
    } else {
      return 1 + level(node.right, a, level);
    }
  }

  static boolean isCousin(Node node, Node a, Node b) {
    System.out.println("Level a: " + level(node, a, 1));
    System.out.println("Level b: " + level(node, b, 1));

    System.out.println("Sibling " +isSibling(node, a, b));

    return level(node, a, 1) == level(node, b, 1) && !isSibling(node, a, b);
  }

  private static boolean isSibling(Node node, Node a, Node b) {
    if (node == null) {
      return false;
    }
    return (node.left == a && node.right==b) || (node.left==a && node.right==b) || isSibling(node.left, a, b) || isSibling(node.right, a, b);
  }

    public static void main(String args[]) {
     CousinNodes tree = new CousinNodes();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);
     tree.root.left.right.right = new Node(15);
     tree.root.right.left = new Node(6);
     tree.root.right.right = new Node(7);
     tree.root.right.left.right = new Node(8);

     /*

           1
      2           3
    4  5       6     7
         15      8

      */

    System.out.println(isCousin(tree.root, tree.root.left.left, tree.root.left.right));

 }
}
