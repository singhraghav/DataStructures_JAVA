package com.company.datastrucutures.queue;

public class QueueUsingArray {
    private int data[];
    private int front;
    private int rear;
    private int size;

    public QueueUsingArray(int n){
        data = new int[n];
        front =  -1;
        rear = -1;
        size = 0;
    }

    public int size(){
        return this.size;
    }

    public void enqueue(int element) throws Exception{
        if(size == data.length) throw new Exception("queue full");
        if(this.size == 0)
        {
            front += 1;
        }
        size++;
        rear = (rear + 1) % data.length;
        data[rear] = element;
    }

    public int deque() throws Exception{
        if(size == 0) throw new Exception("Queue Full");
        int temp = data[front];
        front = (front + 1) % data.length;
        size--;
        if(size == 0) {front = -1; rear = -1;}
        return temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }
}
