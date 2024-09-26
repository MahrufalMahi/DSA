package Queue;

public class Queue_LinkedList {

    public int size = 0;
    public Node head; 
    public Node back;
   

    public class Node{

        String data;
        Node next;

        public Node(String data){

            this.data = data;
            this.next = null;
        }
    }

    public int length(){

        return this.size;
    }

    public boolean isEmpty(){

        return this.head == null;
    }

    public void enqueueLast(String data){

        Node newNode = new Node(data);

        if(this.head == null){
            
            this.head = newNode;
            this.back = this.head;
            this.size++;
            return;

        }

        this.back.next = newNode;
        this.back = this.back.next;
        this.size++;
    }

    public void dequeueFirst(){

        if(isEmpty()){
            System.out.println("Queue is already empty");
            return;
        }

        this.head = this.head.next;
        this.size--;

        if(this.head == null){
            this.back = null;
        }
    }

    public void enqueueFirst(String data){

        Node newNode = new Node(data);

        if(this.head == null){

            this.head = newNode;
            this.back = this.head;
            this.size++;
            return;
        }

        Node temp = this.head;
        this.head = newNode;
        this.head.next = temp;
        this.size++;
    }

    public void dequeueLast(){

        if(isEmpty()){

            System.out.println("Queue already empty");
            return;
        }

        if(this.head == this.back){

            this.head = null;
            this.back = null;
            size--;
            return;
        }

        Node currNode = this.head;

        while (currNode.next != this.back) {
            currNode = currNode.next;

        }

        this.back = currNode;
        this.back.next = null;
        size--;



    }

    
    
}
