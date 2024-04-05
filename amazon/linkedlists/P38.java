package amazon.linkedlists;

import java.util.HashSet;
import java.util.Scanner;

public class P38 {
    static class Node {
        int data;
        Node next;

        Node(int a) {
            data = a;
            next = null;
        }
    }

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

    public static Node inputList(Scanner sc, int size) {
        Node head, tail;
        int val;

        val = sc.nextInt();
        head = tail = new Node(val);

        size--;
        while (size-- > 0) {
            val = sc.nextInt();
            tail.next = new Node(val);
            tail = tail.next;
        }

        return head;
    }

    private static void print(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n, m;

        n = sc.nextInt();
        Node head1 = inputList(sc, n);

        m = sc.nextInt();
        Node head2 = inputList(sc, m);

        Node result = findIntersection(head1, head2);

        print(result);
    }
}
