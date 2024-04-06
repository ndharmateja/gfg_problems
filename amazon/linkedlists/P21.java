package amazon.linkedlists;

import java.util.HashSet;
import java.util.Scanner;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

@SuppressWarnings("unused")
public class P21 {
    // O(N + M) time and O(max(N, M)) space complexities
    // Using a hashset
    private int solution1(Node head1, Node head2) {
        HashSet<Node> set1 = new HashSet<>();

        Node curr = head1;
        while (curr != null) {
            set1.add(curr);
            curr = curr.next;
        }

        curr = head2;
        while (curr != null) {
            if (set1.contains(curr))
                return curr.data;
            curr = curr.next;
        }

        return -1;
    }

    // O(N + M) time and O(1) space complexities
    private int solution2(Node head1, Node head2) {
        int size1 = LLUtils.getSize(head1);
        int size2 = LLUtils.getSize(head2);

        // If size1 > size2 we will swap the heads
        // so that list 1 will always have the lower size
        if (size1 > size2) {
            Node temp = head1;
            head1 = head2;
            head2 = temp;
        }

        // Move pointer2 diff number of times
        int diff = Math.abs(size2 - size1);
        Node curr2 = head2;
        for (int i = 0; i < diff; i++) {
            curr2 = curr2.next;
        }

        // Move both pointers simultaneously and find the common one
        Node curr1 = head1;
        while (curr1 != null) {
            if (curr1 == curr2)
                return curr1.data;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        // If we reach here => no common node
        return -1;
    }

    public int intersectPoint(Node head1, Node head2) {
        return solution2(head1, head2);
    }

    public static void main(String[] args) {
        // 2
        // 15 30
        // 3
        // 3 6 9
        // 1
        // 10
        Scanner s = new Scanner(System.in);
        Node common = LLUtils.inputList(s);
        Node h1 = LLUtils.inputList(s);
        Node h2 = LLUtils.inputList(s);
        s.close();

        LLUtils.joinLists(h1, common);
        LLUtils.joinLists(h2, common);

        LLUtils.print(h1);
        LLUtils.print(h2);
        System.out.println(new P21().intersectPoint(h1, h2));
    }
}
