package Recursion;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/description/
public class Subsets {
    public static void main(String[] args) {

    }
    public List<List<Integer>> a = new ArrayList<>();

    public void solve(List<Integer> ip, List<Integer> op){
        if(ip.isEmpty()) {
            a.add(op);
            return;
        }
        List<Integer> op1 = new ArrayList<>(op);
        List<Integer> op2 = new ArrayList<>(op);
        op2.add(ip.getFirst());
        ArrayList<Integer> clone = new ArrayList<>(ip);
        clone.removeFirst();
        solve(clone,op1);
        solve(clone,op2);

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ip = new ArrayList<>();
        for (int i : nums) {
            ip.add(i);
        }
        List<Integer> op = new ArrayList<>();
        solve(ip, op);
        return a;
    }
}
