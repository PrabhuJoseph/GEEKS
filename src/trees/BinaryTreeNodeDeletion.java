package trees;

import java.util.LinkedList;

public class BinaryTreeNodeDeletion {

  // https://www.geeksforgeeks.org/deletion-binary-tree/

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


  // Node to be deleted will be replaced with bottom most and right most node
    // and whose parent.right is will be set to Null

  public static void delete(Node root, Node toBeDeleted) {
    Node temp = root;
    Node prev = root;
    while (temp != null && temp.right!=null) {
      prev = temp;
      temp = temp.right;
    }
    toBeDeleted.data = temp.data;
    prev.right = null;
  }


    public static void levelOrderTraversal(Node cur) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(cur);
        while (queue.size() > 0) {
            Node node = queue.poll();
            System.out.println(node.data);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

  public static void main(String[] args) {
    Node four = new Node(4, null, null);
    Node nineteen = new Node(19, null, null);
    Node sixteen = new Node(16, null, null);
    Node nine = new Node(9, null, null);
    Node twelve = new Node(12, four, nineteen);
    Node ten = new Node(10, sixteen, nine);
    Node root = new Node(13, twelve, ten);

    delete(root, twelve);
    levelOrderTraversal(root);

  }

}
