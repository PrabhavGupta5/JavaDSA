package Graphs;

// https://leetcode.com/problems/number-of-closed-islands/description/
// We are using a depth-first search (DFS) approach to solve this problem. The idea is to first remove all the islands that are
// connected to the boundary of the grid, as they cannot be closed islands. Then, we will count the remaining islands in the grid,
// which will be our closed islands. The DFS function will mark all the connected land cells as visited by changing their value to
// 1 (water), so that we do not count them again.
// Time complexity: O(m*n) where m is the number of rows and n is the number of columns in the grid, because in the worst case we might have to visit every cell in the grid. The space complexity is O(m*n) in the worst case when the grid is filled with land, as we might have to add all cells to the call stack due to recursion.

public class NoOfClosedIslands {
        public int closedIsland(int[][] grid) {
            int m = grid.length; // number of rows
            int n = grid[0].length; // number of columns

            // Remove islands connected to the boundary
            // top row
            for(int j = 0; j < n; j++)
                dfs(grid, 0, j);
            // bottom row
            for(int j = 0; j < n; j++)
                dfs(grid, m - 1, j);
            // left column
            for(int i = 0; i < m; i++)
                dfs(grid, i, 0);
            // right column
            for(int i = 0; i < m; i++)
                dfs(grid, i, n - 1);

            // Count remaining closed islands
            int count = 0;

            for(int i = 1; i < m - 1; i++){
                for(int j = 1; j < n - 1; j++){

                    if(grid[i][j] == 0){
                        // When we find the first land cell of an island, we run DFS, DFS spreads through the entire island and marks all the land cells of that island as visited (by changing their value to 1), so that we don't count the same island again when we encounter it in the future. After the DFS call, we increment our count of closed islands by 1.
                        dfs(grid, i, j); // mark the entire island as visited so that we don't count it again when we encounter it in the future
                        count++;
                    }

                }
            }

            return count;
        }

        private void dfs(int[][] grid, int r, int c){

            int m = grid.length;
            int n = grid[0].length;

            // DFS base case: Array index out of bounds or if the cell is water (1) because we only want to visit land cells (0)
            if(r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == 1)
                return;

            // Mark the current cell as visited by changing its value to 1 (water)
            grid[r][c] = 1;   // mark visited, basically converting land to water so that we don't count it again when we encounter it in the future

            dfs(grid, r + 1, c);
            dfs(grid, r - 1, c);
            dfs(grid, r, c + 1);
            dfs(grid, r, c - 1);
        }

}
