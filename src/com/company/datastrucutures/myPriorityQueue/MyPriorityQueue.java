package com.company.datastrucutures.myPriorityQueue;

import java.util.ArrayList;

public class MyPriorityQueue {

    private ArrayList<Integer> heap;

    public MyPriorityQueue() {
        heap = new ArrayList<>();
    }

    public boolean isEmpty() { return heap.size() == 0;}

    public int size() {return heap.size();}

    public int getMin() throws Exception {
        if (heap.isEmpty())
            throw new Exception("No element in Empty Heap");
        else
            return heap.get(0);
    }
    public void insert(int element) {
        heap.add(element);
        upwardHeapify(heap.size() - 1);
    }

    public int remove() {
        int answer = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size() - 1);
        downwardHeapify(0);
        return answer;
    }

    void downwardHeapify(int currentIndex) {
        while (currentIndex < heap.size()) {
            int leftChildIndex = currentIndex * 2 + 1;
            int rightChildIndex = currentIndex * 2 + 2;
            if(leftChildIndex >= heap.size() || rightChildIndex >= heap.size())
                return;
            int leftChild = heap.get(leftChildIndex);
            int rightChild = heap.get(rightChildIndex);

            int minimum = Math.min(heap.get(currentIndex), Math.min(leftChild, rightChild));

            if(minimum == leftChild)
            {
                swap(currentIndex, leftChildIndex);
                currentIndex = leftChildIndex;
            }
            else if (minimum == rightChild)
            {
                swap(currentIndex, rightChildIndex);
                currentIndex = rightChildIndex;
            }
        }
    }

    void upwardHeapify(int currentIndex){
        int parentIndex = (currentIndex - 1)/2;
        while(heap.get(currentIndex) < heap.get(parentIndex) && currentIndex > 0)
        {
            swap(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1)/2;
        }
    }

    private void swap(int i, int j){
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void printQueue(){
        System.out.println(heap);
    }
}
