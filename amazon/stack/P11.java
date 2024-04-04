package amazon.stack;

import java.util.Stack;

public class P11 {
    private static final char LEFT_PARANTHESIS = '(';
    private static final char RIGHT_PARANTHESIS = ')';
    private static final char LEFT_BRACE = '{';
    private static final char RIGHT_BRACE = '}';
    private static final char LEFT_SQUARE = '[';
    private static final char RIGHT_SQUARE = ']';

    static boolean isOpening(char c) {
        return c == LEFT_PARANTHESIS || c == LEFT_BRACE || c == LEFT_SQUARE;
    }

    static boolean isClosing(char c) {
        return c == RIGHT_PARANTHESIS || c == RIGHT_BRACE || c == RIGHT_SQUARE;
    }

    static boolean areMatching(char open, char close) {
        return (open == LEFT_PARANTHESIS && close == RIGHT_PARANTHESIS) || (open == LEFT_BRACE && close == RIGHT_BRACE)
                || (open == LEFT_SQUARE && close == RIGHT_SQUARE);
    }

    static boolean ispar(String x) {
        Stack<Character> stack = new Stack<>();
        for (char c : x.toCharArray()) {
            if (isOpening(c)) {
                stack.push(c);
            } else if (isClosing(c)) {
                if (stack.isEmpty())
                    return false;

                if (!areMatching(stack.pop(), c))
                    return false;
            }
        }

        return stack.isEmpty();
    }
}
