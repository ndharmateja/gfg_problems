package amazon.linkedlists;

import java.util.Scanner;

import amazon.linkedlists.utils.Node;
import amazon.linkedlists.utils.LLUtils;

public class P7 {
    static Node insertAfter(Node node, Node toInsert) {
        toInsert.next = node.next;
        node.next = toInsert;
        return toInsert;
    }

    static Node segregate(Node head) {
        Node dummy0 = new Node(-1);
        Node curr0 = dummy0;
        Node dummy1 = new Node(-1);
        Node curr1 = dummy1;
        Node dummy2 = new Node(-1);
        Node curr2 = dummy2;

        // connect the dummy nodes to each other
        dummy0.next = dummy1;
        dummy1.next = dummy2;

        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            if (curr.data == 0) {
                curr0 = insertAfter(curr0, curr);
            } else if (curr.data == 1) {
                curr1 = insertAfter(curr1, curr);
            } else {
                curr2 = insertAfter(curr2, curr);
            }
            curr = next;
        }

        // At this point the list looks like
        // dummy0 -> 0 -> .. -> 0 -> dummy1 -> 1 -> .. -> 1 -> dummy2 -> 2 -> .. -> 2 ->
        // curr0 is the node before dummy1
        // curr1 is the node before dummy2
        // curr2 is the last node
        // We have to delete dummy2 and dummy1 (we have to delete in this order inorder
        // to handle the edge cases where there are no 0s or 1s or 2s)

        // Delete dummy2 (node after curr1)
        curr1.next = dummy2.next;

        // Delete dummy1 (node after curr0)
        curr0.next = dummy1.next;

        // return head
        return dummy0.next;
    }

    public static void main(String[] args) {
        // 3
        // 2 2 1
        Scanner s = new Scanner(System.in);
        Node h = LLUtils.inputList(s);
        s.close();

        LLUtils.print(h);
        h = segregate(h);
        LLUtils.print(h);
    }
}
