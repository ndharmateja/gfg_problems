package amazon.linkedlists;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

public class P22 {
    public boolean isPalindrome(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // At this point if fast is null, the list is even lengthed
        // and the slow pointer is at the start of the second half
        // If fast.next is null, the list is odd lengthed and
        // the slow pointer is at the middle node
        Node secondHalf = fast == null ? slow : slow.next;
        Node secondHalfReverse = LLUtils.reverse(secondHalf);

        // Now see if second half reverse is same as the first half
        // and for odd lengthed list second half will have one size less
        // than the first half
        // So we only iterate until we exhaust second half
        Node curr1 = head;
        Node curr2 = secondHalfReverse;
        while (curr2 != null) {
            if (curr1.data != curr2.data)
                return false;

            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        // If we reach here it means it is a palindrome
        return true;
    }
}
