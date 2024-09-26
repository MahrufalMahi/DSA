package Queue;

public class Circular_Queue_Array {

    int size;
    String [] arr;
    int front;
    int back;

    public Circular_Queue_Array(int size){

        this.size = size;
        this.arr = new String[size];
        front= -1;
        back = -1;
    }

    public boolean isEmpty(){

        if(this.front == this.back){
            return true;
        }
        return false;
    }

    public boolean isFull(){

        return (this.back + 1) % this.size == this.front;
    }

    public int capacity(){

        return this.size;
    }

    public void clear(){

        if(isEmpty()){

            System.out.println("Queue is already empty");
            return;
        }

        int i = this.front;
        while (i != this.back) {
            
            this.arr[i] = null;
            i = (i+1) % this.size;
        }
        this.arr[this.back] = null;

        this.front = -1;
        this.back = -1;
    }

    public void enqueue(String elem){

        if(isFull()){

            System.out.println("Queue is already full");
            return;
        }
        this.back = (this.back + 1) % this.size;
        this.arr[this.back] = elem;
        if(this.front == -1){

            this.front++;
        }
    }

    public void dequeue(){

        if(isEmpty()){
            System.out.println("Queue is already empty!");
            return;
        }

        this.arr[this.front] = null;
        this.front = (this.front + 1) % this.size;

        if(isEmpty()){
            
            this.front = -1;
            this.back = -1;
        }
    }
    
}
