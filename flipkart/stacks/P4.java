package flipkart.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class P4 {
    private static boolean isOpening(char c) {
        return c == '(' || c == '[' || c == '{';
    }

    private static boolean isClosing(char c) {
        return c == ')' || c == ']' || c == '}';
    }

    // Eg
    // After ((( has been seen
    // Count: 3
    // Arraylist: 1 2 3
    // Stack: 1 2 3
    //
    // Now )
    // Count: 3
    // Arraylist: 1 2 3 3
    // Stack: 1 2
    //
    // Now (
    // Count 4
    // Arraylist: 1 2 3 3 4
    // Stack: 1 2 4
    //
    // Now )
    // Count: 4
    // Arraylist: 1 2 3 3 4 4
    // Stack: 1 2
    //
    // Now: ))
    // Count 4
    // Arraylist: 1 2 3 3 4 4 2 1
    // Stack: <empty>
    public static ArrayList<Integer> printBracketNumber(String s) {
        int count = 0;
        ArrayList<Integer> out = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpening(c)) {
                out.add(++count);
                stack.push(count);
            } else if (isClosing(c)) {
                out.add(stack.pop());
            }
        }
        return out;
    }
}
