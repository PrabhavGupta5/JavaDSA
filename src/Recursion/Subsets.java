package Recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/description/
// Solving by recursion tree
public class Subsets {
    public static void main(String[] args) {

    }
    public List<List<Integer>> res = new ArrayList<>();

    public void solve(List<Integer> ip, List<Integer> op){
        if(ip.isEmpty()) {
            res.add(op);
            return;
        }
        List<Integer> op1 = new ArrayList<>(op);
        List<Integer> op2 = new ArrayList<>(op);
        op2.add(ip.getFirst());
        ArrayList<Integer> clone = new ArrayList<>(ip); // why clone is required because we are modifying the input list and we don't want to modify the original input list for the next recursive call
        clone.removeFirst();
        solve(clone,op1);
        solve(clone,op2);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ip = new ArrayList<>();
        for (int i : nums) {
            ip.add(i); // convert input array to list
        }
        List<Integer> op = new ArrayList<>(); // empty list
        solve(ip, op);
        return res;
    }
}
