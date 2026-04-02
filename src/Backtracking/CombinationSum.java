package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    // Combination I solution

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, new ArrayList<>(), result, 0, target);
        return result;
    }

    public void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result, int start, int target) {
        if(target == 0)
            result.add(new ArrayList<>(current));
        if(target < 0)
            return;
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            // We are basically checking the same condition backtracking and subtracting nums[i] from the target
            backtrack(nums, current, result, i, target - nums[i]);
            current.remove(current.size() - 1);
        }
    }
    // Input: candidates = [2,3,6,7], target = 7
    // Output: [[2,2,3],[7]], here we can take 2 times



    // Combination Sum II
    // it must not contain duplicate elements, and each number can only be used once.

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates); // must for removing duplicates
        backtrack2(candidates, new ArrayList<>(), result, 0, target);
        return result;
    }

    public void backtrack2(int[] nums, List<Integer> current, List<List<Integer>> result, int start, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (target < 0) return;

        for (int i = start; i < nums.length; i++) {
            // skip duplicates
            if (i > start && nums[i] == nums[i - 1])
                continue;

            current.add(nums[i]);
            // move forward (no reuse), that's why i+1 and not i
            backtrack2(nums, current, result, i + 1, target - nums[i]);

            current.remove(current.size() - 1);
        }
    }

    // Input: candidates = [10,1,2,7,6,1,5], target = 8
    // Output:
    //[
    //[1,1,6],
    //[1,2,5],
    //[1,7],
    //[2,6]
    //]


}
