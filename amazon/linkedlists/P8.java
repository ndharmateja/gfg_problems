package amazon.linkedlists;

import java.util.Scanner;

import amazon.linkedlists.utils.Node;
import amazon.linkedlists.utils.Utils;

public class P8 {
    public static Node addOne(Node head) {
        head = Utils.reverse(head);

        // Add 1 to curr node
        // and inside the loop handle the overflow for each node
        Node curr = head;
        curr.data++;
        while (true) {
            // if carry
            if (curr.data == 10) {
                // make current data to 0
                curr.data = 0;

                // if no next node
                // create a 1 and add at the end and break
                if (curr.next == null) {
                    curr.next = new Node(1);
                    break;
                }
                // add 1 to next node as carry
                else {
                    curr.next.data++;
                    curr = curr.next;
                }
            }
            // if no carry, we can end the loop
            else {
                break;
            }
        }

        return Utils.reverse(head);
    }

    public static void main(String[] args) {
        // 4
        // 1 9 9 9
        Scanner s = new Scanner(System.in);
        Node h = Utils.inputList(s);
        s.close();

        h = addOne(h);
        Utils.print(h);
    }
}
