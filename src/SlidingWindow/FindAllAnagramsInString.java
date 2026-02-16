package SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {

    // We are using frequency array to store p characters and then checking the characters in s string within the window using the same frequency
    // https://leetcode.com/problems/find-all-anagrams-in-a-string/
    // https://www.youtube.com/watch?v=egPDpu26q0M
    public List<Integer> findAnagrams(String s, String p) {

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        List<Integer> res = new ArrayList<>();

        // We have to fill the frequency array for P
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            pCount[c-'a']++;
        }

        int left = 0;

        for(int right=0; right < s.length(); right++) {
            sCount[s.charAt(right) - 'a']++;

            // Shrink the window in s
            if(right - left + 1 > p.length()) {
                sCount[s.charAt(left) - 'a']--;
                left ++;
            }

            if(Arrays.equals(sCount, pCount))
                res.add(left);

        }

        return res;
    }
}
