package amazon.linkedlists;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P15 {
    public static void removeLoop1(Node h) {
        // Base case
        if (h.next == h) {
            h.next = null;
            return;
        }

        // Find if there is a loop
        // fastPrev is the node right before fast node
        Node dummy = new Node(-1);
        dummy.next = h;
        Node slow = h;
        Node fastPrev = dummy;
        Node fast = h;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fastPrev = fastPrev.next.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }

        // If no loop, return
        if (fast == null || fast.next == null)
            return;

        // Find the starting point of the loop
        // Ref: https://youtu.be/2Kd0KKmmHFc?t=600
        slow = h;
        while (slow != fast) {
            slow = slow.next;
            fastPrev = fast;
            fast = fast.next;
        }

        // The point where slow and fast become same
        // is the starting point of the loop
        // We can remove the loop by setting fastPrev's next to null
        // as fastPrev will be the last element of the cycleless list
        fastPrev.next = null;
    }

    public static void main(String[] args) {
        // 1 -> 3 -> 4
        // .....↑____↓
        //
        // Expected output: 1 -> 3 -> 4
        Node h = new Node(1);
        h.next = new Node(3);
        h.next.next = new Node(4);
        h.next.next.next = h.next.next;

        removeLoop1(h);
        LLUtils.print(h);
    }
}
