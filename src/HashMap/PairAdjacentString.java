package HashMap;

import java.util.HashMap;
import java.util.Map;

public class PairAdjacentString {
// This problem is solved by using a hashmap, we need to use methods of hashmap\
// https://leetcode.com/problems/find-valid-pair-of-adjacent-digits-in-string/description/

    class Solution {
        public String findValidPair(String s) {
            HashMap<Character, Integer> freq = new HashMap<>();

            // Count frequencies
            for (char c : s.toCharArray()) {
                freq.put(c, freq.getOrDefault(c,0) + 1);
                //freq.merge(c,1, Integer::sum);
            }

            // Traverse adjacent pairs
            for (int i = 0; i < s.length() - 1; i++) {
                char a = s.charAt(i);
                char b = s.charAt(i + 1);

                if (a != b &&
                        freq.get(a) == (a - '0') &&
                        freq.get(b) == (b - '0')) {

                    return "" + a + b;
                }
            }

            return "";

        }
    }
}
