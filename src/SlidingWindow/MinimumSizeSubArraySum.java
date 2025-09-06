package SlidingWindow;


// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int curSum=0;

        for (int right = 0; right < nums.length ; right ++) {
            curSum += nums[right];

            while(curSum >= target){
                if(right - left + 1 < minLen)
                    minLen = right - left + 1 ;
                curSum -= nums[left];
                left ++;
            }

        }

        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }
}