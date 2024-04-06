package amazon.linkedlists;

import java.util.Scanner;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P25 {
    /**
     * Swaps curr and curr.next nodes
     * assumes that curr and curr.next are not null
     * 
     * @param prev - prev node of curr
     * @param curr
     * @return - the node next to prev after swapping
     */
    private static void swapData(Node curr, Node next) {
        assert (curr != null);
        assert (next != null);

        int temp = curr.data;
        curr.data = next.data;
        next.data = temp;
    }

    private static boolean isEven(int x) {
        return x % 2 == 0;
    }

    public static Node zigZag(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;

        // Go through the list and keep making swaps
        // if not in right order
        int i = 0;
        Node curr = head;
        while (curr != null && curr.next != null) {
            if ((isEven(i) && curr.data > curr.next.data)
                    || (!isEven(i) && curr.data < curr.next.data)) {
                swapData(curr, curr.next);
            }
            i++;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        // 5
        // 2 95 30 11 48
        Scanner s = new Scanner(System.in);
        Node h = LLUtils.inputList(s);
        s.close();

        LLUtils.print(h);
        h = zigZag(h);
        LLUtils.print(h);
    }
}
