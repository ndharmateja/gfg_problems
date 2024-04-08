package flipkart.stacks;

import java.util.Stack;

public class P9 {
    private static final char LEFT_PARANTHESIS = '(';
    private static final char RIGHT_PARANTHESIS = ')';

    private static boolean isOpening(char c) {
        return c == LEFT_PARANTHESIS;
    }

    private static boolean isClosing(char c) {
        return c == RIGHT_PARANTHESIS;
    }

    public int MinParentheses(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpening(c))
                stack.push(c);
            else if (isClosing(c)) {
                // If stack is empty we need an opening bracket
                // for the current c
                if (stack.isEmpty())
                    count++;

                // If it is not empty
                // we remove the matching opening paranthesis from the stack
                else
                    stack.pop();
            }
        }

        // At this point if the stack is not empty
        // all its opening brackets need closing brackets
        count += stack.size();
        return count;
    }
}
