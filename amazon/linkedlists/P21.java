package amazon.linkedlists;

import java.util.HashSet;

@SuppressWarnings("unused")
public class P21 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // O(N + M) time and O(max(N, M)) space complexities
    // Using a hashset
    private int solution1(Node head1, Node head2) {
        HashSet<Node> set1 = new HashSet<>();

        Node curr = head1;
        while (curr != null) {
            set1.add(curr);
            curr = curr.next;
        }

        curr = head2;
        while (curr != null) {
            if (set1.contains(curr))
                return curr.data;
            curr = curr.next;
        }

        return -1;
    }

    private int size(Node h) {
        int size = 0;
        Node curr = h;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        return size;
    }

    // O(N + M) time and O(1) space complexities
    private int solution2(Node head1, Node head2) {
        int size1 = size(head1);
        int size2 = size(head2);

        // If size1 > size2 we will swap the heads
        // so that list 1 will always have the lower size
        if (size1 > size2) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }

        // Move pointer2 diff number of times
        int diff = Math.abs(size2 - size1);
        Node curr2 = head2;
        for (int i = 0; i < diff; i++) {
            curr2 = curr2.next;
        }

        // Move both pointers simultaneously and find the common one
        Node curr1 = head1;
        while (curr1 != null) {
            if (curr1 == curr2)
                return curr1.data;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        // If we reach here => no common node
        return -1;
    }

    public int intersectPoint(Node head1, Node head2) {
        return solution2(head1, head2);
    }

    static void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node common = new Node(15);
        common.next = new Node(30);

        Node h1 = new Node(3);
        h1.next = new Node(6);
        h1.next.next = new Node(9);
        h1.next.next.next = common;

        Node h2 = new Node(10);
        h2.next = common;

        print(h1);
        print(h2);
        System.out.println(new P21().intersectPoint(h1, h2));
    }
}
