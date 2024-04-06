package amazon.linkedlists;

import amazon.linkedlists.utils.Node;
import amazon.linkedlists.utils.LLUtils;

public class P37 {
    /**
     * Splits the list into 2 parts and returns the head of the second half
     * For odd lengthed lists, the first half will be larger than the second half
     * 
     * @param h
     * @return
     */
    private Node splitList(Node h) {
        Node prev = null;
        Node slow = h;
        Node fast = h;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // If list is even lengthed, fast will become null
        // and slow will be at the start of second half
        // We can break between prev and slow and return slow
        if (fast == null) {
            prev.next = null;
            return slow;
        }

        // If list is odd lengthed, fast.next will be null
        // and slow will be in the middle
        // We want the second list to be smaller than the first one
        // so we break the list after slow
        Node toReturn = slow.next;
        slow.next = null;
        return toReturn;
    }

    public void reorderlist(Node head) {
        // Split the list and reverse the second half
        Node head2 = splitList(head);
        head2 = LLUtils.reverse(head2);

        // Alternate adding nodes from first and second lists
        // Creating a dummy node is okay because the testing will be done
        // from the head node
        Node curr = new Node(-1);
        int i = 0;
        Node curr1 = head;
        Node curr2 = head2;

        // It is || and not &&
        // as in even lists when curr1 becomes null
        // there will still be one node left in list2 which needs to be processed
        // This won't throw error
        // As when we are dealing with the last element in an even list
        // curr1 will be null and curr2 won't be null but i will be odd
        // so it will go into else statement
        while (curr1 != null || curr2 != null) {
            if (i++ % 2 == 0) {
                Node next = curr1.next;
                curr1.next = null;
                curr.next = curr1;
                curr = curr.next;
                curr1 = next;
            } else {
                Node next = curr2.next;
                curr2.next = null;
                curr.next = curr2;
                curr = curr.next;
                curr2 = next;
            }
        }
    }
}
