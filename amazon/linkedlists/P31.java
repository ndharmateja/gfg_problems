package amazon.linkedlists;

public class P31 {
    public Node compute(Node head) {
        // Reverse the list as we can't traverse from right to left
        head = Utils.reverse(head);

        // Iterate and delete the elements that are not max so far
        int max = Integer.MIN_VALUE;
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            int data = curr.data;
            if (data >= max) {
                // don't delete the node and update max
                max = data;
                prev = curr;
                curr = curr.next;
            } else {
                // delete the node
                // prev stays the same
                prev.next = curr.next;
                curr = curr.next;
            }
        }

        // Reverse the list to get the original order
        return Utils.reverse(head);
    }
}
