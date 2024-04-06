package amazon.linkedlists;

import amazon.linkedlists.utils.Node;
import amazon.linkedlists.utils.Utils;

public class P39 {
    private Node insertAfter(Node node, Node toInsert) {
        toInsert.next = node.next;
        node.next = toInsert;
        return toInsert;
    }

    public Node sort(Node head) {
        // first we separate out the alternating sorted lists
        Node dummy0 = new Node(-1);
        Node curr0 = dummy0;
        Node dummy1 = new Node(-1);

        // Iterate over the list and alteratingly insert into
        // list0 and list1
        Node curr = head;
        int i = 0;
        while (curr != null) {
            Node next = curr.next;
            if (i++ % 2 == 0) {
                // Insert at end of list0
                // because even indexes are in ascending order
                curr0 = insertAfter(curr0, curr);
            } else {
                // Insert at start of list1
                // because odd indexes are in descending order
                insertAfter(dummy1, curr);
            }
            curr = next;
        }

        // Merge the two sorted lists
        return Utils.merge(dummy0.next, dummy1.next);
    }
}
