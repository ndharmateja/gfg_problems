package amazon.linkedlist;

@SuppressWarnings("unused")
public class P12 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private int getSize(Node head) {
        int size = 0;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    private Node getKthNodeFromStart(Node head, int k) {
        Node curr = head;
        for (int i = 0; i < k - 1; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private int solution1(Node head, int n) {
        int size = getSize(head);
        if (n > size)
            return -1;

        return getKthNodeFromStart(head, size + 1 - n).data;
    }

    // Have 2 pointers with a diff of n
    // and then move both of them simultaneous until the second one reaches the end
    // and return the data of the first
    private int solution2(Node head, int n) {
        Node first = head;
        Node second = head;

        for (int i = 0; i < n - 1; i++) {
            second = second.next;
            if (second == null) {
                return -1;
            }
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        return first.data;
    }

    public int getNthFromLast(Node head, int n) {
        return solution2(head, n);
    }
}
