/*
 * This java file contains Stack implementation
 * Stack is a LIFO Data Structure, Last In First Out
 * with all the helper methods
 * 
 * Author: Shravan
 * Date: 08-02-2024
 */

// Main class
public class stackimp {
    public static void main(String[] args) {
        Stack stack = new Stack(10);

        stack.push(5);
        stack.push(10);
        stack.push(15);

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Stack size: " + stack.size());
    }
}


// Stack implementation class
class Stack {
    // Initializing required variables
    private int[] array;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top = 0;
    }

    // Method to add an element to stack
    public void push(int value) {
        if (top == capacity) {
            // Resizing the array if it is full
            resizeAndCopy();
        }
        array[top++] = value;
    }

    // Method to remove an element to from stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!!");
            return -1;
        }
        return array[--top];
    }

    // Method to get the current top element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!!");
            return -1;
        }
        return array[top - 1];
    }

    // Method to get size
    public int size() {
        return top;
    }

    // Method to check if the stack is empty or not
    public boolean isEmpty() {
        return top == 0;
    }

    // Method to resize the underlying array
    private void resizeAndCopy() {
        // Taking twice the old array 
        int newCapacity = capacity * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, capacity);
        array = newArray;
        capacity = newCapacity;
    }
}
