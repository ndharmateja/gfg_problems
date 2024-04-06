package amazon.linkedlists;

import amazon.linkedlists.utils.Node;

public class P1 {
    public int getMiddle(Node head) {
        Node slow, fast;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
