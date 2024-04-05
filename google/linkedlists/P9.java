package google.linkedlists;

public class P9 {
    static class Node {
        int val;
        Node next;

        Node(int key) {
            this.val = key;
            next = null;
        }
    }

    // Returns the new head after inserting the node
    private static Node insert(Node head, Node toInsert) {
        if (toInsert.val <= head.val) {
            toInsert.next = head;
            return toInsert;
        }

        Node prev = head;
        Node curr = head.next;
        while (curr != null) {
            if (toInsert.val <= curr.val) {
                // Insert it before curr
                prev.next = toInsert;
                toInsert.next = curr;
                return head;
            }
            prev = curr;
            curr = curr.next;
        }

        // We insert it at the end if the toInsert's value is not less than
        // any of the values
        prev.next = toInsert;
        return head;
    }

    public static Node insertionSortList(Node head) {
        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        // We can start from the second node
        // as first node can directly be part of the new list
        Node newHead = head;
        Node curr = head.next;
        newHead.next = null;

        // In each iteration remove the curr node
        // and insert it into the new list
        while (curr != null) {
            // Remove curr from list
            Node next = curr.next;
            curr.next = null;

            // Insert it into the list
            newHead = insert(newHead, curr);

            // Go to next node
            curr = next;
        }

        return newHead;
    }
}
