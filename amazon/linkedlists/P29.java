package amazon.linkedlists;

import utils.linkedlists.Node;

public class P29 {
    // We will delete this node
    // by continuously copying the data of the next
    // node into the curr node and then delete the last node
    public void deleteNode(Node node) {
        Node curr = node;
        while (curr.next.next != null) {
            curr.data = curr.next.data;
            curr = curr.next;
        }

        // At this point, curr will have only one node after it
        // we can copy it's data and delete that node
        curr.data = curr.next.data;
        curr.next = null;
    }
}
