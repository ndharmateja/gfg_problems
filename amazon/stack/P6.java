package amazon.stack;

import java.util.Stack;

public class P6 {
    // Inserts elem into a sorted stack recursively
    private void insert(Stack<Integer> s, int elem) {
        if (s.isEmpty() || s.peek() < elem) {
            s.push(elem);
            return;
        }

        int top = s.pop();
        insert(s, elem);
        s.push(top);
    }

    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        if (s.isEmpty())
            return s;

        int top = s.pop();
        s = sort(s);
        insert(s, top);

        return s;
    }
}
