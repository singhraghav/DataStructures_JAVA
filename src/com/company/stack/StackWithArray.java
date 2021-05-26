package com.company.stack;

public class StackWithArray {
    private int[] data;
    private int top;

    public StackWithArray(){
        data = new int[10];
        top = -1;
    }

    public StackWithArray(int size){
        data = new int[size];
        top = -1;
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size(){
        return top + 1;
    }

    public int top() throws Exception {
        if(top == -1)
            throw new Exception("No top exist for empty Stack");
        return data[top];
    }

    public void push(int element) {
        if(top == data.length - 1){
           int[] temp = new int[data.length * 2];
           for(int i = 0 ; i < data.length; i++)
               temp[i] = data[i];
           data = temp;
        }
        top++;
        data[top] = element;
    }

    public int pop() throws Exception{
        if(top == -1)
            throw new Exception("Cannot Pop from Empty stack");
        int element = data[top];
        top--;
        return element;
    }
}
