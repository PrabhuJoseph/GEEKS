package trees;

import java.util.LinkedList;
import java.util.TreeMap;


public class AllViewsOfBinaryTreeThroughRecursion {

    static class Pair {
      int key;
      int level;
      Pair(int key, int level) {
        this.key = key;
        this.level = level;
      }
    }

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


    static void printRightView(Node root, int level, TreeMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(level, root.key);
        printRightView(root.left, level+1, map);
        printRightView(root.right, level+1, map);
    }

    // or

    static void printRightView1(Node root, int level, TreeMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(level, root.key);
        printRightView1(root.right, level+1, map);
        printRightView1(root.left, level+1, map);
    }

    static void printLeftView(Node root, int level, TreeMap<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.putIfAbsent(level, root.key);
        printLeftView(root.left, level+1, map);
        printLeftView(root.right, level+1, map);
    }


    static void printBottomView(Node root, int distance, int level, TreeMap<Integer, Pair> map) {
        if (root == null) {
            return;
        }
        if (map.get(distance) == null || map.get(distance).level <= level) {
          map.put(distance, new Pair(root.key, level));
        }
        printBottomView(root.left, distance-1, level+1, map);
        printBottomView(root.right, distance+1, level+1, map);
    }

    static void printTopView(Node root, int distance, int level, TreeMap<Integer, Pair> map) {
        if (root == null) {
            return;
        }
        if (map.get(distance) == null || map.get(distance).level > level) {
            map.put(distance, new Pair(root.key, level));
        }
        printTopView(root.left, distance-1,level+1, map);
        printTopView(root.right, distance+1,level+1, map);
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

    private static void printMap(TreeMap<Integer, Integer> map) {
        for (int x : map.values()) {
            System.out.print(x + "\t");
        }
    }

    private static void printMapPairs(TreeMap<Integer, Pair> map) {
        for (Pair p : map.values()) {
            System.out.print(p.key + "\t");
        }
    }

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

        TreeMap<Integer, Pair> map = new TreeMap<>();
        System.out.println("\n TOP VIEW");
        printTopView(root, 0, 1, map);
        printMapPairs(map);

        map = new TreeMap<>();
        System.out.println("\n BOTTOM VIEW");
        printBottomView(root, 0,1, map);
        printMapPairs(map);

        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        System.out.println("\n RIGHT VIEW");
        printRightView(root, 1, map1);
        printMap(map1);

        System.out.println("\n LEFT VIEW");
        map1 = new TreeMap<>();
        printLeftView(root, 1, map1);
        printMap(map1);
    }


}
