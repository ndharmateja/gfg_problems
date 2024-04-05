package amazon.linkedlists;

public class P14 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static int countNodesinLoop(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                break;
        }

        // If loop doesn't exist
        if (fast == null || fast.next == null)
            return 0;

        // As slow pointer is in the loop
        // move it forward until it reaches the node it is pointing now
        Node ref = slow;
        int size = 0;
        do {
            size++;
            slow = slow.next;
        } while (slow != ref);

        return size;
    }
}
