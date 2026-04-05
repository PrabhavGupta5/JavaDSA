package SlidingWindow;

// https://leetcode.com/problems/maximum-average-subarray-i/description/?envType=problem-list-v2&envId=sliding-window
public class MaximumAvgSubArrayI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0, maxSum = Integer.MIN_VALUE;
        int i = 0;

        for(int j = 0; j < nums.length; j++) {
            sum = sum + nums[j];

            if(j-i+1 == k) { // Window size is k
                maxSum = Math.max(sum, maxSum);
                sum = sum - nums[i];
                i++;
            }
        }

        return (double) maxSum / k;
    }

    // This is also same as above but with a different question
    // https://leetcode.com/problems/number-of-sub-arrays-of-size-k-and-average-greater-than-or-equal-to-threshold/description/?envType=problem-list-v2&envId=sliding-window
    public int numOfSubArrays(int[] arr, int k, int threshold) {
        // the window is fixed in this case
        int i = 0;
        int count = 0;
        int sum = 0;
        for(int j = 0; j < arr.length; j++) {
            sum = sum + arr[j];

            if(j-i+1 == k) {
                if(sum/k >= threshold)
                    count++;

                sum = sum - arr[i];
                i++;
            }
        }
        return count;
    }
}


