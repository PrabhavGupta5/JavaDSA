package Graphs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands/description/
// We are using BFS to traverse the grid, whenever we find a '1', we increment the island count and mark all the connected
// '1's as '0' to avoid counting them again. We use a queue to perform the BFS traversal and a directions array to explore
// the four possible directions (up, down, left, right) from the current cell.

// The time complexity of this solution is O(m*n) where m is the number of rows and n is the number of columns in the grid, because in the worst case we might have to visit every cell in the grid.
// The space complexity is also O(m*n) in the worst case when the grid is filled with '1's, as we might have to add all cells to the queue.
public class NumberOfIslands {
        public int numIslands(char[][] grid) {

            int rows = grid.length;
            int cols = grid[0].length;

            int noOfIslands = 0;

            // directions array to explore the four possible directions (up, down, left, right) from the current cell
            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){

                    if(grid[i][j] == '1'){
                        noOfIslands++;

                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{i,j});
                        // Mark the current cell as visited by changing it to '0' so that we don't count it again when we encounter it in the future.
                        grid[i][j] = '0'; // mark as visited

                        // This is BFS exploration starting from the current cell, we keep adding the neighboring cells that are '1' to the queue and marking them as '0' until the queue is empty. This way we are marking all the connected '1's as '0' and counting them as one island.
                        while(!queue.isEmpty()){

                            int[] cell = queue.poll();

                            for(int[] dir : dirs){

                                // Get the neighboring cell by adding the direction to the current cell's coordinates
                                int nr = cell[0] + dir[0];
                                int nc = cell[1] + dir[1];

                                // Check if the neighboring cell is out of bounds or if it is not land ('1'), then we skip it
                                if(nr < 0 || nc < 0 || nr >= rows || nc >= cols)
                                    continue;
                                if(grid[nr][nc] != '1')
                                    continue;

                                // If the neighboring cell is land ('1'), we mark it as visited by changing it to '0' and add it to the queue to continue the BFS traversal
                                grid[nr][nc] = '0';
                                queue.offer(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }

            return noOfIslands;
        }
}

// Scan grid
//   ↓
//Find land
//   ↓
//Start BFS
//   ↓
//Mark entire island visited
//   ↓
//Continue scanning

// for example take this grid:
//1 1 0 0
//1 1 0 0
//0 0 1 0
//0 0 0 1
// here no of islands is 3, because there are 3 groups of connected '1's, the first group is the top left corner, the second group is the middle cell in the third row and the third group is the bottom right corner.