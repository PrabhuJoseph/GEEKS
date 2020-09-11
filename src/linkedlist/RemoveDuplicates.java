package linkedlist;

class RemoveDuplicates
{

    // Remove Subsequent Duplicates
    static class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }

    static Node removeDuplicates(Node root)
    {
        Node prev = null;
        Node cur = root;
        if (cur != null) {
            prev = cur;
            cur = cur.next;
        } else {
            return cur;
        }

        while (cur != null) {
            if (cur.data == prev.data) {
                prev.next = cur.next;
            } else {
                prev = cur;
            }
            cur = cur.next;
        }
        return root;
    }

    public static void main(String[] args) {
      Node root = new Node(6);
      Node one = new Node(63);
      Node two = new Node(71);
      Node three = new Node(71);
      Node four = new Node(82);
      Node five = new Node(71);
      root.next = one;
      one.next = two;
      two.next = three;
      three.next = four;
      four.next = five;
      five.next = null;

      root = removeDuplicates(root);

      while (root != null) {
          System.out.println(root.data);
          root = root.next;
      }
    }
}