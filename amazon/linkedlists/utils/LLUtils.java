package amazon.linkedlists.utils;

import java.util.Scanner;

public class LLUtils {
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

    public static int getSize(Node h) {
        int size = 0;
        Node curr = h;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    public static void joinLists(Node h1, Node h2) {
        Node curr = h1;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = h2;
    }

    /**
     * splits list into 2 halves
     * and returns the head of the second half
     * 
     * @param h
     * @return
     */
    public static Node splitList(Node h) {
        Node prev = null;
        Node slow = h;
        Node fast = h;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Break the list into 2 halves
        prev.next = null;

        // Return head of second half
        return slow;
    }

    public static Node merge(Node h1, Node h2) {
        // The new list
        Node dummy = new Node(-1);
        Node curr = dummy;

        // Iterate simultaneously
        // and attach the smaller node to the new list in each iteration
        Node curr1 = h1;
        Node curr2 = h2;
        while (curr1 != null && curr2 != null) {
            if (curr1.data < curr2.data) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }

        // Attach the remaining parts of list1 or list2 to the new list
        if (curr1 != null) {
            curr.next = curr1;
        }
        if (curr2 != null) {
            curr.next = curr2;
        }

        return dummy.next;
    }

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node head2 = splitList(head);
        head = mergeSort(head);
        head2 = mergeSort(head2);

        return LLUtils.merge(head, head2);
    }
}
