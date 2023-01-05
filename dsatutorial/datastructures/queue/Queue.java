package dsatutorial.datastructures.queue;

import java.util.NoSuchElementException;

public class Queue {

    private ListNode front;
    private ListNode rear;
    private int length;

    public Queue() {
        this.front = null;
        this.rear = null;
        this.length = 0;
    }

    private class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

        public void display() {
            if (this.isEmpty()) {
                System.out.println("null");
                return;
            }
            System.out.print("front");
            ListNode current = this.front;
            while (current != null) {
                System.out.print(" --> " + current.data);
                current = current.next;
            }
            System.out.print(" <-- rear\n");
        }

        public int length() {
            return length;
        }

        public boolean isEmpty() {
            return length == 0;
        }

        public void enqueue(int value) {
            ListNode newNode = new ListNode(value);
            if (this.isEmpty()) {
                this.front = newNode;
            }else {
                this.rear.next = newNode;
            }
            this.rear = newNode;
            this.length++;
        }

        public int dequeue() {
            if (this.isEmpty())
                throw new NoSuchElementException("Queue is empty. ");

            int temp = this.front.data;
            this.front = this.front.next;
            if (this.front == null)
                this.rear = null;
            this.length--;
            return temp;
        }

        public int front() {
            if (isEmpty())
                throw new NoSuchElementException("Queue is empty. ");
            return this.front.data;
        }

        public int last() {
            if (isEmpty())
                throw new NoSuchElementException("Queue is Empty. ");
            return this.rear.data;
        }

    public static void main(String[] args) {

        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(4);
        q.enqueue(7);
        q.display();
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
        System.out.println("Dequeue: " + q.dequeue());
        q.display();


    }

}
