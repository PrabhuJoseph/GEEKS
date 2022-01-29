package trees;

import java.util.LinkedList;
import java.util.TreeMap;

public class AllViewsOfBinaryTree {

    static class Node {
        int key;
        Node left;
        Node right;
        int distance;

        Node(int key, Node left, Node right) {
            this.key = key;
            this.left = left;
            this.right = right;
        }
    }

    static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key, null, null);
        }
        if (key < root.key) {
            root.left = insert(root.left, key);
        } else {
            root.right = insert(root.right, key);
        }
        return root;
    }

    static void traverse(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            Node cur = queue.remove();
            if (cur != null) {
                System.out.print(cur.key + "\t");
            }
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
    }

    static void printRightView(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i=0; i<n; i++) {
                Node cur = queue.remove();
                if (i==n-1) {
                    System.out.print(cur.key + "\t");
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }

    static void printLeftView(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() > 0) {
            int n = queue.size();
            for (int i=0; i<n; i++) {
                Node cur = queue.remove();
                if (i==0) {
                    System.out.print(cur.key + "\t");
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
    }

    static void printTopView(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        root.distance = 0;
        while (queue.size() > 0) {
            Node cur = queue.remove();
            if (cur != null) {
                map.putIfAbsent(cur.distance, cur.key);
            }
            if (cur.left != null) {
                cur.left.distance = cur.distance - 1;
                queue.add(cur.left);
            }
            if (cur.right != null) {
                cur.right.distance = cur.distance + 1;
                queue.add(cur.right);
            }
        }
        for (int x : map.values()) {
            System.out.print(x + "\t");
        }
    }

    static void printBottomView(Node root) {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(root);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        root.distance = 0;
        while (queue.size() > 0) {
            Node cur = queue.remove();
            if (cur != null) {
                map.put(cur.distance, cur.key);
            }
            if (cur.left != null) {
                cur.left.distance = cur.distance - 1;
                queue.add(cur.left);
            }
            if (cur.right != null) {
                cur.right.distance = cur.distance + 1;
                queue.add(cur.right);
            }
        }
        for (int x : map.values()) {
            System.out.print(x + "\t");
        }
    }

  /*
      4
   2     6
 1   3  5  7
   */

  /*

                      20
                    /    \
                  7       22
                /   \    /   \
              5      9 21     25
                    / \
                  8    14

   */

    public static void main(String[] args) {
        Node root = insert(null, 20);
        insert(root, 7);
        insert(root, 22);
        insert(root, 5);
        insert(root, 9);
        insert(root, 8);
        insert(root, 14);
        insert(root, 21);
        insert(root, 25);

        traverse(root);
        System.out.println("\n TOP VIEW");
        printTopView(root);

        System.out.println("\n BOTTOM VIEW");
        printBottomView(root);

        System.out.println("\n RIGHT VIEW");
        printRightView(root);

        System.out.println("\n LEFT VIEW");
        printLeftView(root);
    }


}
