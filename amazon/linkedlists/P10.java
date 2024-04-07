package amazon.linkedlists;

import java.util.Scanner;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P10 {
    private static Node removeZerosAtBeginning(Node h) {
        Node curr = h;
        while (curr.next != null && curr.data == 0) {
            curr = curr.next;
        }
        return curr;
    }

    private static boolean isFirstLessThanOrEqualToSecond(Node h1, Node h2) {
        int n1 = LLUtils.getSize(h1);
        int n2 = LLUtils.getSize(h2);

        if (n1 != n2)
            return n1 < n2;

        // At this point n1 = n2
        Node curr1 = h1;
        Node curr2 = h2;
        while (curr1 != null && curr1.data == curr2.data) {
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        // Both numbers are same if curr1 is null
        if (curr1 == null)
            return true;

        return curr1.data < curr2.data;

    }

    public Node subLinkedList(Node h1, Node h2) {
        // Remove prefix zeros
        h1 = removeZerosAtBeginning(h1);
        h2 = removeZerosAtBeginning(h2);

        // Make sure number represented by h1 is greater than h2
        // otherwise swap
        if (isFirstLessThanOrEqualToSecond(h1, h2)) {
            Node temp = h1;
            h1 = h2;
            h2 = temp;
        }

        // Reverse lists
        h1 = LLUtils.reverse(h1);
        h2 = LLUtils.reverse(h2);

        // New list to store the result
        Node dummy = new Node(-1);
        Node curr = dummy;

        // Iterate over h1 and h2 simulataneously
        Node curr1 = h1;
        Node curr2 = h2;
        int carry = 0;
        // As number 1 will have more than or equal to the digits in number 2
        // we only need to check curr1 != null
        while (curr1 != null) {
            // Add carry to digit1 and reset it
            int digit1 = curr1.data + carry;
            carry = 0;
            int digit2 = curr2 == null ? 0 : curr2.data;

            // Borrow from the next digit if diff < 0
            if (digit1 < digit2) {
                carry = -1;
                digit1 += 10;
            }

            // Store the difference in curr1 node itself
            // and we will curr1 at the end of our resulting list
            curr1.data = digit1 - digit2;
            Node next1 = curr1.next;
            curr = LLUtils.insertAfter(curr, curr1);

            curr1 = next1;
            if (curr2 != null)
                curr2 = curr2.next;
        }

        return removeZerosAtBeginning(LLUtils.reverse(dummy.next));
    }

    public static void main(String[] args) {
        // 3
        // 1 0 0
        // 2
        // 1 2
        // Expected output: 8 -> 8
        Scanner s = new Scanner(System.in);
        Node h1 = LLUtils.inputList(s);
        Node h2 = LLUtils.inputList(s);
        s.close();

        LLUtils.print(h1);
        LLUtils.print(h2);
        Node h = new P10().subLinkedList(h1, h2);
        LLUtils.print(h);
    }
}
