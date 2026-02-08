package SlidingWindow;

import java.util.HashSet;

// https://leetcode.com/problems/contains-duplicate-ii/description/?envType=problem-list-v2&envId=sliding-window
public class ContainsDuplicateII {
    class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            HashSet<Integer> window = new HashSet<>();

            for(int i = 0; i < nums.length; i++) {
                if(window.contains(nums[i]))
                    return true;

                window.add(nums[i]);

                if(window.size() > k)
                    window.remove(nums[i-k]);

            }
            return false;

        }
    }
}
