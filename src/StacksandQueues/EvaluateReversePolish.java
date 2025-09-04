package StacksandQueues;

import java.util.Stack;

// https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
// We are waiting for an operant to come and operate on the numbers, for numbers just push to stack in integer format.
public class EvaluateReversePolish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens){
            if(s.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if(s.equals("-")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first-second);
            }
            else if(s.equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if(s.equals("/")){
                int second = stack.pop();
                int first = stack.pop();
                stack.push(first/second);
            }
            else
                stack.push(Integer.parseInt(s));
        }
        return stack.peek();
    }
}