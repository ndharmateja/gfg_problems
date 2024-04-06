package amazon.linkedlists;

import java.util.HashSet;
import java.util.Scanner;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P38 {
    public static Node findIntersection(Node head1, Node head2) {
        HashSet<Integer> set2 = new HashSet<>();
        set2.clear();
        Node curr2 = head2;
        while (curr2 != null) {
            set2.add(curr2.data);
            curr2 = curr2.next;
        }

        Node dummy = new Node(-1);
        Node curr = dummy;

        Node curr1 = head1;
        while (curr1 != null) {
            int data1 = curr1.data;
            Node next = curr1.next;
            if (set2.contains(data1)) {
                curr.next = curr1;
                curr = curr.next;
                curr1.next = null;
            }
            curr1 = next;
        }

        return dummy.next;
    }

    public static void main(String args[]) {
        // 6
        // 9 6 4 2 3 8
        // 4
        // 1 2 8 6
        Scanner s = new Scanner(System.in);
        Node head1 = LLUtils.inputList(s);
        Node head2 = LLUtils.inputList(s);
        s.close();

        Node result = findIntersection(head1, head2);
        LLUtils.print(result);
    }
}
