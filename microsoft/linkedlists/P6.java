package microsoft.linkedlists;

import java.util.Scanner;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P6 {
    public static Node removeAllDuplicates(Node head) {
        Node dummy = new Node(-1);
        dummy.next = head;

        Node prev = dummy;
        Node curr = head;
        int currDuplicate = -1;
        boolean isDuplicate = false;
        while (curr != null) {
            if (!isDuplicate) {
                // If no duplicate series is running
                // and next node is null
                // We can exit as this is the last node
                if (curr.next == null) {
                    break;
                }

                // At this point there is atleast one node after curr
                // If curr's data is equal to the next node's data that means
                // a new duplicates series has started
                // So we set the boolean variable and the curr duplicate value
                // and delete the next node
                if (curr.data == curr.next.data) {
                    isDuplicate = true;
                    currDuplicate = curr.data;
                    // Delete next node
                    // and don't need to update prev or curr
                    curr.next = curr.next.next;
                }

                // If no duplicate series is already running and next element
                // is different from the current one
                // Curr's value is not a duplicate and we can go to the next node
                else {
                    prev = curr;
                    curr = curr.next;
                }
            } else {
                // If a duplicate series is already running and the curr's val is same as
                // the duplicate value we remove curr
                // And we only need to update curr
                if (curr.data == currDuplicate) {
                    prev.next = curr.next;
                    curr = curr.next;
                }

                // If a duplicate series is running and the curr's value is different from
                // the duplicate value, the series has ended
                // So we update the isDuplicate variable and go to the next iteration
                // Thing to note is that we don't update curr/prev as we want to check
                // if it is the start of a new duplicate series
                else {
                    isDuplicate = false;
                }
            }
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        // 8
        // 23 28 28 35 49 49 53 53
        Scanner s = new Scanner(System.in);
        Node h = LLUtils.inputList(s);
        s.close();

        LLUtils.print(h);
        h = removeAllDuplicates(h);
        LLUtils.print(h);
    }
}
