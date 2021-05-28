package com.company.datastrucutures.queue;

import java.util.Arrays;

public class QueueUsingArray {
    private int[] data;
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

    public void enqueue(int element){
        if(size == data.length)
            doubleCapacity();
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

    private void doubleCapacity(){
        int[] temp = new int[data.length * 2];
        int index = 0;
        for(int i = front; i != rear; i = (i + 1) % data.length)
        {
            temp[index++] = data[i];
        }
        temp[index++] = data[rear];
        data = temp;
        front = 0;
        rear = index - 1;
    }

    @Override
    public String toString() {
        return "QueueUsingArray{" +
                "data=" + Arrays.toString(data) +
                ", front=" + front +
                ", rear=" + rear +
                ", size=" + size +
                '}';
    }
}
