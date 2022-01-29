package trees;

import java.util.HashMap;
import java.util.LinkedList;

public class MinSwapToConvertBTtoBST {
    static class Node {
        int data;
        Node left, right;
    }

    static Node newNode(int data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.left = newNode.right = null;
        return (newNode);
    }


    public static int findMinIndex(Integer[] arr, int low, int high) {
        int min_index = low;
        int min = arr[low];

        if (low == high) {
            return min_index;
        }
        for (int i=low+1; i<high; i++) {
            if (arr[i] < min) {
                min = arr[i];
                min_index = i;
            }
        }
        return min_index;
    }

    public static int selectionSort(Integer[] arr) {
        int high = arr.length;
        int countSwap = 0;
        int min_index;
        int temp;
        for (int i=0; i<high; i++) {
            min_index = findMinIndex(arr, i, high);
            if (i != min_index) {
                countSwap++;
                temp = arr[i];
                arr[i] = arr[min_index];
                arr[min_index] = temp;
            }
        }
        return countSwap;
    }

    static int minSwaps(Node root) {
        LinkedList<Integer> nodes = new LinkedList<Integer>();
        depthTraversalInOrder(root, nodes);

        Integer[] nodesArr = new Integer[nodes.size()];
        nodes.toArray(nodesArr);

        for (int x : nodesArr)
            System.out.println(x);

        return selectionSort(nodesArr);
    }

    static void depthTraversalInOrder(Node cur, LinkedList<Integer> list) {
        if (cur == null) {
            return;
        }
        depthTraversalInOrder(cur.left, list);
        list.add(cur.data);
        depthTraversalInOrder(cur.right, list);
    }




    public static void main(String[] args) {
        Node root = newNode(5);
        root.left = newNode(6);
        root.right = newNode(7);
        root.left.left = newNode(8);
        root.left.right = newNode(9);
        root.right.left = newNode(10);
        root.right.right = newNode(11);
        System.out.println("MIN SWAP="+minSwaps(root));
    }

}
