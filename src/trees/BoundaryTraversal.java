package trees;

public class BoundaryTraversal {
  // https://www.geeksforgeeks.org/boundary-traversal-of-binary-tree/

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node insert(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (data < node.data) {
            node.left = insert(node.left, data);
        } else {
            node.right = insert(node.right, data);
        }
        return node;
    }

    private static void printLeftBoundary(Node node) {
      if (node == null) {
        return;
      }
      if (node.left != null) {
        System.out.println(node.data);
        printLeftBoundary(node.left);
      }
      else if (node.right != null) {
        System.out.println(node.data);
        printLeftBoundary(node.right);
      }
    }

    private static void printRightBoundary(Node node) {
      if (node == null) {
        return;
      }
      if (node.right != null) {
        printRightBoundary(node.right);
        System.out.println(node.data);
      }
      else if (node.left != null) {
        printRightBoundary(node.left);
        System.out.println(node.data);
      }
    }

    private static void printLeaves(Node node) {
      if (node == null) {
        return;
      }
      printLeaves(node.left);
      if (node.left==null && node.right==null) {
        System.out.println(node.data);
      }
      printLeaves(node.right);
    }

    private static void boundaryTraversal(Node root) {
      if (root == null) {
          return;
      }
      System.out.println(root.data);
      printLeftBoundary(root.left);
      printLeaves(root.left);
      printLeaves(root.right);
      printRightBoundary(root.right);
    }

    public static void main(String[] args) {
        BoundaryTraversal tree = new BoundaryTraversal();
        Node root = null;
        root = tree.insert(root, 4);
        tree.insert(root, 2);
        tree.insert(root, 1);
        tree.insert(root, 3);
        tree.insert(root, 6);
        tree.insert(root, 5);
        tree.insert(root, 7);

        tree.boundaryTraversal(root);
    }
}
