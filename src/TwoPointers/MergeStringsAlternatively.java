package TwoPointers;

// https://leetcode.com/problems/merge-strings-alternately/
public class MergeStringsAlternatively {
    public String mergeAlternately(String word1, String word2) {
        // We have to merge string alternatively
        StringBuilder res = new StringBuilder();
        int i = 0, j = 0;

        while(i < word1.length() || j < word2.length()) {
            if(i < word1.length()){
                res.append(word1.charAt(i));
                i++;
            }

            if(j < word2.length()){
                res.append(word2.charAt(j));
                j++;
            }

        }

        return res.toString();
    }
}
