package amazon.linkedlists;

public class P35 {
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int d) {
            data = d;
            next = prev = null;
        }
    }

    // function returns the head of the linkedlist
    Node deleteNode(Node head, int x) {
        if (x == 1) {
            Node newHead = head.next;
            head.next = null;
            newHead.prev = null;
            return newHead;
        }

        Node curr = head;
        for (int i = 0; i < x - 1; i++) {
            curr = curr.next;
        }

        // Delete curr
        curr.prev.next = curr.next;
        if (curr.next != null)
            curr.next.prev = curr.prev;
        curr.prev = null;
        curr.next = null;

        return head;
    }
}
