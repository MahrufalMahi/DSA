/* package Stack;
 */
public class Stack_LinkedList {

    Node head;
    int size;
    public class Node{
    
        String data;
        Node next;

        public Node(String data){

            this.data = data;
            this.next = null;
        }
    }

    public Stack_LinkedList(){

        head = null; 
        size = 0;

    }

    public void push(String data){

        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void pop(){

        if(head == null){
            System.out.println("Stack already empty");
            return;
        }
        head = head.next;
        size--;
    }

    public String peek(){

        if(head == null){
            System.out.println("Stack is empty");
            return null;
        }

        return head.data;
    }

    public static void main(String[] args) {
        Stack_LinkedList stack = new Stack_LinkedList();
    
        // Test pushing elements onto the stack
        System.out.println("Pushing elements onto the stack:");
        stack.push("A");
        stack.push("B");
        stack.push("C");
    
        // Test peek
        System.out.println("Top element (peek): " + stack.peek()); // Expected: C
    
        // Test popping elements from the stack
        System.out.println("Popping elements from the stack:");
        stack.pop();
        System.out.println("Top element after pop (peek): " + stack.peek()); // Expected: B
        stack.pop();
        System.out.println("Top element after another pop (peek): " + stack.peek()); // Expected: A
        stack.pop();
        System.out.println("Trying to pop from empty stack:");
        stack.pop(); // Expected: Stack already empty
    
        // Test peek on empty stack
        System.out.println("Peek on empty stack: " + stack.peek()); // Expected: Stack is empty, null
    }
    


    
}
