package trees;

public class LowestCommonAncestorBST {

   // https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/

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

  // Binary Search Tree - nodes are sorted

  // Time Complexity O(h)

  public static int findLCABST(Node root, int n1, int n2) {
 //   while (root != null) {
      if (n1 < root.data && n2 < root.data) {
        return findLCABST(root.left, n1, n2);
      } else if (n1 > root.data && n2 > root.data) {
        return findLCABST(root.right, n1, n2);
      } else {
        return root.data;
      }
 //   }
   // return -1;
  }

  public static void main(String[] args) {
    Node ten = new Node(10, null, null);
    Node fourteen = new Node(14, null, null);
    Node four = new Node(4, null, null);
    Node twelve = new Node(12, ten, fourteen);
    Node eight = new Node(8, four, twelve);
    Node twentytwo = new Node(22, null, null);
    Node root = new Node(20, eight, twentytwo);

    int lca = findLCABST(root, 10, 14);
    System.out.println("LCA= "+ lca);
  }

}
