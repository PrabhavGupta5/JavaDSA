package Recursion;

import java.util.Stack;

public class SortAStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(2);
        stack.push(30);
        stack.push(4);


//        stack = [10, 2, 30, 4]
//
//→ sort() called
//    → pop 4, call sort()
//        → pop 30, call sort()
//            → pop 2, call sort()
//                → pop 10, stack.size == 1, return [10]
//            → insert 2 into [10]
//        → insert 30 into [2,10]
//    → insert 4 into [2,10,30]

        stack = sort(stack);

        while (!stack.empty()) {
            int element = stack.pop();
            System.out.print(element+"->");
        }
    }
    private static Stack<Integer> sort(Stack<Integer> stack){
        if(stack.size()==1){
            return stack;  // Okay, this specific recursive call is done — now go back to where you came from.”
        }

        int temp = stack.pop();
        stack = sort(stack);
        stack = insert(stack,temp);
        return stack;
    }

    private static Stack<Integer> insert(Stack<Integer> stack,int temp){

        if(stack.empty()){
            stack.push(temp);
            return stack;
        }
        else if(stack.peek() <= temp){
            stack.push(temp);
            return stack;
        }

        int temp1 = stack.pop();
        stack = insert(stack, temp);
        stack.push(temp1);

        return stack;
    }
}