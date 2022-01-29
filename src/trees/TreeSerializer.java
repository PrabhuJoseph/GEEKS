package trees;

import java.util.ArrayList;
import java.util.LinkedList;


public class TreeSerializer {

  // Node Structure within Tree
  static class Node {
    Node left;
    Node right;
    int data;

    public Node(int data, Node left, Node right) {
      this.data = data;
      this.left = left;
      this.right = right;
    }
  }

  public ArrayList<Integer> serialize(Node root) {
    ArrayList<Integer> treeElements = new ArrayList<>();
    LinkedList<Node> queue = new LinkedList<>();
    queue.add(root);
    while(queue.size() > 0) {
      Node node = queue.poll();
      if (node != null) {
        treeElements.add(node.data);
        queue.add(node.left);
        queue.add(node.right);
      } else {
        treeElements.add(-1);
      }
    }
    return treeElements;
  }

  public Node deserialize(ArrayList<Integer> treeElements) {
    if (treeElements != null && treeElements.size() > 0 && treeElements.get(0)!=-1) {
      int i=0;
      Node root = new Node(treeElements.get(i++), null, null);
      LinkedList<Node> queue = new LinkedList<>();
      queue.add(root);
      while (queue.size() > 0) {
        Node cur = queue.poll();
        if (cur != null) {
          Node left = null;
          int leftVal = treeElements.get(i++);
          if (leftVal != -1) {
            left = new Node(leftVal, null, null);
          }
          cur.left = left;
          queue.add(left);

          Node right = null;
          int rightVal = treeElements.get(i++);
          if (rightVal != -1) {
            right = new Node(rightVal, null, null);
          }
          cur.right = right;
          queue.add(right);
        }
      }
      return root;
    } else {
      return null;
    }
  }

  public static void main(String[] args) {
    /* INPUT TREE
                1
            2        3
        4      5  -1   -1
     -1 -1  -1 -1
    */

    Node five = new Node(5, null, null);
    Node four = new Node(4, null, null);
    Node three = new Node(3, null, null);
    Node two = new Node(2, four, five);
    Node root = new Node(1, two, three);

    TreeSerializer serializer = new TreeSerializer();
    ArrayList<Integer> treeElements = serializer.serialize(root);
    System.out.println("AFTER SERIALIZE");
    for (int x : treeElements) {
      System.out.println(x);
    }
    Node newRoot = serializer.deserialize(treeElements);
    ArrayList<Integer> newtreeElements = serializer.serialize(newRoot);
    System.out.println("AFTER DESERIALIZE");
    for (int x : newtreeElements) {
      System.out.println(x);
    }

  }

}
