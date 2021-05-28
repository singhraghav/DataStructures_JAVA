package com.company.datastrucutures.linklist;

public class LinkedListOps<T> {
    Node<T> head;
    private int size;

    public LinkedListOps(){
        head = null;
        size = 0;
    }

    public void addToHead(T element){
        Node<T> data = new Node<T>(element);
        data.next = head;
        head = data;
    }

    public void printList(){
        Node<T> temp = head;
        while (temp != null)
        {
            System.out.println(temp.data+ " ");
            temp = temp.next;
        }
    }
}
