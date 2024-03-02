/*
 * Here is the Package containing implementation of Singly Linked List
 * using a Node as base structure
 * 
 * Author: Shravan
 * Date: 01-03-2024
 */
package MyPackages.datastructures;

/**
 * LinkedList
 */
public class LinkedList {
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

    public void addFirst(int data) {
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

    public void addLast(int data) {
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

    public void addAtPos(int data, int pos) {
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

    public void deleteFirst() {
        if (head == null) {
            System.out.println("LinkedList is empty");
        } else {
            head = head.next;
            this.size--;
        }
    }

    public void deleteLast() {
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

    public void show() {
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

    public int getSize() {
        return this.size;
    }
}
