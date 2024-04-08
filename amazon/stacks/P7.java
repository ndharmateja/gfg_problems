package amazon.stacks;

import java.util.Stack;

public class P7 {
    private static boolean isOperand(char c) {
        return Character.isDigit(c);
    }

    private static int compute(int num1, int num2, char c) {
        if (c == '+')
            return num1 + num2;
        if (c == '*')
            return num1 * num2;
        if (c == '-')
            return num1 - num2;
        // If '/'
        return num1 / num2;
    }

    public static int evaluatePostFix(String s) {
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOperand(c))
                stack.push(c - '0');
            else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                stack.push(compute(num1, num2, c));
            }
        }

        return stack.pop();
    }
}
