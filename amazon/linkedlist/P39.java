package amazon.linkedlist;

public class P39 {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node merge(Node head1, Node head2) {
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
        return merge(dummy0.next, dummy1.next);
    }
}
