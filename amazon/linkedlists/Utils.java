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

    public static Node inputList(Scanner sc) {
        int size = sc.nextInt();

        Node head, tail;
        int val;

        val = sc.nextInt();
        head = tail = new Node(val);

        size--;
        while (size-- > 0) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }

        return head;
    }

}
