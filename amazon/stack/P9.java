package amazon.stack;

import java.util.Stack;

public class P9 {
    Stack<Integer> s = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    int getMin() {
        if (s.isEmpty())
            return -1;
        return minStack.peek();
    }

    int pop() {
        if (s.isEmpty())
            return -1;
        minStack.pop();
        return s.pop();
    }

    void push(int x) {
        s.push(x);
        if (minStack.isEmpty())
            minStack.push(x);
        else
            minStack.push(Integer.min(minStack.peek(), x));
    }
}
