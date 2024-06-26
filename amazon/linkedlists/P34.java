package amazon.linkedlists;

import java.util.Scanner;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P34 {
    public static void rearrange(Node h) {
        // Base case
        // If size of list is less than or equal to 2
        // we don't need to do anything
        if (h == null || h.next == null || h.next.next == null)
            return;

        // Split list into 2 parts
        Node dummy0 = new Node(-1);
        Node dummy1 = new Node(-1);
        Node curr0 = dummy0;
        Node curr1 = dummy1;
        Node curr = h;
        int i = 0;
        while (curr != null) {
            Node next = curr.next;
            curr.next = null;
            if (i++ % 2 == 0) {
                curr0.next = curr;
                curr0 = curr0.next;
            } else {
                curr1.next = curr;
                curr1 = curr1.next;
            }
            curr = next;
        }

        // At this point, curr0 is the end of the first list
        // and curr1 is the end of the second list
        // Reverse second list and add it at the end of first list
        curr0.next = LLUtils.reverse(dummy1.next);
    }

    public static void main(String[] args) {
        // 8
        // 10 4 9 1 3 5 9 4
        Scanner s = new Scanner(System.in);
        Node h = LLUtils.inputList(s);
        s.close();

        LLUtils.print(h);
        rearrange(h);
        LLUtils.print(h);
    }
}
