package Recursion;

import java.util.ArrayList;
import java.util.List;

// https://www.geeksforgeeks.org/problems/print-n-bit-binary-numbers-having-more-1s-than-0s0252/1
// https://www.youtube.com/watch?v=U81n0UYtk98&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=18
public class PrefixNGreaterOne {

    public List<String> NBitBinary(int N){
        List<String> ans = new ArrayList<>();
        int onecnt = 0;
        int zerocnt = 0;
        String op = "";
        solve(onecnt, zerocnt, op, N, ans);
        return ans;
    }
    public void solve(int one, int zero, String op, int N, List<String> ans) {
        if(N == 0) {
            ans.add(op);
            return ;
        }

        if(N>0){
            String op1 = op;
            op1 = op1 + "1";
            solve(one + 1, zero, op1, N-1, ans);
        }

        if(one>zero) {
            String op2 = op;
            op2 = op2 + "0";
            solve(one, zero + 1, op2, N-1, ans);
        }
    }
}
