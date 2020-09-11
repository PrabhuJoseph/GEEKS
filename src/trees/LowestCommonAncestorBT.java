package trees;

public class LowestCommonAncestorBT {
    // https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/?ref=lbp


    // Youtube Tushar - https://www.youtube.com/watch?v=13m9ZCB8gjw

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

        // Binary Tree - nodes are not sorted

        public static Node findLCABT(Node root, int n1, int n2) {
          if (root == null) {
            return null;
          }

          if (root.data == n1 || root.data == n2) {
            return root;
          }

          Node left_lca = findLCABT(root.left, n1, n2);
          Node right_lca = findLCABT(root.right, n1, n2);

          if (left_lca != null && right_lca != null) {
            return root;
          }


          if (left_lca == null && right_lca == null) {
            return null;
          }

          return left_lca != null ? left_lca : right_lca;
        }

        public static void main(String[] args) {
            Node ten = new Node(10, null, null);
            Node fourteen = new Node(14, null, null);
            Node four = new Node(4, null, null);
            Node twelve = new Node(12, ten, fourteen);
            Node eight = new Node(8, four, twelve);
            Node twentytwo = new Node(22, null, null);
            Node root = new Node(20, eight, twentytwo);

            Node lca = findLCABT(root, 10, 22);
            System.out.println("LCA= "+ lca.data);
        }

    }
