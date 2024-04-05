package amazon.linkedlists;

public class P31 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node reverse(Node h) {
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

    public Node compute(Node head) {
        // Reverse the list as we can't traverse from right to left
        head = reverse(head);

        // Iterate and delete the elements that are not max so far
        int max = Integer.MIN_VALUE;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            int data = curr.data;
            if (data >= max) {
                // don't delete the node and update max
                max = data;
                prev = curr;
                curr = curr.next;
            } else {
                // delete the node
                // prev stays the same
                prev.next = curr.next;
                curr = curr.next;
            }
        }

        // Reverse the list to get the original order
        return reverse(head);
    }
}
