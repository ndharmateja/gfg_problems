package amazon.linkedlists;

import java.util.HashSet;

import utils.linkedlists.Node;

public class P24 {
    public Node removeDuplicates(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;

        HashSet<Integer> set = new HashSet<>();
        Node prev = dummy;
        Node curr = head;
        while (curr != null) {
            // If curr's data is already there
            // we have to delete curr
            // and we don't need to update prev
            if (set.contains(curr.data)) {
                prev.next = curr.next;
                curr = curr.next;
            }
            // If we are seeing this data for the first time
            // we add it to the set and move on
            else {
                set.add(curr.data);
                prev = curr;
                curr = curr.next;
            }
        }

        return dummy.next;
    }
}