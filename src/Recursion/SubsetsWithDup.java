package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Recursion.Generic.printArray;

public class SubsetsWithDup {
    public static void main(String[] args) {
        SubsetsWithDup s = new SubsetsWithDup();
        int[] nums = {1,2,2};
        List<List<Integer>> ans = s.subsetsWithDup(nums);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }

        printArray(new Integer[]{1,2,3});
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

class Generic<T> {
    T val;

    public Generic(T val) {
        this.val = val;
    }

    ArrayList<T> array = new ArrayList<>();

    public static<T> void printArray(T[] val) {
        for (T element : val) {
            System.out.print(" " + element);
        }

    }

}
