package amazon.linkedlists;

public class P6 {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    // Swaps the next two nodes after curr (and sets the connections)
    // and returns the next next node to curr after the swap is done
    // If there aren't two nodes after curr, returns null
    private Node swapTwoNodes(Node curr) {
        if (curr.next == null || curr.next.next == null)
            return null;

        Node next = curr.next;
        curr.next = next.next;
        next.next = curr.next.next;
        curr.next.next = next;

        return next;
    }

    public Node pairwiseSwap(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node curr = dummy;
        while (curr != null) {
            curr = swapTwoNodes(curr);
        }

        return dummy.next;
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

        print(h);
        h = new P6().pairwiseSwap(h);
        print(h);
    }
}
