package DynamicProgramming.oneDimension;

import java.util.Arrays;

// https://leetcode.com/problems/palindromic-substrings/description/
// This question is similar to the longest palindromic substring, but instead of finding the longest palindrome, we need to count all the
// palindromic substrings in the input string, so we can use the same approach as longest palindromic substring, but instead of keeping
// track of the longest palindrome, we can keep track of the count of palindromic substrings that we find, and we can increment the count
// variable by 1 for each substring that is a palindrome, which gives us the total number of palindromic substrings in the input string.
public class PalindromicSubstrings {
    int[][] t = new int[1001][1001];

    public boolean solve(String s, int i, int j){
        if(i>=j)  return true;

        if(t[i][j] != -1)
            return t[i][j] == 1;

        if(s.charAt(i) == s.charAt(j))    {
            boolean res = solve(s,i+1,j-1);
            t[i][j] = res ? 1 : 0;
            return res;
        }
        return t[i][j] == 0;
    }

    public int countSubstrings(String s) {
        for(int[] row : t)
            Arrays.fill(row, -1);

        int count = 0;
        int n = s.length();

        for(int i = 0; i<n; i++) {
            for(int j=i ; j<n; j++){
                if(solve(s, i, j)){
                    count++; // we are incrementing the count variable by 1 for each substring that is a palindrome, which gives us the total number of palindromic substrings in the input string.

                }
            }
        }
        return count;
    }
}
