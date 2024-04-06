package amazon.linkedlists;

import java.util.Scanner;

import amazon.linkedlists.utils.Node;
import amazon.linkedlists.utils.LLUtils;

public class P17 {
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

    public static void main(String[] args) {
        // 6
        // 3 5 2 4 1 4
        Scanner s = new Scanner(System.in);
        Node h = LLUtils.inputList(s);
        s.close();

        LLUtils.print(h);
        LLUtils.print(mergeSort(h));
    }
}
