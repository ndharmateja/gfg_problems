package amazon.linkedlists;

import java.util.Scanner;

public class P20 {
    public static Node findIntersection(Node head1, Node head2) {
        Node dummy = new Node(-1);
        Node curr = dummy;

        Node curr1 = head1;
        Node curr2 = head2;
        while (curr1 != null && curr2 != null) {
            if (curr1.data < curr2.data)
                curr1 = curr1.next;
            else if (curr1.data > curr2.data)
                curr2 = curr2.next;
            else {
                curr.next = new Node(curr1.data);
                curr = curr.next;
                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 4
        // 10 20 40 50
        // 2
        // 15 40
        Scanner s = new Scanner(System.in);
        Node h1 = Utils.inputList(s);
        Node h2 = Utils.inputList(s);
        s.close();

        Node h = findIntersection(h1, h2);
        Utils.print(h);
    }
}
