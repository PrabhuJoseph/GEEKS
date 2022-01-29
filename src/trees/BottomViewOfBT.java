package trees;

import java.util.*;

public class BottomViewOfBT {
  static class Node {
    int data;
    Node left;
    Node right;
    int level;
    public Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }



  public static void printBottomView(Node root) {
    LinkedList<Node> queue = new LinkedList<>();
    TreeMap<Integer, Integer> views = new TreeMap<>();
    queue.add(root);
    root.level = 0;
    views.put(root.level, root.data);
    while (queue.size() > 0) {
      Node cur = queue.poll();
      if (cur.left != null) {
        queue.add(cur.left);
        cur.left.level = cur.level-1;
        views.put(cur.left.level, cur.left.data);
      }
      if (cur.right != null) {
        queue.add(cur.right);
        cur.right.level = cur.level+1;
        views.put(cur.right.level, cur.right.data);
      }
    }
    for (Map.Entry<Integer, Integer> entry : views.entrySet()) {
      System.out.println(entry.getKey() + "," + entry.getValue());
    }
  }


  public static void main(String[] args) {
    Node ten = new Node(10, null, null);
    Node fourteen = new Node(14, null, null);
    Node three = new Node(3, ten, fourteen);
    Node five = new Node(5, null, null);
    Node twentyfive = new Node(25, null, null);
    Node eight = new Node(8, five, three);
    Node twentytwo = new Node(22, null, twentyfive);
    Node twenty = new Node(20, eight, twentytwo);
    printBottomView(twenty);
  }

}
