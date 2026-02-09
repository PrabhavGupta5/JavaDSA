package SlidingWindow;

import java.util.HashMap;

public class MinimumWindowSubstring {

    // https://leetcode.com/problems/minimum-window-substring/
    // https://www.youtube.com/watch?v=iwv1llyN6mo
    // This is the hardest problem of sliding window, try to understand why each step is happening
    // its a shrinking window problem, increase i to decrease the window size
    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < t.length(); i++) {
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            }
            int i = 0, j = 0;
            String ans = "";
            int count = map.size();
            int min = Integer.MAX_VALUE;

            while (j < s.length()) {
                if (map.containsKey(s.charAt(j))) {
                    map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) - 1); // checking if more character is left
                    if (map.getOrDefault(s.charAt(j), 0) == 0) // if the character becomes zero in map reduce count
                        count--;
                }

                while (count == 0) {
                    if (min > j - i + 1) {
                        min = Math.min(min, j - i + 1);
                        ans = s.substring(i, j + 1);
                    }
                    //sliding window reducing window now
                    if (map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1); // here we are increasing the count shrinking window
                        if (map.get(s.charAt(i)) == 1)
                            count++;
                    }
                    i++;
                }

                j++;

            }
            return ans;
        }
    }
}