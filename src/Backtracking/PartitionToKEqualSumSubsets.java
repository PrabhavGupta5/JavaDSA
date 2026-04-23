package Backtracking;

// https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
public class PartitionToKEqualSumSubsets {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // return true if we can divide nums into k subsets with equal sum
        int sum = 0;
        for(int num : nums)
            sum = sum + num;
        if(sum % k != 0) return false;
        return backtrack(nums, k, 0, 0, sum / k, new boolean[nums.length]);
        //return res;
    }

    public boolean backtrack(int[] nums, int k, int start, int sum, int target, boolean[] used) {

        if(k == 0) return true;

        if(sum == target)
            return backtrack(nums, k-1, 0, 0, target, used);

        for(int i = start; i < nums.length; i++) {
            if(used[i]) continue;
            if (sum + nums[i] > target) continue;
            // add
            used[i] = true;
            // backtrack, explore
            if(backtrack(nums, k, i + 1, sum + nums[i], target, used))
                return true;
            // remove
            used[i] = false;
        }
        return false;

    }
}

// Input: nums = [4,3,2,3,5,2,1], k = 4
//Output: true
//Explanation: It is possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.