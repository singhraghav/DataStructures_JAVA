package com.company.datastrucutures.myPriorityQueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

class MaxPQComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2 - o1;
    }
}

public class InBuiltPriorityQueue {

    public static void sortKSorted(int[] arr, int k){
        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        int i = 0;
        for(; i < k; i++)
            pq.add(arr[i]);
        for(; i < arr.length; i++)
        {
            arr[i-k] = pq.remove();
            pq.add(arr[i]);
        }

        for(int j = arr.length - k; j < arr.length; j++){
            arr[j] = pq.remove();
        }
    }

    public static LinkedList<Integer> KLargestElements(int[] arr, int k) {
        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        int i = 0;
        for(; i < k; i++)
            pq.add(arr[i]);
        for(; i < arr.length; i++)
        {
            if (pq.peek() < arr[i])
            {
                pq.remove();
                pq.add(arr[i]);
            }
        }
        LinkedList<Integer> result = new LinkedList<>();

        while (!pq.isEmpty())
            result.add(pq.remove());
        return  result;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq  = new PriorityQueue<>();
        int[] arr = {9,1,0,4,7,3};
        sortKSorted(arr, 3);
        System.out.println(KLargestElements(arr, 2));
    }
}
