package Arrays;

public class KadanesAlgoMaximumSubArray {
    // This question is solved by kadane's algorithm, we are setting current sum to start new if the value is not maximum
    // Kadane’s algorithm dynamically decides whether to extend or restart a subarray based on whether the running sum is beneficial.”
    // https://leetcode.com/problems/maximum-subarray/
    // https://www.youtube.com/watch?v=GrNSGC8Z2T0&t=313s
    // This is maximum slice algorithm

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


    // Maximum Sum Circular Subarray
    // https://leetcode.com/problems/maximum-sum-circular-subarray/
    // https://www.youtube.com/watch?v=Za8V4wkZKkM
    class Solution2 {
        public int maxSubarraySumCircular(int[] nums) {
            // Max Circular Sum = Total Sum - Min Subarray Sum

            int totalSum = 0 ;
            int minSum = 0, maxSum = 0;
            for(int num : nums)
                totalSum += num;

            minSum = MinKadane(nums);
            maxSum = MaxKadane(nums);

            if(maxSum < 0) return maxSum;

            return Math.max(totalSum - minSum, maxSum);

        }

        public int MaxKadane(int[] nums) {
            int sum = nums[0];
            int maxSum = nums[0];

            for(int i = 1; i < nums.length; i++) {
                sum = Math.max(sum+nums[i] , nums[i]);
                maxSum = Math.max(sum, maxSum);
            }

            return maxSum;
        }

        public int MinKadane(int[] nums) {
            int sum = nums[0];
            int minSum = nums[0];

            for(int i = 1; i < nums.length; i++) {
                sum = Math.min(sum+nums[i] , nums[i]);
                minSum = Math.min(sum, minSum);
            }

            return minSum;
        }


    }
}
