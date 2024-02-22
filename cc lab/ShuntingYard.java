import java.util.*;

public class ShuntingYard {
    private static final String OPERATORS = "+-*/^";
    private static final int[] PRECEDENCE = {1, 1, 2, 2, 3};

    private static boolean isOperator(char c) {
        return OPERATORS.indexOf(c) != -1;
    }

    private static int precedence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }

    public static String infixToPostfix(String infix) {
        StringBuilder postfix = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : infix.toCharArray()) {
            if (isOperator(c)) {
                while (!stack.isEmpty() && isOperator(stack.peek()) && precedence(c) <= precedence(stack.peek())) {
                    postfix.append(stack.pop());
                }
                stack.push(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                }
                stack.pop();
            } else {
                postfix.append(c);
            }
        }

        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
        }

        return postfix.toString();
    }

    public static void main(String[] args) {
        System.out.println("Postfix expression of given infix expression : "+infixToPostfix("3+4*2/(1-5)^2"));
    }
}
