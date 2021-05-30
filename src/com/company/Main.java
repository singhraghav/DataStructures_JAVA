package com.company;

import com.company.datastrucutures.linklist.LinkedListOps;
import com.company.datastrucutures.queue.QueueOps;
import com.company.datastrucutures.queue.QueueUsingArray;
import com.company.datastrucutures.stack.StackOps;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws Exception {
        Queue<Integer> qu = new LinkedList<>();
        qu.add(10);
        qu.add(20);
        qu.add(30);
        qu.add(40);
        System.out.println(qu);
        System.out.println(QueueOps.reverse(qu));
        System.out.println(StackOps.containsRedundantBracket("(a+b)"));
        System.out.println(StackOps.containsRedundantBracket("(a+c*b)+(c))"));

    }
}
