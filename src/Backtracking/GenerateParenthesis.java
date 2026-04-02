package Backtracking;

import java.util.ArrayList;
import java.util.List;


public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    public void backtrack(List<String> result, StringBuilder sb, int open, int close, int n) {

        if(sb.length() == 2 * n) {
            result.add(sb.toString());
            return;
        }
        // for open bracket
        if(open < n) {
            sb.append('(');
            backtrack(result, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        // for close bracket
        if(close < open) { // close brackets are less
            sb.append(')');
            backtrack(result, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }

    }

}
