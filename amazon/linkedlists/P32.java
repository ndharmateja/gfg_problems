package amazon.linkedlists;

public class P32 {
    private static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    private static Node insertBelow(Node node, Node toInsert) {
        toInsert.next = null;
        toInsert.bottom = node.bottom;
        node.bottom = toInsert;
        return toInsert;
    }

    private static int getHorizontalSize(Node node) {
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }
        return size;
    }

    public Node flatten(Node root) {
        // To store the resulting flattened list
        Node dummy = new Node(-1);
        Node curr = dummy;

        // Put all the horizontal elements
        // in an array
        Node currH = root;
        int sizeH = getHorizontalSize(root);
        Node[] arr = new Node[sizeH];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = currH;
            currH = currH.next;
        }

        // In each iteration get the minimum of all the nodes
        // in the array
        // and add that node to the result
        // and move it by one step to its bottom
        while (true) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < arr.length; i++) {
                Node n = arr[i];
                if (n != null && n.data <= min) {
                    minIndex = i;
                    min = n.data;
                }
            }

            // If all elements are null => we are done
            if (minIndex == -1)
                break;

            // Add the min node to the result
            Node bottom = arr[minIndex].bottom;
            curr = insertBelow(curr, arr[minIndex]);
            arr[minIndex] = bottom;
        }

        return dummy.bottom;
    }

    private static void printVertically(Node root) {
        while (root != null) {
            System.out.println("[ " + root.data + " ]");
            System.out.println("  |  ");
            System.out.println("  v  ");
            root = root.bottom;
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.next = new Node(10);
        root.next.next = new Node(19);
        root.next.next.next = new Node(28);

        root.bottom = new Node(7);
        root.bottom.bottom = new Node(8);
        root.bottom.bottom.bottom = new Node(30);

        root.next.next.bottom = new Node(22);
        root.next.next.bottom.bottom = new Node(50);

        root = new P32().flatten(root);
        printVertically(root);
    }
}
