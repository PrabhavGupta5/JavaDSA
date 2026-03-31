package Recursion;

import java.util.*;

//import static Recursion.Generic.printArray;

public class SubsetsWithDup {
    public static void main(String[] args) {
        SubsetsWithDup s = new SubsetsWithDup();
        int[] nums = {1,2,2};
        List<List<Integer>> ans = s.subsetsWithDup(nums);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }

        //printArray(new Integer[]{1,2,3});
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> op = new ArrayList<>();
        Arrays.sort(nums);
        solve(nums,op,set);
        return new ArrayList<>(set);
    }

    public void solve(int[] nums, List<Integer>op, Set<List<Integer>> set) {
        if(nums.length == 0) {
            set.add(new ArrayList<>(op));
            return;
        }

        ArrayList<Integer> op1 = new ArrayList<>(op);
        ArrayList<Integer> op2 = new ArrayList<>(op);

        op2.add(nums[0]);
        // better way
        nums = Arrays.copyOfRange(nums, 1, nums.length); // remove first element from input array

        solve(nums,op1,set);
        solve(nums,op2,set);

    }
}

//class Generic<T> {
//    T val;
//
//    public Generic(T val) {
//        this.val = val;
//    }
//
//    ArrayList<T> array = new ArrayList<>();
//
//    public static<T> void printArray(T[] val) {
//        for (T element : val) {
//            System.out.print(" " + element);
//        }
//
//    }
//
//}
