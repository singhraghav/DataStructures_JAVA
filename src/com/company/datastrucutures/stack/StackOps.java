package com.company.datastrucutures.stack;

import java.util.Stack;

public class StackOps {
    public static Stack<Integer> reverse(Stack<Integer> stack){
        if(stack.size() <= 1)
            return stack;
        Integer top = stack.pop();
        Stack<Integer> partialSolution = reverse(stack);
        Stack<Integer> temp = new Stack<Integer>();
        while (!partialSolution.isEmpty()){
            temp.push(partialSolution.pop());
        }
        partialSolution.push(top);
        while (!temp.isEmpty())
        {
            partialSolution.push(temp.pop());
        }
        return partialSolution;
    }
}
