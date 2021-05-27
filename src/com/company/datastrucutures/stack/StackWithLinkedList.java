package com.company.datastrucutures.stack;

import java.util.LinkedList;

public class StackWithLinkedList<T> {
    private LinkedList<T> list;

    public StackWithLinkedList(){
        list = new LinkedList<>();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public T top() throws Exception {
        if(list.isEmpty())
            throw new Exception("No TOP for empty List");
        return list.get(0);
    }

    public void push(T element){
        list.add(0, element);
    }

    public T pop() throws Exception{
        if(list.isEmpty())
            throw new Exception("Cannot Pop from empty list");
        return list.removeFirst();
    }
}
