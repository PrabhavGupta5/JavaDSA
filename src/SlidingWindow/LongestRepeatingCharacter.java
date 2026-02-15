package SlidingWindow;

import java.util.HashMap;

public class LongestRepeatingCharacter {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            // track the highest frequency character in current window
            maxFreq = Math.max(maxFreq, map.get(ch));

            // if replacements needed exceed k → shrink
            // window_size - max_frequency <= k tells you We never allow the window to require more than k replacements.
            // it gives no of characters that is not dominated it is greater than k window is invalid, have to shrink it
            while ((right - left + 1) - maxFreq > k) {

                char leftChar = s.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
