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
        // Template of LIS is similar to LCS, we are comparing the current element with all the previous elements and updating the dp array based on the relation that if nums[i] > nums[j], then dp[i] = max(dp[i], dp[j] + 1), which means that if the current element is greater than the previous element, then we can extend the increasing subsequence by 1, so we will update the dp[i] value to be the maximum of its current value and the value of dp[j] + 1, which means that we are extending the increasing subsequence by 1 from the previous element at index j.
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



    //  Number of LIS
    // https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] t = new int[n];
        int[] count = new int[n];
        Arrays.fill(t, 1);
        Arrays.fill(count, 1);
        int maxLen = 1;

        // iterating over the array to fill t array with LIS
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]) {
                    if(t[j] + 1 == t[i]){ // if the length of the increasing subsequence ending at index j is equal to the length of the increasing subsequence ending at index i, then we can add the count of the increasing subsequence ending at index j to the count of the increasing subsequence ending at index i, because it means that we can extend the increasing subsequence ending at index j by 1 to get the increasing subsequence ending at index i, so we will add the count of the increasing subsequence ending at index j to the count of the increasing subsequence ending at index i.
                        count[i] += count[j]; // short version why count[i] += count[j]? because if t[j] + 1 == t[i], it means that we can extend the increasing subsequence ending at index j by 1 to get the increasing subsequence ending at index i, so we will add the count of the increasing subsequence ending at index j to the count of the increasing subsequence ending at index i, which is equivalent to count[i] = count[i] + count[j], so we can use the shorthand operator += to simplify the code and make it more concise.
                    }
                    else if(t[j] + 1 > t[i]) { // if the length of the increasing subsequence ending at index j is greater than the length of the increasing subsequence ending at index i, then we can update the length of the increasing subsequence ending at index i to be the length of the increasing subsequence ending at index j + 1, because it means that we can extend the increasing subsequence ending at index j by 1 to get a longer increasing subsequence ending at index i, so we will update the length of the increasing subsequence ending at index i to be the length of the increasing subsequence ending at index j + 1, and we will also update the count of the increasing subsequence ending at index i to be the count of the increasing subsequence ending at index j, because it means that we can extend all the increasing subsequences ending at index j by 1 to get new increasing subsequences ending at index i, so we will update the count of the increasing subsequence ending at index i to be the count of the increasing subsequence ending at index j.
                        t[i] = t[i] + 1; // why t[i] = t[i] + 1? because if t[j] + 1 > t[i], it means that we can extend the increasing subsequence ending at index j by 1 to get a longer increasing subsequence ending at index i, so we will update the length of the increasing subsequence ending at index i to be the length of the increasing subsequence ending at index j + 1, which is equivalent to t[i] = t[j] + 1, so we can use the shorthand operator += to simplify the code and make it more concise.
                        count[i] = count[j];
                    }
                }
            }
            maxLen = Math.max(maxLen, t[i]); // we are updating the maxLen variable to keep track of the maximum length of the increasing subsequence found so far, because we will need this value to calculate the total number of longest increasing subsequences at the end, so we will update the maxLen variable to be the maximum of its current value and the length of the increasing subsequence ending at index i, which is t[i].
        }

        int total = 0;
        for(int i = 0; i < n; i++) {
            if(t[i] == maxLen) {
                total += count[i];
            }
        }

        return total;

    }
}
