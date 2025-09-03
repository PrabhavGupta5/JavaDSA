package StacksandQueues;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/description/
public class ImplementQueusingSt {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x);

    }

    public int pop() {
        peek();
        return output.pop();

    }

    public int peek() {
        if(output.isEmpty()){
            while(!input.isEmpty())
                output.push(input.pop());

        }
        return output.peek();
    }

    public boolean empty() {
        return output.isEmpty() && input.isEmpty();
    }
}
