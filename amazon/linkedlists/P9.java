package amazon.linkedlists;

import java.util.Scanner;

import amazon.linkedlists.utils.Node;
import amazon.linkedlists.utils.LLUtils;

public class P9 {
    private static Node removeZerosAtBeginning(Node h) {
        Node curr = h;
        while (curr.next != null && curr.data == 0) {
            curr = curr.next;
        }
        return curr;
    }

    // Function to add two numbers represented by linked list.
    public static Node addTwoLists(Node num1, Node num2) {
        // Reverse numbers so that we can
        // from the units place
        num1 = LLUtils.reverse(removeZerosAtBeginning(num1));
        num2 = LLUtils.reverse(removeZerosAtBeginning(num2));

        // Dummy node
        Node dummy = new Node(-1);
        Node curr = dummy;

        int carry = 0;
        Node curr1 = num1;
        Node curr2 = num2;
        while (curr1 != null || curr2 != null) {
            int digit1 = curr1 == null ? 0 : curr1.data;
            int digit2 = curr2 == null ? 0 : curr2.data;

            int sum = carry + digit1 + digit2;
            curr.next = new Node(sum % 10);
            curr = curr.next;

            carry = sum / 10;
            if (curr1 != null)
                curr1 = curr1.next;
            if (curr2 != null)
                curr2 = curr2.next;
        }

        // If carry is not 0 create a new digit
        if (carry != 0) {
            curr.next = new Node(carry);
        }

        // Reverse and return the result
        return LLUtils.reverse(dummy.next);
    }

    public static void main(String[] args) {
        // 2
        // 0 5
        // 4
        // 0 3 4 5
        Scanner s = new Scanner(System.in);
        Node h1 = LLUtils.inputList(s);
        Node h2 = LLUtils.inputList(s);
        s.close();

        LLUtils.print(h1);
        LLUtils.print(h2);
        LLUtils.print(addTwoLists(h1, h2));
    }
}
