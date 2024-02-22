import java.util.Stack;

public class MinStack {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println("Underflow Error");
            return;
        }
        int poppedValue = stack.pop();
        if (minStack.peek().equals(poppedValue)) {
            minStack.pop();
        }
    }

    public Integer top() {
        if (stack.isEmpty()) {
            System.out.println("Underflow Error");
            return null;
        }
        return stack.peek();
    }

    public Integer getMin() {
        if (minStack.isEmpty()) {
            System.out.println("Underflow Error");
            return null;
        }
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println("Minimum element of Stack : "+minStack.getMin());  // returns -3
        minStack.pop();
        System.out.println("Top element after removing minelement: "+minStack.top());     // returns 0
        System.out.println("Now min element of stack is : "+minStack.getMin());  // returns -2
    }
}
