package amazon.linkedlist;

public class P20 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

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

    static void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node h1 = new Node(10);
        h1.next = new Node(20);
        h1.next.next = new Node(40);
        h1.next.next.next = new Node(50);

        Node h2 = new Node(15);
        h2.next = new Node(40);

        Node h = findIntersection(h1, h2);
        print(h);
    }
}
