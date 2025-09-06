package SlidingWindow;

import java.util.HashSet;
import java.util.Set;


// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// This is solved by sliding window, pls watch the youtube video, reference given in the other problem

public class LongestSubstringW0Repeating {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length() ; right ++) {
            while(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left ++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}