package Arrays;

import java.util.Arrays;

public class ValidAnagram {

    // https://leetcode.com/problems/valid-anagram/description/
    // This problem is solved by using two frequency arrays, we need to count the frequency of each character in
    // both strings and then compare the frequency arrays.
    // If they are equal, then the strings are anagrams of each other.
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (char c : s.toCharArray()) {
            freq1[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            freq2[c - 'a']++;
        }

        return Arrays.equals(freq1, freq2);

    }
}
