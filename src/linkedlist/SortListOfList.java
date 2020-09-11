package linkedlist;

/**
 5 -> 10 -> 19 -> 28
 |    |     |     |
 V    V     V     V
 7    20    22    35
 |          |     |
 V          V     V
 8          50    40
 |                |
 V                V
 30               45

 next possibilities: 20, 22, 28, 30

 min heap or tree = minimum

 5 -> 7(7, 10)

 5 - 7 - 8 - 10 - 19






 Flatten linked list

 Output : 5->7->8->10->19->20->22->28->30->35->40->45->50

 Tree <elements sorted>


 0(nlogn)

 **/

import java.util.LinkedList;
import java.util.TreeMap;

public class SortListOfList {

    static class Node {
        int element;
        Node next;
        Node down;
        public Node(int element, Node next, Node down) {
            this.element = element;
            this.next = next;
            this.down = down;
        }
    }


    public static LinkedList<Integer> SortListOfList(Node root) {
        LinkedList<Integer> sorted = new LinkedList<>();
        TreeMap<Integer, LinkedList<Node>> possibilities = new TreeMap<>();
        if (root == null) {
            return sorted;
        }
        sorted.add(root.element);
        if (root.next != null) {
            LinkedList<Node> node = new LinkedList<>();
            node.add(root.next);
            possibilities.put(root.next.element, node);
        }
        if (root.down != null) {
            LinkedList<Node> node = new LinkedList<>();
            node.add(root.down);
            possibilities.put(root.down.element, node);
        }
        while (possibilities.size() > 0) {
            int key = possibilities.firstKey();
            LinkedList<Node> min = possibilities.get(key);
            for (Node minNum : min)
                sorted.add(minNum.element);
            if (min.size() > 0) {
                possibilities.remove(key);
                for (Node node : min) {
                    if (node.next != null && node.down!=null && node.next.element == node.down.element) {
                        LinkedList<Node> newNode = new LinkedList<>();
                        newNode.add(node.next);
                        newNode.add(node.down);
                        possibilities.put(node.next.element, newNode);
                    } else {
                        if (node.next != null) {
                            LinkedList<Node> newNode = new LinkedList<>();
                            newNode.add(node.next);
                            possibilities.put(node.next.element, newNode);
                        }
                        if (node.down != null) {
                            LinkedList<Node> newNode = new LinkedList<>();
                            newNode.add(node.down);
                            possibilities.put(node.down.element, newNode);
                        }
                    }
                }
            }
        }
        return sorted;
    }

    public static void main(String[] args) {

        Node twentytwo = new Node(21, null, null);
        Node twentyone = new Node(21, null, twentytwo);
        Node thirty = new Node(30, null, null);
        Node twentyoneone = new Node(21, thirty, null);
        Node twenty = new Node(20, twentyoneone, twentyone);
        Node ten = new Node(10, twenty, null);
        Node seven = new Node(7, null, null);
        Node six = new Node(6, null, seven);

        Node root = new Node(5, ten, six);

    /*

    5 -> 10 -> 20 -> 21 -> 30 -> NULL

    6          21

    7          21

    */


        LinkedList<Integer> sorted = SortListOfList(root);
        for (int num : sorted) {
            System.out.println(num + "->");
        }





    }

}



