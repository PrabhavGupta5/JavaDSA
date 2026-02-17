package SlidingWindow;

import java.util.Arrays;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int[] s1Count = new int[26];
        int[] s2Count = new int[26];

        boolean res = false;

        // We have to fill the frequency array for s1
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            s1Count[c-'a']++;
        }

        int left = 0;

        for(int right=0; right < s2.length(); right++) {
            s2Count[s2.charAt(right) - 'a']++;

            // Shrink the window in s2
            if(right - left + 1 > s1.length()) {
                s2Count[s2.charAt(left) - 'a']--;
                left ++;
            }

            if (Arrays.equals(s1Count, s2Count))
                return true;

        }

        return res;
    }
}
