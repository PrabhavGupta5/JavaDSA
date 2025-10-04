package DynamicProgramming;

import java.util.Arrays;

// In this question we have to find min no of steps to make a string palindrome, This is based on MCM
// https://leetcode.com/problems/palindrome-partitioning-ii/
// https://www.youtube.com/watch?v=szKVpQtBHh8&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=35
public class PalindromePartitioning {

    int[][] dp = new int[2001][2001];

    public int minCut(String str) {
        int i = 0, j = str.length() - 1;

        for (int[] ks : dp)
            Arrays.fill(ks, -1);

        return minPalPartition(str, i, j);
    }

    int minPalPartition(String string, int i, int j) {
        if (i >= j || isPalindrome(string, i, j))
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];

        dp[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            if (isPalindrome(string, i, k)) {
                // If a left substring is a palindrome, cut, then solve recursively for the right.
                // No need to make further partitions in a substring you’ve already found to be a palindrome.
                int count = 1 + minPalPartition(string, k + 1, j); // Only right part
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        return dp[i][j];
    }

    boolean isPalindrome(String string, int i, int j) {
        while (i < j) {
            if (string.charAt(i) != string.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}