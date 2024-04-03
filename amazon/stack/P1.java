package amazon.stack;

@SuppressWarnings("unused")
public class P1 {
    private class MyStack {
        int top;
        int arr[] = new int[1000];

        MyStack() {
            top = -1;
        }

        void push(int a) {
            arr[++top] = a;
        }

        int pop() {
            if (top == -1)
                return -1;
            return arr[top--];
        }
    }
}
