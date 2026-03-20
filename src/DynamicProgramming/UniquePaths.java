package DynamicProgramming;

// https://www.leetcode.com/problems/unique-paths/description/
// This problem is solved by using dynamic programming, we need to use a 2D array to store the number of unique paths to reach each cell, and we will use the relation that the number of unique paths to reach a cell is the sum of the number of unique paths to reach the cell above it and the cell to the left of it, because we can only move down or right, so we need to consider both cases to find the number of unique paths to reach a cell.
// Time complexity: O(M*N) where M is the number of rows and N is the number of columns
// Space complexity: O(M*N) for the dp array
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1]; // We can reach to a cell from top and left, so we will add the number of ways to reach from top and left
            }
        }

        return dp[m-1][n-1]; // why m-1 and n-1 because we are starting from 0,0 and we want to reach m-1,n-1
    }
}
