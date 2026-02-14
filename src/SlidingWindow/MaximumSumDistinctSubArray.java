package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// Watch this for reference: https://www.youtube.com/watch?v=x1ZUaf_Qhk0&list=PLh_njhZ_MgInazcDWlX1RlpwIIYACSyIJ&index=3
// Watch this for reference of Sliding Window: https://www.youtube.com/watch?v=tk38CTSAYsg

// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/
public class MaximumSumDistinctSubArray {
    public long maximumSubArraySum(int[] nums, int k) {
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

    // With HashMap with frequency


    public long maximumSubArraySumHashmap(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        long max = 0;
        long sum = 0;

        for(int right = 0; right < nums.length ; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);
            sum = sum + nums[right];

            if(right - left + 1 > k) {
                // shrink window
                sum = sum - nums[left];
                map.put(nums[left], map.get(nums[left]) -1);
                if(map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }

            if(right - left + 1 == k && map.size() == k)  // length must exactly be k and all should be unique
                max = Math.max(max, sum);

        }

        return max;
    }
}