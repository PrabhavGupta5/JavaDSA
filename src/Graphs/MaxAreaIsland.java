package Graphs;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/max-area-of-island/description/
public class MaxAreaIsland {
    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxArea = 0;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] == 1) {

                    int area = 0;

                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 0;

                    while (!queue.isEmpty()) {

                        int[] cell = queue.poll();
                        // For each cell that we visit, we increment the area by 1 because it is part of the island
                        area++;

                        for (int[] dir : dirs) {

                            int nr = cell[0] + dir[0];
                            int nc = cell[1] + dir[1];

                            if (nr < 0 || nc < 0 || nr >= rows || nc >= cols)
                                continue;

                            if (grid[nr][nc] != 1)
                                continue;

                            // If the neighboring cell is land ('1'), we mark it as visited by changing it to '0' and add it to the queue to continue the BFS traversal
                            grid[nr][nc] = 0;
                            queue.offer(new int[]{nr, nc});
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }
}
