package graphtheory;

import java.util.*;
import static java.lang.Math.*;

public class Machines {

    static class Node {
    boolean hasMachine;
    int weightOfParent;
    ArrayList<Integer> child = new ArrayList<Integer>();
    ArrayList<Integer> weight = new ArrayList<Integer>();
  }

  static Node[] nodes;
  static int N;

  // https://www.hackerrank.com/challenges/matrix/problem?h_r=internal-search

  public static void main(String[] args) {
    Node zero = new Node();
    zero.child.add(1);
    zero.weight.add(5);

    Node one = new Node();
    one.child.add(2);
    one.weight.add(8);
    one.child.add(0);
    one.weight.add(5);
    one.child.add(3);
    one.weight.add(4);

    Node two = new Node();
    two.child.add(1);
    two.weight.add(8);
    two.child.add(4);
    two.weight.add(5);

    Node three = new Node();
    three.child.add(1);
    three.weight.add(4);

    Node four = new Node();
    four.child.add(2);
    four.weight.add(5);

    N = 5;
    nodes = new Node[N];
    nodes[0] = zero;
    nodes[1] = one;
    nodes[2] = two;
    nodes[3] = three;
    nodes[4] = four;

    System.out.println(doit(0, -1)[0]);

  }

  static long[] doit(int current, int parent) {
            long[] res = new long[2];
            Node curr = nodes[current];
            if (current != 0 && nodes[current].child.size() == 1) {
                // leaf
                if (curr.hasMachine)
                    res[0] = nodes[current].weight.get(0);
                return res;
            }
            int childNum = curr.child.size()-1;
            if (current == 0)
                childNum++;
            long[][] child = new long[childNum][];
            int index = 0;
            for (int i = 0; i < curr.child.size(); i++) {
                int childId = curr.child.get(i);
                if (parent != childId) {
                    nodes[childId].weightOfParent = curr.weight.get(i);
                    child[index++] = doit(childId, current);
                }
            }
            if (curr.hasMachine) {
                for (int i = 0; i < childNum; i++) {
                    res[1] += child[i][0];
                }
                res[0] = res[1] + curr.weightOfParent;
            } else {
                long maxDiff = 0;
                for (int i = 0; i < childNum; i++)
                    maxDiff = max(maxDiff, child[i][0]-child[i][1]);
                long cost = 0;
                for (int i = 0; i < childNum; i++)
                    cost += child[i][0];
                res[0] = min(cost, cost-maxDiff+curr.weightOfParent);
                res[1] = cost-maxDiff;
            }
            return res;
        }
    }
