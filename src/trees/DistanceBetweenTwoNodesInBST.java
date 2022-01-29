package trees;

import java.util.List;
import java.util.LinkedList;

public class DistanceBetweenTwoNodesInBST
{
    class Node {
        Node left, right;
        int key;
    }

    // Creates a new node
    private Node getNewNode(int key) {
        Node node = new Node();
        node.key = key;
        node.left = null;
        node.right = null;
        return node;
    }

    // Inserts a new node in the tree at right position satisfying BST
    private Node insert(Node node, int key) {
        if (node == null) {
            node = getNewNode(key);
        } else if (node.key > key) {
            node.left = insert(node.left, key);
        } else if (node.key <= key) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    // Finds a given data in a tree
    private Node search(Node node, int data) {
        if (node == null || node.key == data) {
            return node;
        }
        if (data < node.key) {
            return search(node.left, data);
        }
        return search(node.right, data);
    }


    // Finds distance between two nodes in a BST tree
    private int findDistance(Node node, int a, int b) {
        if (node == null) {
            return -1;
        }
        if (node.key > a && node.key > b) {
            return findDistance(node.left, a, b);
        }
        if (node.key < a && node.key < b) {
            return findDistance(node.right, a, b);
        }
        if (node.key >= a && node.key <= b) {
            return getDistanceFromNode(node, a) + getDistanceFromNode(node, b);
        }
        return -1;
    }

    // Finds distance between a given node and a key
    private int getDistanceFromNode(Node node, int x) {
        if (node.key == x) {
            return 0;
        } else if (node.key > x) {
            return 1 + getDistanceFromNode(node.left, x);
        }
        return 1 + getDistanceFromNode(node.right, x);
    }


    // Wrapper for finding distance between two nodes in a BST tree
    public int bstDistance(int num, List<Integer>values,
                           int node1, int node2) {
        Node root = null;
        for (int X : values) {
            root = insert(root, X);
        }
        if (search(root, node1) == null || search(root, node2) == null) {
            return -1;
        }

        // Make sure node1 is smaller than node2
        if (node1 > node2) {
          int temp = node2;
          node2 = node1;
          node1 = temp;
        }

        int distance = findDistance(root, node1, node2);

        return distance;

    }

    public static void main(String[] args) {

        List<Integer> nodes = new LinkedList<>();
        nodes.add(9);
        nodes.add(7);
        nodes.add(5);
        nodes.add(3);
        nodes.add(1);

        DistanceBetweenTwoNodesInBST bst = new DistanceBetweenTwoNodesInBST();
        System.out.println(bst.bstDistance(5, nodes, 9, 7));

    }



}