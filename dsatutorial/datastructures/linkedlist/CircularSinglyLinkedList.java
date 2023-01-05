package dsatutorial.datastructures.linkedlist;

import java.util.NoSuchElementException;

public class CircularSinglyLinkedList {

    private ListNode last;
    private int length;

    private class ListNode {
        private int data;
        private ListNode next;

        private ListNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        this.last = null;
        this.length = 0;
    }

    public int length() {
        return this.length;
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public void display() {
        if (this.last == null) {
            System.out.println("null");
            return;
        }
        ListNode current = this.last.next;
        while (current != this.last) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println(current.data);

    }

    public void createDefaultCircularLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(10);
        ListNode fourth = new ListNode(15);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;

        this.last = fourth;
    }

    public void insertFirst(int value) {

        ListNode newNode = new ListNode(value);
        if (this.last == null) {
            this.last = newNode;
        }else {
            newNode.next = this.last.next;
        }
        this.last.next = newNode;
        length++;
    }

    public void insertLast(int value) {
        ListNode newNode = new ListNode(value);
        if (this.last == null) { // isEmpty()
            this.last = newNode;
            this.last.next = newNode;
        }else {
            newNode.next = this.last.next;
            this.last.next = newNode;
            this.last = this.last.next;
        }
        length++;
    }

    public ListNode removeFirst() {
        if(this.isEmpty()) {
            throw new NoSuchElementException("Circular Singly Linked List is already empty. ");
        }
        ListNode temp = this.last.next;
        if (this.last.next == this.last) {
            this.last = null;
        }else {
            this.last.next = this.last.next.next;
        }
        temp.next = null;
        length--;
        return temp;
    }

    public static void main(String[] args) {

        //Create Circular Singly Linked List
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.display();

        csll.insertLast(5);
        csll.insertLast(6);
        csll.insertLast(7);
        csll.display();

        System.out.println(csll.removeFirst().data);
        System.out.println(csll.removeFirst().data);
        System.out.println(csll.removeFirst().data);

        csll.display();
    }

}
