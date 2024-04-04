package amazon.linkedlists;

public class P11 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node insertAfter(Node node, Node toInsert) {
        toInsert.next = node.next;
        node.next = toInsert;
        return toInsert;
    }

    void rearrangeEvenOdd(Node head) {
        Node dummy0 = new Node(-1);
        Node dummy1 = new Node(-1);
        Node curr0 = dummy0;
        Node curr1 = dummy1;

        // connect dummy0 and dummy1
        dummy0.next = dummy1;

        Node curr = head;
        int i = 0;
        while (curr != null) {
            Node next = curr.next;
            if (i++ % 2 == 0) {
                curr0 = insertAfter(curr0, curr);
            } else {
                curr1 = insertAfter(curr1, curr);
            }
            curr = next;
        }

        // At this point the list looks like
        // dummy0 -> (even index elements) -> dummy1 -> (odd index elements)
        // curr0 is node before dummy1

        // Delete dummy1 (node after curr0)
        curr0.next = dummy1.next;
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
        Node h = new Node(1);
        h.next = new Node(2);
        h.next.next = new Node(3);
        h.next.next.next = new Node(4);

        print(h);
        new P11().rearrangeEvenOdd(h);
        print(h);
    }
}
