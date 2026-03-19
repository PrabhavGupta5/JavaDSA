package DynamicProgramming.oneDimension;

import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/word-break/description/
// https://www.youtube.com/watch?v=hK6Git1o42c
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        int n = s.length();
        int maxLen = 0;

        for(String word : wordDict)
            maxLen = Math.max(word.length(), maxLen);

        boolean[] dp = new boolean[n+1];
        dp[0] = true;

        // iterating over list and filling the dp array
        for(int i = 0; i <= n; i++) {
            for(int j = i-1; j>= Math.max(0, i-maxLen); j--) {
                // Ensures previous part is valid before adding new word thats why we are checking dp[j] is true or not, if it is true then we can check if the substring from index j to index i is in the set or not, if it is in the set then we can set dp[i] to true because it means that the substring from index 0 to index i can be segmented into words from the wordDict.
                if(dp[j] && set.contains(s.substring(j, i))){ // why dp[j] is true? because if dp[j] is true, it means that the substring from index 0 to index j can be segmented into words from the wordDict, so we can check if the substring from index j to index i is also in the wordDict, and if it is, then we can set dp[i] to true, because it means that the substring from index 0 to index i can be segmented into words from the wordDict.
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
