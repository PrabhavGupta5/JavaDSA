package Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(nums, 0, new ArrayList<>(), result);
        return result;

    }

    public static void backtracking(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<>(current));

        for(int i = start; i < nums.length; i++) {
            //removing duplicates, Skip duplicates at the SAME recursion level
            if(i > start && nums[i] == nums[i-1])
                continue;
            // choose
            current.add(nums[i]);
            // explore
            backtracking(nums,i+1, current,result);
            // remove
            current.remove(current.size()-1);
        }
    }
}

// i > start → same level → skip duplicate
//i == start → new branch → allow

// nums = [1,2,2]  (sorted)
// [1,2]   (using first 2)
// [1,2]   (using second 2)  ❌ duplicate