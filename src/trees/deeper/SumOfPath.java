package trees.deeper;

// https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
public class SumOfPath {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            data = d;
            left = right = null;
        }
    }

    Node root = null;

    boolean hasPathSum(Node node, int sum) {
      boolean ans = false;
      int subSum = sum - node.data;
      System.out.println(node.data + "<--->" + subSum);
      if (subSum == 0 && node.left==null & node.right==null) {
        return (ans = true);
      }
      if (node.left != null) {
        ans = ans || hasPathSum(node.left, subSum);
      }
      if (node.right != null) {
        ans = ans || hasPathSum(node.right, subSum);
      }
      return ans;
    }



    int hasAnyPathSum(Node node, int sum) {
      if (node == null) {
        return 0;
      }
      int res = 0;
      System.out.println("SUM: " + sum + "<--->" + node.data);
      if (sum == node.data) {
        res++;
      }
      res += hasAnyPathSum(node.left, sum - node.data);
      res += hasAnyPathSum(node.right, sum - node.data);
      return res;
    }

    // Path Sum - https://github.com/KnowledgeCenterYoutube/LeetCode/blob/master/437_Path_Sum_iii
    // https://www.youtube.com/watch?v=Vam9gldRapY
    int pathSum(Node node, int sum) {
      if (node == null) return 0;
      return pathSum(node.left, sum) + pathSum(node.right, sum) + hasAnyPathSum(node, sum);
    }


    /*

         10
       8    2
     3  5  2


     */

    public static void main(String[] args) {
        SumOfPath tree = new SumOfPath();
        tree.root = new Node(10);
        tree.root.left = new Node(8);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(9);

      //  System.out.println(tree.hasPathSum(tree.root, 14));
        System.out.println(tree.pathSum(tree.root, 21));
    }

}
