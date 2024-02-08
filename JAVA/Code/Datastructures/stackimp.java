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

class Stack {
    private int[] array;
    private int top;
    private int capacity;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top = 0;
    }

    public void push(int value) {
        if (top == capacity) {
            resizeAndCopy();
        }
        array[top++] = value;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!!");
            return -1;
        }
        return array[--top];
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty!!");
            return -1;
        }
        return array[top - 1];
    }

    public int size() {
        return top;
    }

    public boolean isEmpty() {
        return top == 0;
    }

    private void resizeAndCopy() {
        int newCapacity = capacity * 2;
        int[] newArray = new int[newCapacity];
        System.arraycopy(array, 0, newArray, 0, capacity);
        array = newArray;
        capacity = newCapacity;
    }
}
