package amazon.linkedlists;

import amazon.linkedlists.utils.Node;

public class P2 {
    public Node deleteMid(Node head) {
        if (head == null || head.next == null)
            return null;

        Node prev, slow, fast;
        prev = null;
        slow = fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // at this point slow is the middle node
        // and prev is the previous node of slow
        // and we have to delete slow node
        prev.next = slow.next;
        return head;
    }
}
