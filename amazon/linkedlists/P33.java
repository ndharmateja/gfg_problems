package amazon.linkedlists;

import java.util.Scanner;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P33 {
    public Node swapkthnode(Node h, int size, int k) {
        // Edge case
        if (k < 1 || k > size)
            return h;

        // Base case
        if (size == 1)
            return h;

        // Find the complement of k (as 1-index from start)
        // and if k = kComp we can return as no swapping necessary
        int kComp = size - k + 1;
        if (k == kComp)
            return h;

        // Make sure that k < kComp (swap otherwise)
        if (k > kComp) {
            int temp = k;
            k = kComp;
            kComp = temp;
        }

        // At this point we need to swap nodes at indices k and kComp (1-based)
        // and k < kComp
        Node dummy = new Node(-1);
        dummy.next = h;
        Node prev1, curr1, prev2, curr2;
        Node prev = dummy;
        Node curr = h;

        // Iterate such that curr becomes kth node (1-based)
        // Move k-1 times
        for (int i = 0; i < k - 1; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev1 = prev;
        curr1 = curr;

        // Iterate further such that curr becomes kComp th node (1-based)
        // Move kComp-k times
        for (int i = 0; i < kComp - k; i++) {
            prev = curr;
            curr = curr.next;
        }
        prev2 = prev;
        curr2 = curr;

        // At this point swap curr1 and curr2
        // Two cases:
        // If curr1 and curr2 are next to each other
        Node next1 = curr1.next;
        Node next2 = curr2.next;
        if (curr1.next == curr2) {
            prev1.next = curr2;
            curr2.next = curr1;
            curr1.next = next2;
            return dummy.next;
        }

        // Otherwise
        prev1.next = curr2;
        curr2.next = next1;
        prev2.next = curr1;
        curr1.next = next2;

        return dummy.next;
    }

    public static void main(String[] args) {
        // n k
        // n
        // (elements)
        //
        // 4 1
        // 4
        // 1 2 3 4
        // Expected output: 4 2 3 1
        //
        // 3 1
        // 3
        // 1 2 3
        // Expected output: 3 2 1
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        Node h = LLUtils.inputList(s);
        s.close();

        h = new P33().swapkthnode(h, n, k);
        LLUtils.print(h);
    }
}
