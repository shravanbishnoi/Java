/*
 * This java package contains Queue implementation
 * Queue is a FIFO Data Structure, First In First Out
 * with all the helper methods
 * 
 * Author: Shravan
 * Date: 01-03-2024
 */
package MyPackages.datastructures;

public class Queue {
    int SIZE = 5;
    int items[] = new int[SIZE];
    int front, rear;

    // Constructor
    public Queue() {
        front = -1;
        rear = -1;
    }


    // check if the queue is full
    public boolean isFull() {
        if (front == 0 && rear == SIZE - 1) {
            return true;
        }
        return false;
    }


    // check if the queue is empty
    public boolean isEmpty() {
        if (front == -1)
            return true;
        else
            return false;
    }


    // insert elements to the queue
    public void enQueue(int element) {
        // if queue is full
        if (isFull()) {
            System.out.println("Queue is full");
        }
        else {
            if (front == -1) {
                // mark front denote first element of queue
                front = 0;
            }
            rear++;
            // insert element at the rear
              items[rear] = element;
            System.out.println("Insert " + element);
        }
    }


    // delete element from the queue
    public int deQueue() {
        int element;
        // if queue is empty
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return (-1);
        }
        else {
            // remove element from the front of queue
            element = items[front];
            // if the queue has only one element
            if (front >= rear) {
                front = -1;
                rear = -1;
            }
            else {
                // mark next element as the front
                front++;
            }
            System.out.println( element + " Deleted");
            return (element);
        }
    }


    // display element of the queue
    public void display() {
        int i;
        if (isEmpty()) {
            System.out.println("Empty Queue");
        }
        else {
            // display the front of the queue
            System.out.println("\nFront index-> " + front);
            // display element of the queue
            System.out.println("Items -> ");
            for (i = front; i <= rear; i++)
                System.out.print(items[i] + " ");
            // display the rear of the queue
            System.out.println("\nRear index-> " + rear);
        }
    }
}