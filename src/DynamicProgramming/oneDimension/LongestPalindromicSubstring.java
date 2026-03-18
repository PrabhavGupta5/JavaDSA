package DynamicProgramming.oneDimension;

import java.util.Arrays;

// https://leetcode.com/problems/longest-palindromic-substring/description/
// https://www.youtube.com/watch?v=n_kL8BkURVA
// Time complexity: O(N^2) where N is the length of the input string, because we are using two nested loops to check all possible substrings of the input string, and for each substring, we are checking if it is a palindrome or not, which takes O(N) time in the worst case, so the overall time complexity is O(N^2).
// Space complexity: O(N^2) for the memoization table, because we are using a 2D array to store the results of the palindrome checks for all possible substrings of the

public class LongestPalindromicSubstring {
    int[][] t = new int[1001][1001];

    // this function is used to check if the substring from index i to index j is a palindrome or not, and we are using memoization to store the results of the palindrome checks for all possible substrings of the input string, so that we can avoid redundant calculations and improve the time complexity of the algorithm.
    public boolean solve(String s, int i, int j){
        if(i>=j)  return true;

        if(t[i][j] != -1) // if the value in the memoization table is not -1, then it means that we have already calculated the result for this substring, so we can return the result from the memoization table instead of calculating it again, which improves the time complexity of the algorithm.
            return t[i][j] == 1; // we are returning true if the value in the memoization table is 1, and false if it is 0, because we are storing the results of the palindrome checks as 1 for true and 0 for false in the memoization table.

        if(s.charAt(i) == s.charAt(j))    {
            boolean res = solve(s,i+1,j-1);
            t[i][j] = res ? 1 : 0;
            return res;
        }

        return t[i][j] == 0;
    }

    public String longestPalindrome(String s) {
        for(int[] row : t) // we are filling the memoization table with -1 to indicate that we have not yet calculated the results for any of the substrings of the input string, so that we can use this information to avoid redundant calculations and improve the time complexity of the algorithm.
            Arrays.fill(row, -1);

        int n = s.length();
        int maxLen = 0;
        int sp=0;

        for(int i = 0; i<n; i++) {
            for(int j=i ; j<n; j++){
                if(solve(s, i, j)){
                    if(j-i+1 > maxLen) {
                        maxLen = j-i+1;
                        sp = i;
                    }
                }
            }
        }
        return s.substring(sp, sp + maxLen);
    }
}
