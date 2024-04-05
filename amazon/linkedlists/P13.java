package amazon.linkedlists;

public class P13 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static boolean detectLoop(Node head) {
        Node slow = head;
        Node fast = head;

        // If there is no cycle
        // fast or fast.next will become null first
        // so we don't need to check for slow becoming null
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // We don't check this at the start of the loop
            // because slow and fast will be same initially
            // and we want to find the next time they are same
            if (slow == fast)
                return true;
        }

        // fast or fast.next has become null
        // so it means that we have reached the end of the list
        return false;
    }
}
