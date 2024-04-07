package amazon.linkedlists;

public class P28 {
    private static class Node {
        int data;
        Node next, arb;

        Node(int d) {
            data = d;
            next = arb = null;

        }
    }

    private static Node insertAfter(Node node, Node toInsert) {
        toInsert.next = node.next;
        node.next = toInsert;
        return toInsert;
    }

    public Node copyList(Node h) {
        // 1. Create copy of each node and insert it into the list
        // right after its original
        Node curr = h;
        while (curr != null) {
            Node clone = new Node(curr.data);
            clone.next = curr.next;
            curr.next = clone;
            curr = curr.next.next;
        }

        // 2. Iterate through each original node (say curr) and assign the
        // arb pointer of its copy
        // By getting the arb node of the original and arb node of the copy will
        // be next to the arb node of the original
        curr = h;
        while (curr != null) {
            // Update the arb of the clone
            // if the original has an arb pointer
            if (curr.arb != null) {
                curr.next.arb = curr.arb.next;
            }
            curr = curr.next.next;
        }

        // 3. Separate out original and copy nodes so that the original
        // structure of the list stays intact
        Node dummyOrg = new Node(-1);
        Node currOrg = dummyOrg;
        Node dummyClone = new Node(-1);
        Node currClone = dummyClone;
        curr = h;
        int i = 0;
        while (curr != null) {
            Node next = curr.next;
            if (i++ % 2 == 0) {
                currOrg = insertAfter(currOrg, curr);
            } else {
                currClone = insertAfter(currClone, curr);
            }
            curr = next;
        }

        // Return the cloned list
        return dummyClone.next;
    }
}
