package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/permutations/
// https://www.youtube.com/watch?v=H232aocj7bQ
public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>());
        return result;
    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> current) {
        if(current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            // skip if the element is present in the current list
            if(current.contains(nums[i]))
                continue;
            // add
            current.add(nums[i]);

            // explore
            backtrack(nums, result, current);

            // remove
            current.remove(current.size()-1);
        }
    }
    // Input: nums = [1,2,3]
    // Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]







    // Permutations II, where we only have to print unique ones

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // for duplicates, it is a must
        boolean[] usedFlag = new boolean[nums.length];
        backtrack2(nums, result, new ArrayList<>(), usedFlag);
        return result;
    }

    public void backtrack2(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] usedFlag) {
        if(current.size() == nums.length && !result.contains(current)) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = 0; i < nums.length; i++){

            // if the usedFlag is true, skip that character
            if(usedFlag[i])
                continue;
            if(i > 0 && nums[i] == nums[i - 1] && !usedFlag[i - 1])      // this line is memory efficient, as it is stopping to generate duplicate permutations
                continue;

            // add
            usedFlag[i] = true; // marking that element as used
            current.add(nums[i]);

            // explore
            backtrack2(nums, result, current, usedFlag);

            // remove
            usedFlag[i] = false; // It can be used at later point
            current.remove(current.size()-1);
        }
    }
}




// [1,1,2]
// 1(first), 1(second), 2
// 1(second), 1(first), 2   ❌ duplicate