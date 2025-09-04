package StacksandQueues;

import java.util.Stack;

// https://www.youtube.com/watch?v=ekFs9Nb2RNQ

// WE are taking help of a helper stack and traversing from right to left and storing indices in the stack
// and checking the value in the stack to be lower than the element in the temperature array

// https://leetcode.com/problems/daily-temperatures/

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i = n-1; i>=0; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i])
                stack.pop();
            answer[i] = stack.isEmpty() ? 0 : stack.peek() - i;
            stack.push(i);

        }
        return answer;
    }
}