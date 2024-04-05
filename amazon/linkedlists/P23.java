package amazon.linkedlists;

@SuppressWarnings("unused")
public class P23 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    /**
     * splits list into 2 halves
     * and returns the head of the second half
     * 
     * @param h
     * @return
     */
    private static Node splitList(Node h) {
        Node prev = null;
        Node slow = h;
        Node fast = h;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // Break the list into 2 halves
        prev.next = null;

        // Return head of second half
        return slow;
    }

    private static Node merge(Node head1, Node head2) {
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

    public static Node mergeSort(Node head) {
        if (head == null || head.next == null)
            return head;

        Node head2 = splitList(head);
        head = mergeSort(head);
        head2 = mergeSort(head2);

        return merge(head, head2);
    }

    /**
     * Inserts data after node if it is not equal to node's data
     * 
     * @param node
     * @param data
     * @return
     */
    private static Node insertAfter(Node node, int data) {
        if (node.data == data)
            return node;
        Node newNode = new Node(data);
        node.next = newNode;
        return newNode;
    }

    /**
     * 1. Sort each individual list
     * 2. (like merge) have two pointers and take the smaller
     * element each time and add it to the union list if it is not
     * already there
     * 
     * @param head1
     * @param head2
     * @return
     */
    private static Node solution1(Node head1, Node head2) {
        // New union list
        Node dummy = new Node(-1);
        Node curr = dummy;

        // Sort both the lists
        head1 = mergeSort(head1);
        head2 = mergeSort(head2);
        Node curr1 = head1;
        Node curr2 = head2;

        // Have two pointers one for each list
        // and add the lower value to the union list
        // if it's not equal to the curr's value
        while (curr1 != null && curr2 != null) {
            int dataToInsert;
            if (curr1.data < curr2.data) {
                dataToInsert = curr1.data;
                curr1 = curr1.next;
            } else {
                dataToInsert = curr2.data;
                curr2 = curr2.next;
            }
            curr = insertAfter(curr, dataToInsert);
        }

        // Process the remaining elements
        while (curr1 != null) {
            curr = insertAfter(curr, curr1.data);
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            curr = insertAfter(curr, curr2.data);
            curr2 = curr2.next;
        }

        // return new head
        return dummy.next;
    }

    /**
     * 1. Join both lists
     * 2. Sort the resulting list
     * 3. Remove duplicates in the sorted list
     * 
     * @param head1
     * @param head2
     * @return
     */
    private static Node solution2(Node head1, Node head2) {
        // Join list2 after list1
        Node curr1 = head1;
        while (curr1.next != null) {
            curr1 = curr1.next;
        }
        Node last1 = curr1;
        last1.next = head2;

        // Sort list
        Node head = mergeSort(head1);

        // Remove duplicates
        Node curr = head;
        while (curr.next != null) {
            // if curr's data is same as next's data
            // remove next
            // and we don't need to update curr
            if (curr.data == curr.next.data) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        // Return
        return head;
    }

    public static Node findUnion(Node head1, Node head2) {
        return solution2(head1, head2);
    }
}
