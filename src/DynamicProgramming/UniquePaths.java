package DynamicProgramming;

// https://www.leetcode.com/problems/unique-paths/description/
// This problem is solved by using dynamic programming, we need to use a 2D array to store the number of unique paths to reach each cell, and we will use the relation that the number of unique paths to reach a cell is the sum of the number of unique paths to reach the cell above it and the cell to the left of it, because we can only move down or right, so we need to consider both cases to find the number of unique paths to reach a cell.
// Time complexity: O(M*N) where M is the number of rows and N is the number of columns
// Space complexity: O(M*N) for the dp array

// https://www.youtube.com/watch?v=Ee-rJmkwaTM
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


 //  https://www.leetcode.com/problems/unique-paths-ii/description/
 // This problem is solved by using dynamic programming, we need to use a 2D array to store the number of unique paths to reach each cell, and we will use the relation that the number of unique paths to reach a cell is the sum of the number of unique paths to reach the cell above it and the cell to the left of it, because we can only move down or right, so we need to consider both cases to find the number of unique paths to reach a cell, but we also need to check if there is an obstacle in the cell, if there is an obstacle then we cannot reach that cell, so we will return 0 for that cell.
    // https://www.youtube.com/watch?v=JC1fSPdJjMc
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        Integer[][] dp = new Integer[m][n];
        return solve(0, 0, obstacleGrid, dp);
    }

    public int solve(int i, int j, int[][] obstacleGrid, Integer[][] dp) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(i >= m || j >= n || obstacleGrid[i][j] == 1)
            return 0;

        if(i == m-1 && j == n-1)
            return 1;

        if(dp[i][j] != null) // if we have already calculated the number of unique paths to reach this cell, then we will return the value from the dp array, because we are using memoization to avoid redundant calculations and improve the time complexity of the solution.
            return dp[i][j];

        dp[i][j] = solve(i+1, j, obstacleGrid, dp) + solve(i, j+1, obstacleGrid, dp);

        return dp[i][j];
    }
}
