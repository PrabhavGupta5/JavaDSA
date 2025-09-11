package Recursion;

import java.util.Stack;


public class DeleteMiddleStackElement {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);

        int midPos = st.size() / 2 + 1;
        delete(st, midPos);

        while(!st.isEmpty()) {
            System.out.println(st.pop() + " ");
        }
    }

    public static void delete(Stack<Integer> st, int k) {
        if(k==1) {
            st.pop();
            return;
        }

        int val = st.pop();
        delete(st,k-1);
        st.push(val);
    }
}
