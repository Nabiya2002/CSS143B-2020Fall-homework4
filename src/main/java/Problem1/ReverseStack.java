package Problem1;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> stack) {
        if (stack.empty()) {
            return;
        }

        int n = stack.pop();
        reverseStack(stack);

        reverseStackHelper(stack, n);
    }

    private static void reverseStackHelper(Stack<Integer> stack, int n) {
        if (stack.size() == 0) {
            stack.push(n);
            return;
        }

        int m = stack.pop();
        reverseStackHelper(stack, n);
        stack.push(m);
    }
}