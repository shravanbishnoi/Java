/*
 * Here is the implementation of Singly Linked List
 * using a Node as base structure
 * 
 * Author: Shravan
 * Date: 20-02-2024
 */


public class SinglyLinkedList {
    public static void main(String[] args) {
        LinkedList s = new LinkedList();
        s.show();
        for (int i = 1; i < 3; i++) {
            s.addFirst(i);
        }
        s.show();
        s.addLast(4);
        s.show();
        System.out.println("Size of Linked List is: " + s.getSize());
        s.deleteFirst();
        s.show();
        System.out.println("Size of Linked List is: " + s.getSize());

        s.deleteLast();
        s.show();
        System.out.println("Size of Linked List is: " + s.getSize());

        s.addAtPos(7, 1);
        s.show();
        System.out.println("Size of Linked List is: " + s.getSize());
    }
}

/**
 * LinkedList
 */
class LinkedList {
    Node head;
    int size;

    /**
     * Node
     */
    public class Node {
        int data;
        Node next;

        // Constructor
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    void addFirst(int data) {
        Node newNode = new Node(data);

        System.out.println("Adding at first: " + newNode.data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        this.size++;
    }

    void addLast(int data) {
        Node newNode = new Node(data);
        System.out.println("Adding at last: " + newNode.data);

        if (head == null) {
            head = newNode;
        } else {
            Node tempNode = head;
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        this.size++;
    }

    void addAtPos(int data, int pos) {
        Node newNode = new Node(data);
        System.out.println("Adding at given position: " + newNode.data);

        if (head == null && pos == 0) {
            head = newNode;
        } else {
            Node curNode = head;
            int count = 0;
            while (count < pos - 1 && curNode.next != null) {
                curNode = curNode.next;
                count++;
            }
            newNode.next = curNode.next;
            curNode.next = newNode;
        }
        this.size++;
    }

    void deleteFirst() {
        if (head == null) {
            System.out.println("LinkedList is empty");
        } else {
            head = head.next;
            this.size--;
        }
    }

    void deleteLast() {
        if (head == null) {
            System.out.println("LinkedList is empty");
        } else if (head.next == null) {
            head = head.next;
            this.size--;
        } else {
            Node tempNode = head;
            while (tempNode.next.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = null;
            this.size--;
        }
    }

    void show() {
        if (head == null) {
            System.out.println("LinkedList is empty");
        } else {
            Node tempNode = head;
            while (tempNode != null) {
                System.out.print(tempNode.data + " -> ");
                tempNode = tempNode.next;
            }
            System.out.println("null");
        }
    }

    int getSize() {
        return this.size;
    }
}
