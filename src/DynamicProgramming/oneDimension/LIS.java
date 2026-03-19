package DynamicProgramming.oneDimension;

import java.util.Arrays;

// https://leetcode.com/problems/longest-increasing-subsequence/description/
// https://www.youtube.com/watch?v=Xq3hlMvhrkE
public class LIS {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // we are filling the dp array with 1 because the minimum length of increasing subsequence is 1, which
        // is the element itself, so we are initializing the dp array with 1 for all elements, and then we will update the dp array
        // based on the relation that if nums[i] > nums[j], then dp[i] = max(dp[i], dp[j] + 1), which means that if the current
        // element is greater than the previous element, then we can extend the increasing subsequence by 1, so we will update the
        // dp[i] value to be the maximum of its current value and the value of dp[j] + 1, which means that we are extending the
        // increasing subsequence by 1 from the previous element at index j.
        int maxLen = 0;

        // iterating over the array to fill dp array with LIS
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // int maxLen = Arrays.stream(dp).max().orElse(0);

        for(int val : dp) {
            maxLen = Math.max(maxLen, val);
        }

        return maxLen;
    }
}
