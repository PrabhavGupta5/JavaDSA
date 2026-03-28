package BinarySearch;

// https://leetcode.com/problems/split-array-largest-sum/description/
// In this question we are applying binary search on answer space and not on the input array.
// https://www.youtube.com/watch?v=thUd_WJn6wk
// This problem is as same as allocate books, partition painters
public class SplitArrayLargestSum {

    public int splitArray(int[] nums, int k) {
        int left = Integer.MIN_VALUE;
        int right = 0;
        for (int num : nums) {
            left = Math.max(left, num);
            right += num;
        }

        int ans = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canSplit(nums, k, mid)) {
                ans = mid;
                right = mid - 1;
            } else
                left = mid + 1;
        }
        return ans;
    }

    public boolean canSplit(int[] nums, int k, int mid) {
        int count = 1; // We start with one subarray
        int sum = 0; // This will keep track of the sum of the current subarray

        for (int num : nums) {
            sum += num; // Add the current number to the sum

            if (sum > mid) { // If the sum exceeds mid, we need to start a new subarray
                count++; // Increment the count of subarrays
                sum = num; // Start the new subarray with the current number

                if (count > k) { // If we have more than m subarrays, return false
                    return false;
                }
            }
        }
        return true; // If we can split into m or fewer subarrays, return true
    }
}
