package amazon.linkedlists;

import utils.linkedlists.Node;

public class P5 {
    public Node rotate(Node head, int k) {
        if (k == 0)
            return head;

        Node curr = head;
        for (int i = 0; i < k - 1; i++) {
            curr = curr.next;
        }

        // at this point, curr is the kth element
        Node kthNode = curr;
        Node kthNextNode = curr.next;

        // If n == k, then k+1 the element will be null
        // and we don't need to rotate
        if (kthNextNode == null)
            return head;

        // Get the last element of the list
        while (curr.next != null) {
            curr = curr.next;
        }
        Node last = curr;

        // rotate
        last.next = head;
        kthNode.next = null;
        return kthNextNode;
    }
}
