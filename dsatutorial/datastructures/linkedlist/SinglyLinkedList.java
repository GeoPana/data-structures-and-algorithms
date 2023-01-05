package dsatutorial.datastructures.linkedlist;

public class SinglyLinkedList {

    private ListNode head;

    private static class ListNode {
        private int data; //Generally generic type
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void display() {
        ListNode current = this.head;
        while (current != null) {
            System.out.print(current.data + " --> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int length() {
        int length = 0;
        ListNode current = this.head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        this.head = newNode;
    }

    public void insertAt(int index, int value) {
        if (index == 0) {
            this.insertFirst(value);
            return;
        }
        ListNode newNode = new ListNode(value);
        ListNode current = this.head;
        if (current == null) {
            System.out.println("Out of boundaries. ");
            return;
        }
        for (int i = 0; i < index - 1; i++) {
            if (current.next == null) {
                System.out.println("Out of boundaries. "); //better implement using this.length() out of the for loop, in the beginning of the method
                return;
            }

            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void insertLast(int value) {
        if (this.head == null) {
            this.head = new ListNode(value);
            return;
        }
        ListNode current = this.head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = new ListNode(value);
    }

    public ListNode deleteFirst() {
        if (this.head == null) {
            System.out.println("Nothing to delete. ");
            return null;
        }
        ListNode temp = this.head;
        this.head = temp.next;
        temp.next = null;
        return temp;
    }

    public ListNode deleteAt(int index) {
        if (index >= 0 && index <= this.length() - 1) {
            if (index == 0) {
                return this.deleteFirst();
            }

            ListNode current = this.head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = null;
            return temp;
        } else {
            System.out.println("Out of boundaries. ");
            return null;
        }
    }

    public ListNode deleteLast() {
        if (this.head == null) {
            System.out.println("Nothing to delete. ");
            return null;
        }
        ListNode current = this.head;
        if (current.next == null) {
            this.head = null;
            return current;
        } else {
            for (int i = 0; i < this.length() - 2; i++) {
                current = current.next;
            }
            ListNode removed = current.next;
            current.next = null;
            return removed;
        }
    }

    public boolean find(int searchKey) {
        if (this.head == null)
            return false;

        ListNode current = this.head;
        while (current != null) {
            if (current.data == searchKey)
                return true;
            current = current.next;
        }
        return false;
    }

    //Returns new head
    public ListNode reverseSingleList() {

        ListNode current = this.head;
        ListNode next = null;
        ListNode previous = null;

        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public ListNode getMiddleNode() {

        if (this.head == null || this.head.next == null)
            return this.head;

        //2nd solution
        //ListNode slowPtr = this.head;
        //ListNode fastPtr = this.head;
        //while (fastPtr != null && fastPtr.next != null) {
        //    slowPtr = slowPtr.next;
        //    fastPtr = fastPtr.next.next;
        //}
        //return slowPtr;

        int index = this.length() / 2;
        ListNode current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public ListNode getNthNodeFromEnd(int n) {
            /*if (n > 0 && n <= this.length()) {
                ListNode current = this.head;
                for (int i = 0; i < this.length() - n; i++) {
                    current = current.next;
                }
                return current;
            } else {
                System.out.println("Out of boundaries. ");
                return null;
            }*/
        if (this.head == null)
            return null;

        if(n <= 0)
            throw new IllegalArgumentException("Invalid value: n = " + n);

        ListNode mainPtr = this.head;
        ListNode reffPtr = this.head;
        int count = 0;

        while (count < n) {
            if (reffPtr == null)
                throw new IllegalArgumentException(n + " is greater than number of nodes in list. ");
            reffPtr = reffPtr.next;
            count++;
        }

        while (reffPtr != null) {
            reffPtr = reffPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr;
    }

    public void removeDuplicates() {

        if (this.head == null)
            return;

        ListNode current = this.head;

        while (current.next != null) {
            if (current.data == current.next.data) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
    }

    public void insertInSortedList(int value) {

        ListNode newNode = new ListNode(value);

        if (this.head == null)
            this.head = newNode;

        ListNode current = this.head;

        if (this.head.data > value) {
            newNode.next = this.head;
            this.head = newNode;
        } else {
            while (current != null) {
                if ( current.next == null || current.next.data >= value) {
                    newNode.next = current.next;
                    current.next = newNode;
                    return;
                }
                current = current.next;
            }
        }

    }

    public void deleteNode(int key) {

        if (this.head == null) {
            System.out.println("Nothing to remove. ");
            return;
        }

        if (this.head.data == key) {
            ListNode temp = this.head;
            this.head = temp.next;
            return;
        }

        ListNode current = this.head;
        ListNode temp = null;

        while (current != null && current.data != key) {
            temp = current;
            current = current.next;
        }

        if (current == null) {
            System.out.println("Key not found. ");
            return;
        }

        temp.next = current.next;

    }

    public boolean containsLoop() {
        if (this.head == null)
            return false;

        ListNode slowPtr = this.head;
        ListNode fastPtr = this.head;

        while (fastPtr != null  && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr)
                return true;
        }
        return false;
    }

    public ListNode getStartOfLoop() {
        if (this.head == null)
            return null;

        ListNode slowPtr = this.head;
        ListNode fastPtr = this.head;

        while (fastPtr != null  && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr)
                return this.getStartingNode(slowPtr);
        }
        return null;
    }

    public ListNode getStartingNode(ListNode slowPtr) {
        ListNode temp = this.head;
        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp;
    }

    public void removeLoop() {
        ListNode slowPtr = this.head;
        ListNode fastPtr = this.head;
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if (slowPtr == fastPtr) {
                ListNode temp = this.head;
                while (temp.next != slowPtr.next) {
                    temp = temp.next;
                    slowPtr = slowPtr.next;
                }
                slowPtr.next = null;
                return;
            }
        }
    }

//second implementation
//    public void removeLoop() {
//        if (this.containsLoop() == false)
//            return;
//
//        ListNode startLoopNode = this.getStartOfLoop();
//
//        ListNode current = startLoopNode;
//
//        while (current.next != startLoopNode) {
//            current = current.next;
//        }
//        current.next = null;
//    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode finalHead = null;

        if (list1.data < list2.data) {
            finalHead = list1;
            list1 = list1.next;
        }else {
            finalHead = list2;
            list2 = list2.next;
        }

        ListNode tail = finalHead;

        while (list1 != null && list2 != null) {
            if (list1.data <= list2.data) {
                tail.next = list1;
                list1 = list1.next;
            }else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }

        if (list1 == null)
            tail.next = list2;
        else
            tail.next = list1;

        return finalHead;

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while (l1 != null || l2 != null) {

            int x = (l1 != null) ? l1.data : 0;
            int y = (l2 != null) ? l2.data : 0;

            int sum = x + y + carry;
            tail.next = new ListNode(sum % 10);
            carry = sum / 10;

            tail = tail.next;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }

        if (carry > 0)
            tail.next = new ListNode(carry);

        return dummy.next;

    }

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//
//        int hold;
//        ListNode result = new ListNode((l1.data + l2.data) % 10);;
//        ListNode tail;
//
//        if (l1.data + l2.data > 9) {
//            hold = 1;
//        }else {
//            hold = 0;
//        }
//        tail = result;
//
//        l1 = l1.next;
//        l2 = l2.next;
//
//        while (l1 != null && l2 != null) {
//
//            tail.next = new ListNode((l1.data + l2.data + hold) % 10);
//
//            if (l1.data + l2.data + hold > 9) {
//                hold = 1;
//            }else {
//                hold = 0;
//            }
//            l1 = l1.next;
//            l2 = l2.next;
//            tail = tail.next;
//        }
//
//        if (l1 == null) {
//            while (l2 != null) {
//
//                tail.next = new ListNode((l2.data + hold) % 10);
//
//                if (l1.data + hold > 9)
//                    hold = 1;
//                else
//                    hold = 0;
//
//                l2 = l2.next;
//                tail = tail.next;
//            }
//        }else {  //l2 == null
//            while (l1 != null) {
//
//                tail.next =new ListNode((l1.data + hold) % 10);
//
//                if (l1.data + hold > 9)
//                    hold = 1;
//                else
//                    hold = 0;
//
//                l1 = l1.next;
//                tail = tail.next;
//            }
//        }
//
//        if (hold == 1) {
//            tail.next = new ListNode(hold);
//        }
//
//        return result;
//    }


    public static void main(String[] args) {

//        SinglyLinkedList sll = new SinglyLinkedList();
//        sll.insertLast(1);
//        sll.insertLast(3);
//        sll.insertLast(4);
//        sll.insertLast(7);
//        sll.insertLast(10);
//        sll.display();
//
//        ListNode current = sll.head;
//        while (current.next != null) {
//            current = current.next;
//        }
//        current.next = sll.head.next.next;
//
//        System.out.println(sll.containsLoop());
//        System.out.println(sll.getStartOfLoop().data);
//
//        sll.removeLoop();
//        System.out.println(sll.containsLoop());
//        sll.display();

    //Merge Two Single Linked Lists
//        SinglyLinkedList sll1 = new SinglyLinkedList();
//        sll1.insertLast(1);
//        sll1.insertLast(2);
//        sll1.insertLast(4);
//
//        SinglyLinkedList sll2 = new SinglyLinkedList();
//        sll2.insertLast(1);
//        sll2.insertLast(3);
//        sll2.insertLast(4);
//
//        sll1.display();
//        sll2.display();
//
//        SinglyLinkedList mergedSll = new SinglyLinkedList();
//        mergedSll.head = SinglyLinkedList.mergeTwoLists(sll1.head, sll2.head);
//
//        mergedSll.display();

        //Add Two Numbers - LeetCode #2
        SinglyLinkedList sll1 = new SinglyLinkedList();
        sll1.insertLast(9);
        sll1.insertLast(9);
        sll1.insertLast(9);
        sll1.insertLast(9);
        sll1.insertLast(9);
        sll1.insertLast(9);
        sll1.insertLast(9);


        SinglyLinkedList sll2 = new SinglyLinkedList();
        sll2.insertLast(9);
        sll2.insertLast(9);
        sll2.insertLast(9);
        sll2.insertLast(9);


        SinglyLinkedList result = new SinglyLinkedList();
        result.head = addTwoNumbers(sll1.head, sll2.head);

        sll1.display();
        sll2.display();
        result.display();



    }
}
