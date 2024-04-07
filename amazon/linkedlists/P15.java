package amazon.linkedlists;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

@SuppressWarnings("unused")
public class P15 {
    // Ref: https://www.geeksforgeeks.org/problems/remove-loop-in-linked-list/1
    // Editorial in the above link
    // solution:
    private static void solution2(Node head) {
        // using two pointers and moving one pointer(slow) by one node and
        // another pointer(fast) by two nodes in each iteration.
        Node fast = head.next;
        Node slow = head;

        while (fast != slow) {
            // if the node pointed by first pointer(fast) or the node
            // next to it is null, then loop is not present so we return 0.
            if (fast == null || fast.next == null)
                return;

            fast = fast.next.next;
            slow = slow.next;
        }
        // both pointers now point to the same node in the loop.

        int size = 1;
        fast = fast.next;
        // we start iterating the loop with first pointer and continue till
        // both pointers point to same node again.
        while (fast != slow) {
            fast = fast.next;
            // incrementing the counter which stores length of loop..
            size += 1;
        }

        // updating the pointers again to starting node.
        slow = head;
        fast = head;

        // moving pointer (fast) by (size-1) nodes.
        for (int i = 0; i < size - 1; i++)
            fast = fast.next;

        // now we keep iterating with both pointers till fast reaches a node such
        // that the next node is pointed by slow. At this situation slow is at
        // the node where loop starts and first at last node so we simply
        // update the link part of first.
        while (fast.next != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        // storing null in link part of the last node.
        fast.next = null;
    }

    private static void solution1(Node h) {
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

    public static void removeLoop(Node h) {
        solution1(h);
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

        removeLoop(h);
        LLUtils.print(h);
    }
}
