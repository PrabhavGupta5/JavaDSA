package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsWithDup {
    public static void main(String[] args) {

    }
    public List<List<Integer>> a = new ArrayList<>();

    public void solve(List<Integer> ip, List<Integer> op){
        if(ip.isEmpty()) {
            a.add(op);
            return;
        }
        // Adding first element to op2
        List<Integer> op2 = new ArrayList<>(op);
        op2.add(ip.get(0));
        ArrayList<Integer> ip1 = new ArrayList<>(ip);
        ip1.remove(0);
        solve(ip1,op2);

        // Choice 2: Exclude first element AND all its duplicates
        int firstElement = ip.get(0);
        ArrayList<Integer> ip2 = new ArrayList<>(ip);
        ip2.remove(0);

        while(!ip2.isEmpty() && ip2.get(0) == ip.get(0)){
            ip2.remove(0);
        }

        List<Integer> op1 = new ArrayList<>(op);
        solve(ip2,op1);

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ip = new ArrayList<>();
        for (int i : nums) {
            ip.add(i);
        }
        List<Integer> op = new ArrayList<>();
        solve(ip, op);
        return a;
    }
}
