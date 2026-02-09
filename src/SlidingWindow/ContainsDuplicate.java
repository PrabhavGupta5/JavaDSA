package SlidingWindow;

import java.util.HashSet;
// This problem I solved using an approach of sliding window, didn't use sliding window, just checking in a hashset if that number contains previously or not return early
// https://leetcode.com/problems/contains-duplicate/

public class ContainsDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> window = new HashSet<>();

            for(int i = 0; i < nums.length; i++) {
                if(window.contains(nums[i]))
                    return true;

                window.add(nums[i]);

            }
            return false;
        }
    }
}
