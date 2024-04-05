package amazon.linkedlists;

public class P9 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    private static Node reverse(Node h) {
        Node prev = null;
        Node curr = h;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

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
        num1 = reverse(removeZerosAtBeginning(num1));
        num2 = reverse(removeZerosAtBeginning(num2));

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
        return reverse(dummy.next);
    }

    static void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node h1 = new Node(0);
        h1.next = new Node(5);

        Node h2 = new Node(0);
        h2.next = new Node(3);
        h2.next.next = new Node(4);
        h2.next.next.next = new Node(5);

        print(h1);
        print(h2);
        print(addTwoLists(h1, h2));
    }
}
