package com.company;

import com.company.stack.StackWithArray;

public class Main {

    public static void main(String[] args) throws Exception {
        StackWithArray stack = new StackWithArray(2);

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
