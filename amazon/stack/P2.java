package amazon.stack;

public class P2 {
    class StackNode {
        int data;
        StackNode next;

        StackNode(int a) {
            data = a;
            next = null;
        }
    }

    class MyStack {

        StackNode top;

        // Function to push an integer into the stack.
        void push(int a) {
            StackNode newNode = new StackNode(a);
            newNode.next = top;
            top = newNode;
        }

        // Function to remove an item from top of the stack.
        int pop() {
            if (top == null)
                return -1;
            StackNode popped = top;
            top = top.next;
            return popped.data;
        }
    }
}
