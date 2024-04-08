package flipkart.stacks;

import java.util.Stack;

public class P2 {
    Stack<Integer> st1 = new Stack<Integer>();
    Stack<Integer> st2 = new Stack<Integer>();

    public int dequeue() {
        if (st1.isEmpty())
            return -1;

        // Move n-1 elements from st1 to st2
        // Get the element to dequeue
        // and move back the elements from st2 to st1
        int n = st1.size();
        for (int i = 0; i < n - 1; i++) {
            st2.push(st1.pop());
        }
        int dequeued = st1.pop();
        for (int i = 0; i < n - 1; i++) {
            st1.push(st2.pop());
        }

        return dequeued;
    }

    public void enqueue(int x) {
        st1.push(x);
    }
}
