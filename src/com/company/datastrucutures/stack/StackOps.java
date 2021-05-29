package com.company.datastrucutures.stack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
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

    public static boolean containsRedundantBracket(String s){
        Stack<Character> brackets = new Stack<>();

        Character[] ops = {'*', '+', '-', '/'};
        Set<Character> operatorSet = new HashSet<>(Arrays.asList(ops));

        for(int i = 0 ; i < s.length(); i++)
        {   char currentElement = s.charAt(i);
            if(currentElement == '(' || operatorSet.contains(currentElement))
                brackets.push(currentElement);

            if(currentElement == ')')
            {
                boolean isRedundant = true;

                while(brackets.peek() != '(')
                {
                    Character top = brackets.peek();
                    if(operatorSet.contains(top))
                        isRedundant = false;
                    brackets.pop();
                }
                brackets.pop();
                if (isRedundant) return true;
            }
        }
        return false;
    }
}
