package microsoft.stacks;

import java.util.Stack;

// TODO
public class P10 {
    private static char[] reverse(String s) {
        char[] chars = new char[s.length()];
        int i = s.length() - 1;
        for (char c : s.toCharArray()) {
            chars[i--] = c;
        }
        return chars;
    }

    // Assumes that the string only contains '(' and ')'
    private static int maxLength(char[] chars) {
        int maxValid = 0;
        int currValid = 0;
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(') {
                stack.add(c);
            } else {
                // If stack is empty
                // we reset curr valid length
                // We don't need to update max valid here as max is updated
                // everytime curr valid length is incremented
                if (stack.size() == 0) {
                    currValid = 0;
                    continue;
                }

                // If stack is not empty it means that it is matching
                // we increment current valid length
                // and immediately update maxValid
                stack.pop();
                maxValid = Integer.max(maxValid, ++currValid);
            }
        }

        // We multiply with 2 because we are counting pairs instead of chars
        return maxValid * 2;
    }

    public static int maxLength(String s) {
        return Integer.min(maxLength(s.toCharArray()), maxLength(reverse(s)));
    }
}
