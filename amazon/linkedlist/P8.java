package amazon.linkedlist;

public class P8 {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    private static Node reverse(Node head) {
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

    public static Node addOne(Node head) {
        head = reverse(head);

        // Add 1 to curr node
        // and inside the loop handle the overflow for each node
        Node curr = head;
        curr.data++;
        while (true) {
            // if carry
            if (curr.data == 10) {
                // make current data to 0
                curr.data = 0;

                // if no next node
                // create a 1 and add at the end and break
                if (curr.next == null) {
                    curr.next = new Node(1);
                    break;
                }
                // add 1 to next node as carry
                else {
                    curr.next.data++;
                    curr = curr.next;
                }
            }
            // if no carry, we can end the loop
            else {
                break;
            }
        }

        return reverse(head);
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
        Node h = new Node(1);
        h.next = new Node(9);
        h.next.next = new Node(9);
        h.next.next.next = new Node(9);

        h = addOne(h);
        print(h);
    }
}
