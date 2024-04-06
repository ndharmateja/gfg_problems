package microsoft.linkedlists;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P11 {
    // O(n) time and O(1) space complexities
    public static Node partition(Node h, int x) {
        // Init dummy nodes and join them
        Node dummyLess = new Node(-1);
        Node dummyEqual = new Node(-1);
        Node dummyMore = new Node(-1);
        dummyLess.next = dummyEqual;
        dummyEqual.next = dummyMore;

        // Init 3 pointers for <. =, >
        Node currLess = dummyLess;
        Node currEqual = dummyEqual;
        Node currMore = dummyMore;

        // Iterate through each node and place that node
        // in one of the 3 partitions
        Node curr = h;
        while (curr != null) {
            Node next = curr.next;
            curr.next = null;
            if (curr.data < x) {
                currLess = LLUtils.insertAfter(currLess, curr);
            } else if (curr.data > x) {
                currMore = LLUtils.insertAfter(currMore, curr);
            } else {
                currEqual = LLUtils.insertAfter(currEqual, curr);
            }

            curr = next;
        }

        // At this point, the list looks like
        // dummyLess -> (< 3) -> dummyEqual -> (= 3) -> dummyMore -> (> 3)
        // currLess is node before dummyEqual
        // currEqual is node before dummyMore

        // Delete dummyMore
        // and then dummyEqual (in this order, to also handle edge cases of empty
        // partitions)
        currEqual.next = dummyMore.next;
        currLess.next = dummyEqual.next;

        return dummyLess.next;
    }
}
