package dsatutorial.codinginterviwqestions;

import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreaterElement(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && arr[i] >= stack.peek())
                    stack.pop();
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            }else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[] {4, 7, 3, 4, 8, 1};
        int[] result = nextGreaterElement(array);
        for (int item : result) {
            System.out.print(item + " ");
        }
    }

}
