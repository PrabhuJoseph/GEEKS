package trees.deeper;

/**
 * Date 03/24/2016
 * @author Tushar Roy
 *
 * Populate next pointer for each node of binary tree.
 *
 * Time complexity O(n)
 * Space complexity O(1)
 *
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */


public class ConnectNodesAtSameLevel {

    static class Node {
      int data;
      Node left;
      Node right;
      Node next;
    }


    public void connect(Node root) {
        if (root == null) {
            return;
        }

        Node firstNode = root;
        Node prevNode = null;
        while (firstNode != null) {
            root = firstNode;
            firstNode = null;
            prevNode = null;
            while (root != null) {
                if (root.left != null) {
                    if (firstNode == null) {
                        firstNode = root.left;
                    }
                    if (prevNode != null) {
                        prevNode.next = root.left;
                    }
                    prevNode = root.left;
                }
                if (root.right != null) {
                    if (firstNode == null) {
                        firstNode = root.right;
                    }
                    if (prevNode != null) {
                        prevNode.next = root.right;
                    }
                    prevNode = root.right;
                }
                root = root.next;
            }
        }
    }


}