package com.company;

import com.company.datastrucutures.queue.QueueUsingArray;

public class Main {

    public static void main(String[] args) throws Exception {
        QueueUsingArray q = new QueueUsingArray(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q);
        q.enqueue(4);
        System.out.println(q);
        while (q.size() != 1)
        {
            q.deque();
        }
        System.out.println(q);
//
        for(int i = 5; i < 10; i++)
            q.enqueue(i);
        System.out.println(q);
        q.enqueue(10);
        System.out.println(q);
        //
//        System.out.println(q);


    }
}
