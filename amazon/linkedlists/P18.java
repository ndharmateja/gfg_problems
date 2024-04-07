package amazon.linkedlists;

import java.util.Comparator;
import java.util.PriorityQueue;

import utils.linkedlists.LLUtils;
import utils.linkedlists.Node;

@SuppressWarnings("unused")
public class P18 {
    // O(n log(k)) time
    // Recursive solution
    private Node solution1(Node[] arr, int l, int r) {
        // Base case
        if (l == r) {
            return arr[l];
        }

        // Recursion
        int mid = (l + r) / 2;
        Node leftMerge = solution1(arr, l, mid);
        Node rightMerge = solution1(arr, mid + 1, r);
        return LLUtils.merge(leftMerge, rightMerge);
    }

    // O(nk) time
    // Merge one by one
    private Node solution2(Node[] arr, int k) {
        Node result = arr[0];
        for (int i = 1; i < k; i++) {
            result = LLUtils.merge(result, arr[i]);
        }
        return result;
    }

    // attaches toAttach at the end of n
    // and returns the last node of the joined list
    private Node attachList(Node n, Node toAttach) {
        Node curr = toAttach;
        while (curr.next != null) {
            curr = curr.next;
        }
        n.next = toAttach;
        return curr;
    }

    // O(nk log(nk)) time and O(1) space
    // Join all lists one after another
    // and sort the resulting list
    private Node solution3(Node[] arr, int k) {
        Node dummy = new Node(-1);
        Node curr = dummy;

        for (Node n : arr) {
            curr = attachList(curr, n);
        }

        return LLUtils.mergeSort(dummy.next);
    }

    // O(nk log(k)) time and O(k) space
    // Put all the Nodes in a min heap
    // And remove the min one each time
    // and put back the next node of the removed node
    private Node solution4(Node[] arr, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {
            public int compare(Node n1, Node n2) {
                return n1.data - n2.data;
            };
        });

        for (Node n : arr)
            pq.add(n);

        Node dummy = new Node(-1);
        Node curr = dummy;
        while (!pq.isEmpty()) {
            Node min = pq.poll();
            Node next = min.next;
            min.next = null;
            curr.next = min;
            curr = curr.next;
            if (next != null)
                pq.add(next);
        }

        return dummy.next;
    }

    // Merging 'k' lists of size 'n'
    public Node mergeKList(Node[] arr, int k) {
        // return solution1(arr, 0, k - 1);
        return solution2(arr, k);
    }
}
