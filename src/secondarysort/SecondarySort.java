package secondarysort;

import java.util.*;
import java.util.concurrent.ConcurrentSkipListSet;

public class SecondarySort {
  static class Node {
    String hostName;
    int score;
    public Node(String hostName, int score) {
      this.hostName = hostName;
      this.score = score;
    }
  }

  static Comparator<Node> comparator = new Comparator<Node>() {
    @Override
    public int compare(Node o1, Node o2) {
        float score1 = o1.score;
        float score2 = o2.score;
        float allocatedDiff = score2 - score1;
        if (allocatedDiff == 0) {
          return o1.hostName.compareTo(o2.hostName);
        }
        return allocatedDiff > 0 ? 1 : -1;
      }
  };

  /*
  static Comparator<Node> comparator = new Comparator<Node>() {
    @Override
    public int compare(Node o1, Node o2) {
      boolean isWorker1 = o1.hostName.startsWith("worker");
      boolean isWorker2 = o2.hostName.startsWith("worker");
      if (!isWorker1 && isWorker2) {
        return 1;
      } else if (isWorker1 && !isWorker2) {
        return -1;
      } else {
        float score1 = o1.score;
        float score2 = o2.score;
        float allocatedDiff = score2 - score1;
        if (allocatedDiff == 0) {
          return o1.hostName.compareTo(o2.hostName);
        }
        return allocatedDiff > 0 ? 1 : -1;
      }
    }
  };
  */

  public static void main(String[] args) {
    Node A = new Node("workerA", 20);
    Node B = new Node("computeA", 50);
    Node C = new Node("computeB", 10);
    Node D = new Node("workerB", 10);
    Node E = new Node("workerD", 30);
    Node F = new Node("computeC", 5);
    Node G = new Node("workerC", 20);

    List<Node> nodes = new LinkedList<>();
    nodes.add(A);
    nodes.add(B);
    nodes.add(C);
    nodes.add(D);
    nodes.add(E);
    nodes.add(F);
    nodes.add(G);

    List<Node> workerNodes = new ArrayList<>();
    List<Node> computeNodes = new ArrayList<>();

    System.out.println("EXISTING NODE ORDER");
    for (Node node : nodes) {
      System.out.println(node.hostName);
      if (node.hostName.startsWith("worker")) {
        workerNodes.add(node);
      } else {
        computeNodes.add(node);
      }
    }
    Set<Node> workerNodeList = new ConcurrentSkipListSet<Node>(comparator);
    workerNodeList.addAll(workerNodes);
    Set<Node> computeNodeList = new ConcurrentSkipListSet<Node>(comparator);
    computeNodeList.addAll(computeNodes);

    Set<Node> nodeListforAM = new LinkedHashSet<>();

    nodeListforAM.addAll(workerNodeList);
    nodeListforAM.addAll(computeNodeList);

    Set<Node> nodeListforTask = new LinkedHashSet<Node>();

    nodeListforTask.addAll(computeNodeList);
    nodeListforTask.addAll(workerNodeList);

    System.out.println("SORTED NODE ORDER FOR AM");
    for (Node node : nodeListforAM) {
      System.out.println(node.hostName);
    }

    System.out.println("SORTED NODE ORDER FOR TASK");
    for (Node node : nodeListforTask) {
      System.out.println(node.hostName);
    }
  }
}
