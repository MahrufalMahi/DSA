package Queue;

public class Queue_Array {

    int size;
    int[] arr;
    int front;
    int back;

    public Queue_Array(int size){

        this.size = size;
        this.arr = new int[size];
        this.front = -1;
        this.back = -1;
    }

    public boolean isFull(){

        if(this.back == size - 1){

            return true;
        }

        return false;
    }

    public boolean isEmpty(){

        if(this.back == -1){

            return true;

        }
        return false;
    }

    public void add(int data){

        if(isFull()){

            System.out.println("Queue is full");
            return;
        }

        if(this.back == -1 && this.front == -1){

            this.front++;
            this.back++;
            this.arr[this.back] = data;
            return;
        }

        this.back++;
        this.arr[this.back] = data;

    }

    public void remove(){
        if(isEmpty()){

            System.out.println("Queue already empty");
            return;
        }

        for(int i = 0; i < this.back; i++){

            this.arr[i] = this.arr[i+1];
        }
        this.back--;
        if (this.back == -1) {
            this.front = -1;
        }
    }

    public void peek(){

        if(isEmpty()){
            System.out.println("Queue is empty");
            return;
        }

        for(int i = 0; i <= this.back; i++){

            System.out.println("Element at " + " index" + i + " is " + this.arr[i]);
        }
    }

    
    
}
