package microsoft.linkedlists;

public class P7 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    // If node's data is same as node next's data
    // we delete the next node and return node itself
    // If data is different we return the next node
    private Node removeOneDuplicate(Node node) {
        if (node.next == null)
            return null;
        if (node.data != node.next.data)
            return node.next;
        node.next = node.next.next;
        return node;
    }

    Node removeDuplicates(Node head) {
        Node curr = head;
        while (curr != null) {
            curr = removeOneDuplicate(curr);
        }

        // We always keep the earliest duplicate and delete tne next ones
        // so the head won't change
        return head;
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
        Node h = new Node(2);
        h.next = new Node(2);
        h.next.next = new Node(3);
        h.next.next.next = new Node(4);
        h.next.next.next.next = new Node(4);

        print(h);
        h = new P7().removeDuplicates(h);
        print(h);
    }
}
