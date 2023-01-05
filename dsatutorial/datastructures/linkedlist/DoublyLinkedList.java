package dsatutorial.datastructures.linkedlist;

import java.util.NoSuchElementException;

public class DoublyLinkedList {

    private ListNode head;
    private ListNode tail;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public int length() {
        return length;
    }

    public void displayForward() {

        if (this.head == null) {
            System.out.println("null");
            return;
        }

        ListNode temp = this.head;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        if (this.tail == null) {
            System.out.println("null");
            return;
        }
        ListNode temp = this.tail;
        while (temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.previous;
        }
        System.out.println("null");
    }

    public void insertFront(int value) {

        if (isEmpty()) {
            this.head = new ListNode(value);
            this.tail = this.head;
            this.length++;
            return;
        }
        //ListNode newNode = new ListNode(value);
        this.head.previous = new ListNode(value);
        this.head.previous.next = this.head;
        this.head = this.head.previous;
        this.length++;

    }

    public void insertLast(int value) {

        ListNode newNode = new ListNode(value);

        if (isEmpty()) {
            this.head = newNode;
        }else {
            this.tail.next = newNode;
            newNode.previous = this.tail;
        }
        this.tail = newNode;
        length++;
    }

    public ListNode removeFirst() {

        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        ListNode temp = this.head;
        if (this.head == this.tail) {
            this.tail = null;
            this.head = null;
        }else {
            this.head = this.head.next;
            this.head.previous = null;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public ListNode removeLast() {

        if (isEmpty())
            throw new NoSuchElementException();

        ListNode temp = this.tail;

        if (this.head == this.tail) {
            this.head = null;
            this.tail = null;
        }else {
            this.tail.previous.next = null;
            this.tail = this.tail.previous;
            temp.previous = null;
        }
        length--;
        return temp;
    }


    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertLast(1);
        dll.insertLast(2);
        dll.insertLast(3);
         dll.insertLast(4);
        dll.displayForward();
        dll.displayBackward();

        System.out.println(dll.removeLast().data);
        System.out.println(dll.removeLast().data);
        //System.out.println(dll.removeLast().data);
        //System.out.println(dll.removeLast().data);
        //System.out.println(dll.removeLast().data);

        dll.displayForward();
        dll.displayBackward();
    }



}
