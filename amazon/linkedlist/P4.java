package amazon.linkedlist;

public class P4 {
    static class Node {
        int data;
        Node next;

        Node(int value) {
            this.data = value;
        }
    }

    Node reverseList(Node head) {
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
        h.next = new Node(2);
        h.next.next = new Node(3);

        print(h);
        h = new P4().reverseList(h);
        print(h);
    }
}
