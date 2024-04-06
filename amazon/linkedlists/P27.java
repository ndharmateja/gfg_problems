package amazon.linkedlists;

import java.util.Scanner;

public class P27 {
    // Reverses the 'k' nodes after 'node'
    // and returns the last node of those 'k' nodes after reversing the group
    // Works even if there are less than 'k' nodes after 'node'
    private static Node reverseOneGroup(Node node, int k) {
        // If no nodes after 'node'
        if (node.next == null)
            return null;

        // Run the loop 'k' times or until 'curr' becomes null
        Node h = node.next;
        Node prev = null;
        Node curr = h;
        for (int i = 0; i < k && curr != null; i++) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        // Linking the start and end of reversed group
        node.next = prev;
        h.next = curr;
        return h;
    }

    public static Node reverse(Node head, int k) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node curr = dummy;
        while (curr != null) {
            curr = reverseOneGroup(curr, k);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 4
        // 1 2 3 4
        Scanner s = new Scanner(System.in);
        Node h = Utils.inputList(s);
        s.close();

        Utils.print(h);
        h = reverse(h, 3);
        Utils.print(h);
    }
}
