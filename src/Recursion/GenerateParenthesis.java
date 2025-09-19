package Recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/generate-parentheses/
// https://www.youtube.com/watch?v=eyCj_u3PoJE&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=17
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        int open = n, close = n;
        String op = "";
        List<String> ans = new ArrayList<>();
        solve(open, close, op, ans);
        return ans;
    }

    public void solve(int open, int close, String op, List<String> ans) {
        if(open == 0 && close == 0) {
            ans.add(op);
            return;
        }

        if(close>open) {
            String op1 = op;
            String op2 = op;
            if(open>0)  {
                op1 = op1 + "(";
                solve(open - 1, close, op1, ans);
            }

            op2 = op2 + ")";
            solve(open, close - 1, op2, ans);
        }

        else {
            String op3 = op;
            op3 = op3 + "(";
            solve(open - 1, close, op3, ans);
        }
    }
}