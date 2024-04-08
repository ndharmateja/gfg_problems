package flipkart.stacks;

import java.util.Stack;

@SuppressWarnings("unused")
public class P8 {
    /**
     * Moves top k elements from st1 to st2 one by one
     * Eg:
     * st1: 3 2 1 -> top
     * st2: <empty>
     * moveElements(st1, st2, 2) will result
     * st1: 3 -> top
     * st2: 1 2 -> top
     * 
     * @param st1
     * @param st2
     * @param k
     */
    private void moveTopKElements(Stack<Integer> st1, Stack<Integer> st2, int k) {
        for (int i = 0; i < k; i++) {
            st2.push(st1.pop());
        }
    }

    // O(n^2) time and O(1) space
    private void solution2(Stack<Integer> st, Stack<Integer> cloned) {
        int numCloned = 0;
        int numElements = st.size();

        while (numCloned < numElements) {
            // Move top numCloned elements from st and put in cloned
            moveTopKElements(st, cloned, numCloned);

            // Clone the top element
            int clone = st.peek();

            // Move the top numCloned elements back from cloned to st
            moveTopKElements(cloned, st, numCloned);

            // At this point st will be in its original state
            // and cloned will have numCloned cloned elements
            // Move the numCloned elements from cloned to st
            // and insert the clone
            // and move them back
            moveTopKElements(cloned, st, numCloned);
            cloned.push(clone);
            moveTopKElements(st, cloned, numCloned);

            // Increment numCloned
            numCloned++;
        }
    }

    // Recursive solution
    // O(n) time and O(n) space complexities
    private void solution1(Stack<Integer> st, Stack<Integer> cloned) {
        assert (cloned.isEmpty());

        // If stack is empty return
        if (st.isEmpty())
            return;

        // If stack is not empty
        // remove the top element, clone the remaining part of the stack recursively
        // and the add the top element and its clone respectively
        int top = st.pop();
        solution1(st, cloned);
        st.push(top);
        cloned.push(top);
    }

    public void clonestack(Stack<Integer> st, Stack<Integer> cloned) {
        solution2(st, cloned);
    }

    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(3);
        s.push(2);
        s.push(1);
        System.out.println(s);

        Stack<Integer> clone = new Stack<>();
        new P8().clonestack(s, clone);
        System.out.println(clone);
    }
}
