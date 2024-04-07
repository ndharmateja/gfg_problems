package google.linkedlists;

@SuppressWarnings("unused")
public class P10 {
    private static class LNode {
        int data;
        LNode next;

        LNode(int d) {
            data = d;
            next = null;
        }
    }

    private static class TNode {
        int data;
        TNode left, right;

        TNode(int x) {
            data = x;
            left = right = null;
        }

    }

    public TNode sortedListToBST(LNode h) {
        // Base case
        if (h == null)
            return null;
        if (h.next == null)
            return new TNode(h.data);

        // Find the middle node
        LNode prev = null;
        LNode slow = h;
        LNode fast = h;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // At this point slow is the middle node
        // Separate left half and middle node and right half
        LNode mid = slow;
        LNode h2 = slow.next;
        prev.next = null;
        mid.next = null;

        // Recursively convert left and right halves into trees
        TNode root = new TNode(mid.data);
        root.left = sortedListToBST(h);
        root.right = sortedListToBST(h2);

        return root;
    }
}
