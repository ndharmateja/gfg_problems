package amazon.linkedlists;

// TODO
public class P17 {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            this.data = key;
            next = null;
        }
    }

    private static Node getMiddleNode(Node head) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMiddleNode'");
    }

    static Node merge(Node head1, Node head2) {
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

    static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node head2 = getMiddleNode(head);
        head = mergeSort(head);
        head2 = mergeSort(head2);

        return merge(head, head2);
    }
}
