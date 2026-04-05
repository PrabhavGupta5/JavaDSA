package SlidingWindow;

import java.util.HashSet;
// This problem I solved using an approach of sliding window, didn't use sliding window, just checking in a hashset if that number contains previously or not return early
// https://leetcode.com/problems/contains-duplicate/

public class ContainsDuplicate {
    class Solution {
        public boolean containsDuplicate(int[] nums) {
            HashSet<Integer> set = new HashSet<>();

            for (int num : nums) {
                if (set.contains(num))
                    return true;

                set.add(num);

            }
            return false;
        }
    }
}
