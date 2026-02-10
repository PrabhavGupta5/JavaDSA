package Arrays;

public class MaximumSubArray {
    // This question is solved by kadane's algorithm, we are setting current sum to start new if the value is not maximum
    // Kadane’s algorithm dynamically decides whether to extend or restart a subarray based on whether the running sum is beneficial.”
    // https://leetcode.com/problems/maximum-subarray/
    // https://www.youtube.com/watch?v=GrNSGC8Z2T0&t=313s
    class Solution {
        public int maxSubArray(int[] nums) {
            int max = nums[0], currSum = nums[0];

            for(int i=1; i<nums.length; i++) {
                currSum = Math.max(nums[i], nums[i] + currSum); // This line is setting a new start if its sum is not greater than nums[i]
                max = Math.max(currSum,max);
            }

            return max;
        }
    }
}
