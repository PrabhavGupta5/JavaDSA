package Arrays.PrefixSum;

import java.util.HashMap;

public class SubArraySumEqualsK {
    // We maintain a running prefix sum and use a HashMap to store frequencies of prefix sums.
    // If (currentSum - k) exists, we add its frequency to the result.
    // Time complexity: O(n)
    // Space complexity: O(n) for the HashMap
    // https://leetcode.com/problems/subarray-sum-equals-k/

    // Step 1: Initialize a HashMap to store the frequency of prefix sums and a variable to keep track of the current sum and result count.
    // Step 2: Iterate through the array, updating the current sum and checking if (currentSum - k) exists in the HashMap. If it does, add its frequency to the result.
    // Step 3: Update the HashMap with the current sum and its frequency.
    // Step 4: Return the result count after iterating through the array.
    // We also add a base case to handle the situation when the current sum is equal to k, which means we found a valid subarray starting from index 0.

    // https://www.youtube.com/watch?v=N_AgTyMHgtw
    public int subArraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // map will store the prefix sum as key and its frequency as value
        int sum = 0;
        int res = 0;

        map.put(0,1); // base condition for sum = 0 and its count as 1

        for(int num : nums) {
            sum = sum + num;

            // if sum - k exists in map, increase the count of res
            res = res + map.getOrDefault(sum - k, 0);

            // put current sum in the map with the count
            //map.put(sum, map.getOrDefault(sum, 0) + 1);
            // We can also use merge method to update the count of sum in the map
            map.merge(sum, 1, Integer::sum);
        }

        return res;

    }

    // We also have one variant of this problem where we need to return the longest subarray, in this case we will store the index(first seen) of the prefix sum in the HashMap instead of its frequency, and we will update the max length whenever we find a valid subarray.
    // can we not do it in O(n) time complexity using the same approach of prefix sum and HashMap?
    public int longestSubArraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxLength = 0;

        map.put(0, -1); // base condition for sum = 0 and its index as -1

        for(int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if(map.containsKey(sum - k)) {
                maxLength = Math.max(maxLength, i - map.get(sum - k));
            }

            // Only put the current sum in the map if it is not already present to maintain the longest length
            map.putIfAbsent(sum, i);
        }

        return maxLength;
    }

}
// why are we not maintaing prefix sum array and using it to calculate the sum of subarrays?
// We can maintain a prefix sum array, but it would require O(n) space and O(n^2) time to calculate the sum of all subarrays, which is not efficient. By using a HashMap to store the frequency of prefix sums, we can calculate the sum of subarrays
