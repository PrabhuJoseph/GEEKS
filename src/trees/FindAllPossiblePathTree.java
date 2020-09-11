package trees;

import java.util.Vector;

public class FindAllPossiblePathTree {

  static class Node {
    int data;
    Node left, right;
  }

  static Node newNode(int data) {
    Node newNode = new Node();
    newNode.data = data;
    newNode.left = newNode.right = null;
    return (newNode);
  }

  static void printAllPossiblePathWithMax(Node root, Vector<Integer> path, int max, int flag) {
    if (root == null) {
      return;
    }
    path.add(root.data);
    if (root.data >= max) {
      flag = 1;
    }
    if (root.left==null && root.right==null && flag==1) {
      for (int data : path) {
        System.out.print(data + " ");
      }
      System.out.println();
    }
    printAllPossiblePathWithMax(root.left, path, max, flag);
    printAllPossiblePathWithMax(root.right, path, max, flag);
    path.remove(new Integer(root.data));
  }

  // Preorder
  static void printAllPossiblePath(Node root, Vector<Integer> path) {
    if (root == null) {
      return;
    }
    path.add(root.data);
    if (root.left==null && root.right==null) {
      for (int data : path) {
        System.out.print(data + " ");
      }
      System.out.println();
    }
    printAllPossiblePath(root.left, path);
    printAllPossiblePath(root.right, path);
    path.remove(new Integer(root.data));
  }
  public static void main(String[] args) {
    Node root = newNode(10);
    root.left = newNode(5);
    root.right = newNode(8);
    root.left.left = newNode(29);
    root.left.right = newNode(2);
    root.right.right = newNode(98);
    root.right.left = newNode(1);
    root.right.right.right = newNode(50);
    root.left.left.left = newNode(20);
    System.out.println("ALL POSSIBLE PATHS");
    printAllPossiblePath(root, new Vector<Integer>());
    System.out.println("ALL POSSIBLE PATHS WITH MAX");
    printAllPossiblePathWithMax(root, new Vector<Integer>(), 90, 0);

  }
}
