package amazon.stacks;

import java.util.LinkedList;
import java.util.Queue;

public class P4 {
    Queue<Integer> q1 = new LinkedList<Integer>();
    Queue<Integer> q2 = new LinkedList<Integer>();

    // Function to push an element into stack using two queues.
    void push(int a) {
        q1.add(a);
    }

    // Function to pop an element from stack using two queues.
    int pop() {
        // If q1 is empty we return -1
        if (q1.isEmpty())
            return -1;

        // Dequeue size-1 elements from q1 and put it in q2
        // and store the remaining one element as the one to return
        while (q1.size() > 1)
            q2.add(q1.poll());
        int popped = q1.poll();

        // Swap references of q1 and q2 so that
        // we don't need to copy all the elements of q2 to q1
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }
}
