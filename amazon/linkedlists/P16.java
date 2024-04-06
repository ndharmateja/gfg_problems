package amazon.linkedlists;

import utils.linkedlists.Node;

public class P16 {
    public Node sortedMerge(Node head1, Node head2) {
        // The new list
        Node dummy = new Node(-1);
        Node curr = dummy;

        // Iterate simultaneously
        // and attach the smaller node to the new list in each iteration
        Node curr1 = head1;
        Node curr2 = head2;
        while (curr1 != null && curr2 != null) {
            if (curr1.data < curr2.data) {
                curr.next = curr1;
                curr1 = curr1.next;
            } else {
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }

        // Attach the remaining parts of list1 or list2 to the new list
        if (curr1 != null) {
            curr.next = curr1;
        }
        if (curr2 != null) {
            curr.next = curr2;
        }

        return dummy.next;
    }
}
