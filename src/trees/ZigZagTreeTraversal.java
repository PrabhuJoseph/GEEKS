package trees;

import java.util.Stack;
import java.util.LinkedList;

public class ZigZagTreeTraversal {

        class Node {
            int data;
            Node left;
            Node right;

            public Node(int d) {
                data = d;
                left = right = null;
            }
        }

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


    // Use Stack, Won't work with Queue
    public void zigZagTraversal(Node cur) {
        Stack<Node> curLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        curLevel.push(cur);
        boolean toggle = true;
        while (curLevel.size() > 0) {
            Node node = curLevel.pop();
            System.out.println(node.data);
            if (toggle) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }
            if (curLevel.size() == 0) {
                toggle = !toggle;
                curLevel = nextLevel;
                nextLevel = new Stack<>();
            }
        }
    }


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

        public static void main(String[] args) {
            ZigZagTreeTraversal tree = new ZigZagTreeTraversal();
            Node root = null;
            root = tree.insert(root, 4);
            tree.insert(root, 2);
            tree.insert(root, 1);
            tree.insert(root, 3);
            tree.insert(root, 6);
            tree.insert(root, 5);
            tree.insert(root, 7);

            tree.zigZagTraversal(root);
        }

    }


