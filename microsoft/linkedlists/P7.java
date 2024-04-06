package microsoft.linkedlists;

import java.util.Scanner;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P7 {
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

    public static void main(String[] args) {
        // 5
        // 2 2 3 4 4
        Scanner s = new Scanner(System.in);
        Node h = LLUtils.inputList(s);
        s.close();

        LLUtils.print(h);
        h = new P7().removeDuplicates(h);
        LLUtils.print(h);
    }
}
