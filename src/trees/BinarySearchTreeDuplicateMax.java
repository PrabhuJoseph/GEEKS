package trees;

public class BinarySearchTreeDuplicateMax {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node insert(Node root, int data) {
      if (root == null) {
        return new Node(data);
      }
      if (root.data > data) {
        root.left = insert(root.left, data);
      } else {
        root.right = insert(root.right, data);
      }
      return root;
    }

    static Node curNode = null;
    static int max;
    static int curCount = 0;

    // Inorder - sorted
    public static int findMaxDuplicates(Node root) {
        if (root == null) {
            return max;
        }
        findMaxDuplicates(root.left);

        if (curNode == null) {
            curNode = root;
            curCount++;
        } else {
            if (curNode.data == root.data) {
                curCount++;
            } else {
                curNode = root;
                curCount = 1;
            }
        }
        if (max < curCount) {
            max = curCount;
        }
        findMaxDuplicates(root.right);
        return max;
    }

    public static void main(String[] args) {
        BinarySearchTreeDuplicateMax tree = new BinarySearchTreeDuplicateMax();
        Node root = null;
        root = tree.insert(root, 7);
        tree.insert(root, 2);
        tree.insert(root, 1);
        tree.insert(root, 3);
        tree.insert(root, 7);
        tree.insert(root, 7);
        tree.insert(root, 7);
        int max = findMaxDuplicates(root);
        System.out.println("MAX DUPLICATES=" + max);
    }
}
