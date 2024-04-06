package amazon.linkedlists;

import utils.linkedlists.Node;

public class P36 {
    /**
     * Sorted insert into a circular linked list
     * 
     * @param head
     * @param data
     * @return
     */
    public Node sortedInsert(Node head, int data) {
        // Create new node
        Node newNode = new Node(data);

        // Base case
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // If data < head.data
        // we need to insert it before head
        // and make it the new head
        // We need to find the tail for that
        if (data < head.data) {
            Node prev = head;
            Node curr = head.next;
            while (curr != head) {
                prev = curr;
                curr = curr.next;
            }

            // At this point prev will have tail
            prev.next = newNode;
            newNode.next = head;
            return newNode;
        }

        Node prev = head;
        Node curr = head.next;
        while (curr != head) {
            if (curr.data >= data) {
                // Insert it before curr as curr is the first node
                // with data >= data
                prev.next = newNode;
                newNode.next = curr;
                return head;
            }
            prev = curr;
            curr = curr.next;
        }

        // If it reaches here
        // it means it should be inserted after the last node
        // but head need not be updated
        // prev contains the last node
        prev.next = newNode;
        newNode.next = head;
        return head;
    }
}
