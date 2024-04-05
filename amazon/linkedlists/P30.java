package amazon.linkedlists;

public class P30 {
    static class Node {
        int coeff;
        int pow;
        Node next;

        Node(int a, int b) {
            coeff = a;
            pow = b;
            next = null;
        }
    }

    public static Node addPolynomial(Node p1, Node p2) {
        // To store the resulting polynomial
        Node dummy = new Node(-1, -1);
        Node curr = dummy;

        Node curr1 = p1;
        Node curr2 = p2;
        while (curr1 != null && curr2 != null) {
            int power;
            int coeff;
            if (curr1.pow > curr2.pow) {
                power = curr1.pow;
                coeff = curr1.coeff;
                curr1 = curr1.next;
            } else if (curr1.pow < curr2.pow) {
                power = curr2.pow;
                coeff = curr2.coeff;
                curr2 = curr2.next;
            } else {
                power = curr1.pow;
                coeff = curr1.coeff + curr2.coeff;
                curr1 = curr1.next;
                curr2 = curr2.next;
            }

            // Create a new node
            Node node = new Node(coeff, power);
            curr.next = node;
            curr = curr.next;
        }

        while (curr1 != null) {
            Node node = new Node(curr1.coeff, curr1.pow);
            curr.next = node;
            curr = curr.next;
            curr1 = curr1.next;
        }
        while (curr2 != null) {
            Node node = new Node(curr2.coeff, curr2.pow);
            curr.next = node;
            curr = curr.next;
            curr2 = curr2.next;
        }

        return dummy.next;
    }
}
