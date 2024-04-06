package amazon.linkedlists;

import java.util.Scanner;

import amazon.linkedlists.utils.Node;
import amazon.linkedlists.utils.LLUtils;

public class P6 {
    // Swaps the next two nodes after curr (and sets the connections)
    // and returns the next next node to curr after the swap is done
    // If there aren't two nodes after curr, returns null
    private Node swapTwoNodes(Node curr) {
        if (curr.next == null || curr.next.next == null)
            return null;

        Node next = curr.next;
        curr.next = next.next;
        next.next = curr.next.next;
        curr.next.next = next;

        return next;
    }

    public Node pairwiseSwap(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node curr = dummy;
        while (curr != null) {
            curr = swapTwoNodes(curr);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Node h = LLUtils.inputList(s);
        s.close();

        LLUtils.print(h);
        h = new P6().pairwiseSwap(h);
        LLUtils.print(h);
    }
}
