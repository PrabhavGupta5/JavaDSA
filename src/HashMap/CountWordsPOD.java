package HashMap;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/submissions/detail/1999722429/
public class CountWordsPOD {
    class Solution {
        public int[] countWordOccurrences(String[] chunks, String[] queries) {
            // make proper words in the string,
            // store the frequency
            StringBuilder sb = new StringBuilder();
            for (String chunk : chunks)
                sb.append(chunk);

            String s = sb.toString();
            Map<String, Integer> freq = new HashMap<>();

            StringBuilder curr = new StringBuilder();

            for(int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (Character.isLowerCase(ch) ||
                        (ch == '-' &&
                                i > 0 &&
                                i < s.length() - 1 &&
                                Character.isLowerCase(s.charAt(i - 1)) &&
                                Character.isLowerCase(s.charAt(i + 1)))) {

                    curr.append(ch);
                }
                else{
                    if(curr.length() > 0) {
                        String word = curr.toString();
                        freq.put(word, freq.getOrDefault(word, 0) + 1);
                        curr.setLength(0);
                    }
                }
            }
            if(curr.length() > 0){ // for last word
                String word = curr.toString();
                freq.put(word, freq.getOrDefault(word, 0) + 1);
                curr.setLength(0);
            }

            // Now have to compare the frequency with queries array in the map
            int[] ans = new int[queries.length];

            for(int i = 0; i < queries.length; i++) {
                ans[i] = freq.getOrDefault(queries[i], 0);
            }

            return ans;
        }
    }
}
// h -> he -> hel -> hell -> hello
//(space)
//STORE "hello"
//RESET
//w -> wo -> wor -> worl -> world
//STORE "world"
