package dsatutorial.datastructures.stack;

import java.util.EmptyStackException;

public class Stack {

    private ListNode top;
    private int length;

    private class ListNode {
        int data;
        ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Stack() {
        this.top = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        if (this.length ==0)
            return true;
        return false;
    }
    public void display() {
        if (this.isEmpty()) {
            System.out.println("null");
            return;
        }
        System.out.print("top --> ");
        ListNode current = this.top;
        while (current != null) {
            System.out.print(current.data + "--> ");
            current = current.next;
        }
        System.out.println("null ");
    }

    public void push(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = this.top;
        this.top = newNode;
        this.length++;
    }

    public int pop() {
        if (this.isEmpty())
            throw new EmptyStackException();
        int temp = this.top.data;
        this.top = this.top.next;
        this.length--;
        return temp;
    }

    public int peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return this.top.data;
    }


    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.display();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.display();

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
        stack.display();
        System.out.println("Peek: " + stack.peek());
    }

}
