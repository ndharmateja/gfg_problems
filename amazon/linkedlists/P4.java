package amazon.linkedlists;

import java.util.Scanner;

import amazon.linkedlists.utils.Node;
import amazon.linkedlists.utils.Utils;

public class P4 {
    public Node reverseList(Node head) {
        if (head == null || head.next == null)
            return head;

        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Node h = Utils.inputList(s);
        s.close();

        Utils.print(h);
        h = new P4().reverseList(h);
        Utils.print(h);
    }
}
