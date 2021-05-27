package com.company;

import com.company.datastrucutures.stack.StackWithLinkedList;

public class Main {

    public static void main(String[] args) throws Exception {
        StackWithLinkedList<Integer> stack = new StackWithLinkedList();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        while (!stack.isEmpty())
        {
            System.out.println(stack.pop());
        }
    }
}
