package SlidingWindow;

import java.util.HashSet;
import java.util.Set;

// Watch this for reference: https://www.youtube.com/watch?v=x1ZUaf_Qhk0&list=PLh_njhZ_MgInazcDWlX1RlpwIIYACSyIJ&index=3
// Watch this for reference of Sliding Window: https://www.youtube.com/watch?v=tk38CTSAYsg

// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
public class MaximumSumDistinctSubArray {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        long curSum=0, maxSum=0;
        int left = 0;

        for(int right = 0; right < nums.length; right ++){
            while(set.contains(nums[right]) || set.size() == k)
            {
                set.remove(nums[left]);
                curSum-=nums[left];
                left ++;
            }

            curSum += nums[right];
            set.add(nums[right]);

            if(set.size()== k)
                maxSum = Math.max(curSum, maxSum);

        }
        return maxSum;
    }
}