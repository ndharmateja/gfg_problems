package amazon.linkedlists;

import amazon.linkedlists.utils.Node;

public class P3 {
    public Node sortedInsert(Node head, int key) {
        Node newNode = new Node(key);
        // If list is empty
        if (head == null) {
            return newNode;
        }

        // If key is less than or equal to the head
        if (key <= head.data) {
            newNode.next = head;
            return newNode;
        }

        Node prev = null;
        Node curr = head;
        // If curr is null => we have to insert the key at the end
        while (curr != null && curr.data < key) {
            prev = curr;
            curr = curr.next;
        }

        // At this point, curr is the first node that is greater than or equal to key
        // so the new node should be inserted before this
        prev.next = newNode;
        newNode.next = curr;

        return head;
    }
}
