package trees;

import java.util.LinkedList;

public class BinarySearchTreeDeletion {

    // https://www.geeksforgeeks.org/binary-search-tree-set-2-delete/

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

    Node search(Node root, int data) {
      if (root == null || root.data == data) {
        return root;
      }
      if (root.data > data) {
        search(root.left, data);
      } else {
        search(root.right, data);
      }
      return root;
    }

    Node findMin(Node node) {
      while (node != null && node.left !=null) {
        node = node.left;
      }
      return node;
    }


    public Node deleteKey(Node node, int data) {
        if (node == null) {
            return node;
        }
        if (node.data < data) {
            node.right = deleteKey(node.right, data);
        } else if (node.data > data) {
            node.left = deleteKey(node.left, data);
        }
        if (node.left == null) {
            return node.right;
        } else if (node.right == null) {
            return node.left;
        }
        Node toReplace = findMin(node.right);
        System.out.println("SEARCH="+toReplace.data);
        node.data = toReplace.data;
        deleteKey(node.right, toReplace.data);
        return node;
    }


    public void traverse(Node root) {
      LinkedList<Node> queue = new LinkedList<>();
      queue.add(root);
      while (queue.size() > 0) {
        Node cur = queue.poll();
        System.out.println(cur.data);
        if (cur.left != null) {
          queue.add(cur.left);
        }
        if (cur.right != null) {
          queue.add(cur.right);
        }
      }
    }

    public static void main(String[] args) {
        BinarySearchTreeDeletion tree = new BinarySearchTreeDeletion();

        /*
        INPUT TREE:

            4
	     2     6
	   1   3  5  7
         */
        Node root = null;
        root = tree.insert(root, 4);
        tree.insert(root, 2);
        tree.insert(root, 1);
        tree.insert(root, 3);
        tree.insert(root, 6);
        tree.insert(root, 5);
        tree.insert(root, 7);
        tree.traverse(root);


        System.out.println("AFTER DELETION");
           /*
        OUTPUT

            5
	     2     6
	   1   3     7
         */


        tree.deleteKey(root,4);
        tree.traverse(root);


    }
}
