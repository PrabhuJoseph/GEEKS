package trees;

import java.util.LinkedList;
import java.util.Vector;

public class SinkEvenNodes {

    // https://www.geeksforgeeks.org/sink-even-nodes-in-binary-tree/

    /* TREE

       10
	 5     8
   29 2  1  98
 20           50

     */

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

    static void sinkEvenNodes(Node root) {
      LinkedList<Node> queue = new LinkedList<>();
      queue.add(root);
      while (queue.size() > 0) {
        Node node = queue.poll();
        if (node.data % 2 == 0) {
          int pickChild = -1;
          if (node.left !=null && node.left.data % 2 != 0) {
            pickChild = node.left.data;
            node.left.data = node.data;
          } else if (node.right != null && node.right.data % 2 != 0) {
            pickChild = node.right.data;
            node.right.data = node.data;
          }
          if (pickChild != -1) {
            System.out.println(pickChild);
          } else {
            System.out.println(node.data);
          }
        }
        if (node.left !=null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
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
        sinkEvenNodes(root);

    }
}
