package amazon.linkedlists;

import java.util.Scanner;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P11 {
    static Node insertAfter(Node node, Node toInsert) {
        toInsert.next = node.next;
        node.next = toInsert;
        return toInsert;
    }

    void rearrangeEvenOdd(Node head) {
        Node dummy0 = new Node(-1);
        Node dummy1 = new Node(-1);
        Node curr0 = dummy0;
        Node curr1 = dummy1;

        // connect dummy0 and dummy1
        dummy0.next = dummy1;

        Node curr = head;
        int i = 0;
        while (curr != null) {
            Node next = curr.next;
            if (i++ % 2 == 0) {
                curr0 = insertAfter(curr0, curr);
            } else {
                curr1 = insertAfter(curr1, curr);
            }
            curr = next;
        }

        // At this point the list looks like
        // dummy0 -> (even index elements) -> dummy1 -> (odd index elements)
        // curr0 is node before dummy1

        // Delete dummy1 (node after curr0)
        curr0.next = dummy1.next;
    }

    public static void main(String[] args) {
        // 4
        // 1 2 3 4
        Scanner s = new Scanner(System.in);
        Node h = LLUtils.inputList(s);
        s.close();

        LLUtils.print(h);
        new P11().rearrangeEvenOdd(h);
        LLUtils.print(h);
    }
}
