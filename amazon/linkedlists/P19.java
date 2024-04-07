package amazon.linkedlists;

import java.util.ArrayList;

public class P19 {
    private static class Node {
        int data;
        Node npx;

        Node(int x) {
            data = x;
            npx = null;
        }
    }

    // function should insert the data to the front of the list
    public static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        newNode.npx = head;
        return newNode;
    }

    // function to print the linked list
    public static ArrayList<Integer> printList(Node head) {
        ArrayList<Integer> list = new ArrayList<>();
        Node curr = head;
        while (curr != null) {
            list.add(curr.data);
            curr = curr.npx;
        }
        return list;
    }
}
