package Backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subsets(arr));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        backtracking(nums, 0, new ArrayList<>(), result);
        return result;

    }

    public static void backtracking(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for(int i = start; i < nums.length; i++) {
            // choose
            current.add(nums[i]);
            // explore
            backtracking(nums,i+1, current,result);
            // remove
            current.remove(current.size()-1);
        }
    }
}
// nums = [1,2]
//curr = []
//→ add [] to result
//
//Take 1 → curr = [1]
//→ add [1]
//
//Take 2 → curr = [1,2]
//→ add [1,2]
//
//Backtrack → curr = [1]
//
//Skip 2 → backtrack → curr = []
//
//Take 2 → curr = [2]
//→ add [2]