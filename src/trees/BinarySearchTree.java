package trees;

import java.util.LinkedList;

public class BinarySearchTree {


   /*
    Trees (BT, BST, AVL, Trie, BTree, Heap - Priority/Min/Max, Red Black Tree) - Applications

    TreeMap/SortedMap - Red Black Tree (BST + AVL) - Useful for Faster Navigation (next, floor, ceil) and Search

    PriorityQueue - Heap - Useful for getting/traversing elements in min and max or some order

    */


    /*

    TREE TRAVERSAL:

    https://www.geeksforgeeks.org/tree-traversals-inorder-preorder-and-postorder/

    1. DEPTH FIRST -> InOrder, PreOrder, PostOrder

      InOrder -> Left, Root, Right
      PreOrder -> Root, Left, Right
      PostOrder -> Left, Right, Root

    2. BREADTH FIRST -> LEVEL ORDER TRAVELSAL (level by level) using queue.

     */

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    //  BST Insert
    // Time Complexity is O(h) where h is height of the tree
    // Worst case for Data Skewed Tree - it will go O(n)
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

    int minValue(Node node) {
        while (node.left != null) {
            node = node.left;
        }
        return node.data;
    }

    // BST Search
    Node search(Node node, int data) {
        if (node == null || node.data == data) {
            return node;
        }

        if (data < node.data) {
            return search(node.left, data);
        }
        return search(node.right, data);
    }


    // Breadh First traversal
    public void levelOrderTraversal(Node cur) {
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


    /* PRE Order => Root, Left, Right */
    public void depthTraversalPreOrder(Node cur) {
      if (cur == null) {
        return;
      }
      System.out.println(cur.data);
      depthTraversalPreOrder(cur.left);
      depthTraversalPreOrder(cur.right);
    }

    /* IN Order => Left, Root, Right */
    /* SORTED ORDER */
    public void depthTraversalInOrder(Node cur) {
      if (cur == null) {
        return;
      }
      depthTraversalInOrder(cur.left);
      System.out.println(cur.data);
      depthTraversalInOrder(cur.right);
    }


    /* POST Order => Left, Right, Root */
    public void depthTraversalPostOrder(Node cur) {
      if (cur == null) {
        return;
      }
      depthTraversalPostOrder(cur.left);
      depthTraversalPostOrder(cur.right);
      System.out.println(cur.data);
    }


    public static void main(String[] args) {
      BinarySearchTree tree = new BinarySearchTree();
      Node root = null;
      root = tree.insert(root, 4);
      tree.insert(root, 2);
      tree.insert(root, 1);
      tree.insert(root, 3);
      tree.insert(root, 6);
      tree.insert(root, 5);
      tree.insert(root, 7);

      /*

        4
	 2     6
   1  3	 5   7

   Level Order Traversal: 4261357
   Depth First Search: 4213657

       */

      tree.levelOrderTraversal(root);

      tree.depthTraversalPreOrder(root);
    }

}

