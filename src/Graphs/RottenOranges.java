package Graphs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/description/
// We are using a breadth first search (BFS) approach to solve this problem. We start by adding all the rotten oranges to
// the queue and counting the number of fresh oranges. Then we perform a BFS on the grid, at each step we rot the adjacent fresh
// oranges and add them to the queue. We keep track of the number of minutes it takes to rot all the oranges. If there are still
// fresh oranges left after the BFS, we return -1, otherwise we return the number of minutes it took to rot all the oranges.
public class RottenOranges {
    class RottenOrangesSolution {
        public int orangesRotting(int[][] grid) {

            int rows = grid.length;
            int cols = grid[0].length;

            Queue<int[]> queue = new LinkedList<>();

            int fresh = 0;

            // STEP 1: initialize queue
            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){

                    if(grid[i][j] == 2)
                        queue.offer(new int[]{i, j});

                    if(grid[i][j] == 1)
                        fresh++;
                }
            }

            if(fresh == 0) return 0;

            // STEP 2: direction array
            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

            int minutes = 0;

            // STEP 3: BFS
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){

                    // Get one rotten orange from the queue example : [0, 2] which is the position of the rotten orange in the grid
                    int[] cell = queue.poll();
                    int r = cell[0];
                    int c = cell[1];

                    // Check all 4 directions for the neighboring cells of the rotten orange
                    // In the first iteration, dir = [1, 0] which means we are checking the cell below the rotten orange, in the second iteration dir = [-1, 0] which means we are checking the cell above the rotten orange, in the third iteration dir = [0, 1] which means we are checking the cell to the right of the rotten orange and in the fourth iteration dir = [0, -1] which means we are checking the cell to the left of the rotten orange
                    for(int[] dir : dirs){

                        // it gives neighbor cell, neighboring cell example : [1, 2] which is the position of the neighboring cell in the grid
                        int nr = r + dir[0];
                        int nc = c + dir[1];

                        // Check if the neighboring cell is out of bounds or if it is not a fresh orange, if it is out of bounds or not a fresh orange we skip it
                        if(nr < 0 || nc < 0 || nr >= rows || nc >= cols)
                            continue;
                        if(grid[nr][nc] != 1)
                            continue;

                        // If it is a fresh orange, we rot it and add it to the queue and decrease the count of fresh oranges
                        grid[nr][nc] = 2;
                        queue.offer(new int[]{nr, nc});
                        fresh--;
                    }
                }
                minutes++;
            }

            return fresh == 0 ? minutes - 1 : -1;
        }
    }
}
