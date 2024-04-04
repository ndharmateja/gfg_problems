package amazon.stack;

public class P3 {
    class twoStacks {
        int[] array = new int[200];
        int top1 = 0;
        int top2 = 100;

        twoStacks() {
        }

        // Function to push an integer into the stack1.
        void push1(int x) {
            array[top1++] = x;
        }

        // Function to push an integer into the stack2.
        void push2(int x) {
            array[top2++] = x;
        }

        // Function to remove an element from top of the stack1.
        int pop1() {
            if (top1 == 0)
                return -1;
            return array[--top1];
        }

        // Function to remove an element from top of the stack2.
        int pop2() {
            if (top2 == 100)
                return -1;
            return array[--top2];
        }
    }
}
