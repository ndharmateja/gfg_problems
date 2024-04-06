package flipkart.linkedlists;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P7 {
    public Node mergeResult(Node head1, Node head2) {
        // The new list
        Node dummy = new Node(-1);

        // Iterate simultaneously
        // and attach the smaller node at the start of the new list in each iteration
        // because we want the result in descending order
        Node curr1 = head1;
        Node curr2 = head2;
        while (curr1 != null && curr2 != null) {
            if (curr1.data < curr2.data) {
                Node next = curr1.next;
                LLUtils.insertAfter(dummy, curr1);
                curr1 = next;
            } else {
                Node next = curr2.next;
                LLUtils.insertAfter(dummy, curr2);
                curr2 = next;
            }
        }

        // Attach the remaining parts of list1 or list2 to the new list
        while (curr1 != null) {
            Node next = curr1.next;
            LLUtils.insertAfter(dummy, curr1);
            curr1 = next;
        }
        while (curr2 != null) {
            Node next = curr2.next;
            LLUtils.insertAfter(dummy, curr2);
            curr2 = next;
        }

        return dummy.next;
    }
}
