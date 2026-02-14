package SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
// This is solved by sliding window, pls watch the YouTube video, reference given in the other problem

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

// Second approach to solve by map using count frequency

class Solution {
    public int lengthOfLongestSubstring(String s) {
// eg : s = "abba"
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            // Increase frequency
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // If duplicate found, shrink window
            while (map.get(ch) > 1) {

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}

