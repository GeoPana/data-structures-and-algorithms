package dsatutorial.codinginterviwqestions;

import java.util.Stack;

public class ValidParenthesis {

    public static boolean ValidParenthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            }else {
                if (stack.isEmpty()) {
                    return false;
                }else {
                    char top = stack.peek();
                    if ((c == ')' && top == '(') ||
                            (c == ']' && top == '[') ||
                            (c == '}' && top == '{')) {
                        stack.pop();
                    }else {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String str = "{([])}";
        if (ValidParenthesis(str))
            System.out.println("Valid.");
        else
            System.out.println("Not Valid.");
    }

}
