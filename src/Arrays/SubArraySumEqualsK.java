package Arrays;

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
        int sum = 0;
        int res = 0;

        map.put(0,1); // base condition for sum = 0 and its count as 1

        for(int num : nums) {
            sum = sum + num;

            // if sum - k exists in map, increase the count of res
            res = res + map.getOrDefault(sum - k, 0);

            // put current sum in the map with the count
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return res;

    }
}
