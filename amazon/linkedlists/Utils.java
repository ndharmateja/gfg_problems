package amazon.linkedlists;

public class Utils {
    public static Node reverseList(Node h) {
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
}
