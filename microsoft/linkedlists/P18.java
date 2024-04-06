package microsoft.linkedlists;

import java.util.Scanner;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P18 {
    // Reverses 'k' nodes after 'node' (works even if there are not k nodes after
    // node) and sets the links
    private static void reverseKNodes(Node node, int k) {
        // Base case
        if (node.next == null)
            return;

        Node prev = null;
        Node curr = node.next;
        for (int i = 0; i < k; i++) {
            // Handle case where there aren't k nodes
            // The first node's next (before reversing) in the reversed section is already
            // set to null in the first iteration as prev is null initially
            // So only prev (which is the last node in the reversed section before
            // reversing) has to be set as node's next
            if (curr == null) {
                node.next = prev;
                return;
            }

            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Set links at the ends of the reversed section
        // node -> (reversed section) -> (next section)
        // prev points to the last element of the reversed section (before reversing)
        // and curr points to the first node of the 'next section'
        // node.next points to the first node of the reversed section (before reversing)
        node.next.next = curr;
        node.next = prev;
    }

    public static Node reverseBetween(Node head, int m, int n) {
        // Base case
        if (m == n)
            return head;

        // Make sure m < n
        if (m > n) {
            int temp = m;
            m = n;
            n = temp;
        }

        // If m and n <= 0 ,make them 1
        if (m <= 0)
            m = 1;
        if (n <= 0)
            n = 1;

        // Num nodes to reverse
        int k = n - m + 1;

        // Go to the node right before the reversal
        // and reverse 'k' nodes after that node
        Node dummy = new Node(-1);
        dummy.next = head;
        Node curr = dummy;
        for (int i = 0; i < m - 1 && curr != null; i++) {
            curr = curr.next;
        }

        // If curr is null that means
        // m is out of bounds
        // and we can exit
        if (curr == null)
            return head;

        // At this point, 'curr' points to the node before the mth node
        // so next 'k' nodes after curr must be reversed
        reverseKNodes(curr, k);
        return dummy.next;
    }

    public static void main(String[] args) {
        // 1
        // 8
        // 10
        // 1 7 5 3 9 8 10 2 2 5
        Scanner s = new Scanner(System.in);
        int m = s.nextInt();
        int n = s.nextInt();
        Node h = LLUtils.inputList(s);
        s.close();

        LLUtils.print(h);
        h = reverseBetween(h, m, n);
        LLUtils.print(h);
    }
}
