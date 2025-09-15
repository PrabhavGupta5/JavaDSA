package Recursion;

import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);

        st = reverse(st);

        while(!st.isEmpty()){
            System.out.print(st.pop() + "->");
        }
    }
    public static Stack<Integer> reverse(Stack<Integer> st) {
        if(st.size() == 1)
            return st;
        int temp = st.pop();
        reverse(st);
        insert(st,temp);
        return st;
    }

    public static void insert(Stack<Integer> st, int ele) {
        if(st.isEmpty()) {
            st.push(ele);
            return;
        }
        int temp1 = st.pop();
        insert(st, ele);
        st.push(temp1);
    }
}
