package TwoPointers;

import java.util.HashMap;

public class TwoSum {
    // optimal approach for two sum problem using HashMap to store the complement of the current element and its index.
    // We can check if the complement exists in the HashMap,
    // if it does then we have found our pair, and we can return their indices. If it doesn't exist,
    // we can add the current element and its index to the HashMap for future reference.
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // nums[i] = key
        // index = value

        for(int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if(map.containsKey(complement))
                return new int[]{map.get(complement), i};
            map.put(nums[i], i);

        }
        return new int[]{-1,-1};
    }
}
