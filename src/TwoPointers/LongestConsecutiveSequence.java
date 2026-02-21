package TwoPointers;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=problem-list-v2&envId=two-pointers
// This problem is solved by using a hash set to store the numbers in the array, and then we iterate through the set and check for the longest consecutive sequence.
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 0;

        for (int num : numSet) {
            // Only start if no previous consecutive number exists so that we know it's the start of a sequence
            // This ensures we only count each sequence once
            // If num - 1 is not in the set, then num is the start of a sequence,  like it is the smallest number in the sequence,
            // so we can start counting from there
            if (!numSet.contains(num - 1)) {
                int length = 1;
                while (numSet.contains(num + length)) {
                    length++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
