package amazon.linkedlists;

import java.util.Scanner;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

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
        Node h = LLUtils.inputList(s);
        s.close();

        LLUtils.print(h);
        h = new P4().reverseList(h);
        LLUtils.print(h);
    }
}
