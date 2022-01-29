package trees;

import java.util.LinkedHashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;

//https://www.geeksforgeeks.org/find-the-maximum-absolute-difference-of-level-sum-in-binary-tree/

public class MaxAbsDifferenceBetweenLevel {

  private static class Node {
    int data;
    Node left;
    Node right;

    private Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  private static int getMaxAbsDiffLevel(Node root) {
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    Map<Integer, Integer> levelSum = new LinkedHashMap<>();
    int level = -1;
    while (queue.size() > 0) {
      int sum = 0;
      int n = queue.size();
      for (int i=0; i<n; i++) {
        Node cur = queue.poll();
        if (cur.left != null) {
          queue.offer(cur.left);
        }
        if (cur.right != null) {
          queue.offer(cur.right);
        }
        sum = sum + cur.data;
      }
      levelSum.put(++level, sum);
    }

    int maxSum = Integer.MIN_VALUE;
    for (Map.Entry<Integer, Integer> entry1 : levelSum.entrySet()) {
      for (Map.Entry<Integer, Integer> entry2 : levelSum.entrySet()) {
        if (entry1.getKey() != entry2.getKey()) {
          int absDiff = Math.abs(entry1.getValue() - entry2.getValue());
          maxSum = Math.max(maxSum, absDiff);
        }
      }
    }
    return maxSum;
  }

  public static void main(String[] args) {

    /* INPUT 1
    Node negone = new Node(-1, null, null);
    Node three = new Node(3, null, null);
    Node negtwo = new Node(-2, null, null);
    Node six = new Node(6, null, null);
    Node two = new Node(2, negone, three);
    Node negfive = new Node(-5, negtwo, six);
    Node root = new Node(4, two, negfive);
    */

    // INPUT 2
    Node four = new Node(4, null, null);
    Node five = new Node(5, null, null);
    Node six = new Node(6, null, null);
    Node seven = new Node(7, null, null);
    Node eight = new Node(8, six, seven);
    Node two = new Node(2, four, five);
    Node three = new Node(3, null, eight);
    Node root = new Node(1, two, three);

    System.out.println("TREE MAX ABS DIFFERENCE BETWEEN LEVEL: " + getMaxAbsDiffLevel(root));

  }

}

