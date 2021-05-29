package com.company;

import com.company.datastrucutures.linklist.LinkedListOps;
import com.company.datastrucutures.queue.QueueOps;
import com.company.datastrucutures.queue.QueueUsingArray;
import com.company.datastrucutures.stack.StackOps;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
//        QueueUsingArray q = new QueueUsingArray(3);
//        q.enqueue(1);
//        q.enqueue(2);
//        q.enqueue(3);
//        System.out.println(q);
//        q.enqueue(4);
//        System.out.println(q);
//        while (q.size() != 1)
//        {
//            q.deque();
//        }
//        System.out.println(q);
////
//        for(int i = 5; i < 10; i++)
//            q.enqueue(i);
//        System.out.println(q);
//        q.enqueue(10);
//        System.out.println(q);
//        //
////        System.out.println(q);
//        LinkedListOps<Integer> l = new LinkedListOps<>();
//        l.addToHead(10);
//        l.addToHead(20);
//        l.printList();
        Queue<Integer> qu = new LinkedList<>();
        qu.add(10);
        qu.add(20);
        qu.add(30);
        qu.add(40);

        System.out.println(StackOps.containsRedundantBracket("(a+b)"));
        System.out.println(StackOps.containsRedundantBracket("(a+c*b)+(c))"));

    }
}
