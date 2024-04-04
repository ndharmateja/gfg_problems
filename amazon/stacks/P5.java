package amazon.stacks;

import java.util.Stack;

public class P5 {
    public void push(int a, Stack<Integer> s) {
        s.push(a);
    }

    public int pop(Stack<Integer> s) {
        if (s.isEmpty())
            return -1;
        return s.pop();
    }

    public int min(Stack<Integer> s) {
        if (s.isEmpty())
            return -1;

        Stack<Integer> temp = new Stack<>();
        int min = Integer.MAX_VALUE;
        while (!s.isEmpty()) {
            int curr = s.pop();
            min = Integer.min(min, curr);
            temp.push(curr);
        }

        while (!temp.isEmpty()) {
            s.push(temp.pop());
        }
        return min;
    }

    public boolean isFull(Stack<Integer> s, int n) {
        return s.size() == n;
    }

    public boolean isEmpty(Stack<Integer> s) {
        return s.isEmpty();
    }
}
