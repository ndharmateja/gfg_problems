package amazon.linkedlists;

import java.util.Scanner;

public class Utils {
    public static Node reverse(Node h) {
        Node prev = null;
        Node curr = h;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void print(Node h) {
        Node curr = h;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    /**
     * Inputs list from the scanner in form of
     * 8
     * 10 4 9 1 3 5 9 4
     * 
     * where first line contains size
     * and the second line the list of elements
     * 
     * @param s
     * @return the head of the created list
     */
    public static Node inputList(Scanner s) {
        int size = s.nextInt();

        Node head, tail;
        int val;

        val = s.nextInt();
        head = tail = new Node(val);

        size--;
        while (size-- > 0) {
            val = s.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }

        return head;
    }

}
