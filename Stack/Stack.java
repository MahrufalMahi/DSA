public class Stack {
    private String[] arr; // Array to store stack elements
    private int top; // Index of the top element
    private int capacity; // Maximum size of the stack

    // Constructor to initialize the stack
    public Stack(int size) {
        arr = new String[size];
        capacity = size;
        top = -1; // Stack is initially empty
    }

    // Method to push data onto the stack
    public void push(String data) {
        if (top == capacity - 1) {
            System.out.println("Stack is full");
            return;
        }
        top++;
        arr[top] = data; // Add the new data to the top of the stack
    }

    // Method to pop data from the stack
    public void pop() {
        if (top == -1) {
            System.out.println("Stack is already empty!");
            return;
        }
        arr[top] = null; // Clear the reference
        top--; // Decrease the top index
    }

    // Method to peek at the top data of the stack
    public String peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
            return null;
        }
        return arr[top]; // Return the top element
    }

    // Main method for testing
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Create a stack of capacity 5

        stack.push("A"); // Push A
        stack.push("B"); // Push B
        stack.push("C"); // Push C
        
        // Test outputs
        System.out.println("Top element is: " + stack.peek()); // Expected output: C
        stack.pop(); // Pop C
        System.out.println("Top element is: " + stack.peek()); // Expected output: B
    }
}
