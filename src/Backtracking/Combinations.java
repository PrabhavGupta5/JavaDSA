package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        // have to choose k num from 1 to n
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, new ArrayList<>(), res);
        return res;
    }

    public void backtrack(int start, int n, int k, List<Integer> current, List<List<Integer>> res) {
        if(current.size() == k){ // base condition
            res.add(new ArrayList<>(current));
            return;
        }

        for(int i = start; i <= n; i++) {
            // add, choose
            current.add(i);
            // call backtrack, explore other path
            backtrack(i+1, n, k, current, res); // taking i+1 as question doesn't want [1,1], start from [1,2] and so on
            // remove
            current.remove(current.size() - 1);
        }

    }
}
