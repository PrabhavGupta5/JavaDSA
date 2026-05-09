package Arrays.Matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/cyclically-rotating-a-grid/?envType=daily-question&envId=2026-05-09

// https://www.youtube.com/watch?v=eg8zMZKz8qk
public class RotatingGridByK {
    public int[][] rotateGrid(int[][] grid, int k) {
        // going each layer by layer, Track how many layers are there,
        // put the elements into ArrayList and then rotate by one then put back into grid

        int m = grid.length, n = grid[0].length;
        int layers = Math.min(m/2, n/2);

        // have to iterate now
        for(int l = 0; l < layers; l++) {
            List<Integer> nums = new ArrayList<>();
            int left = l;
            int right = n - l - 1;
            int bottom = m - l - 1;
            int top = l;
            // top row
            for(int j = left; j < right;  j++)
                nums.add(grid[top][j]);

            // right col
            for(int i = top; i < bottom; i++)
                nums.add(grid[i][right]);

            // bottom row
            for(int j = right; j > left; j--)
                nums.add(grid[bottom][j]);

            // left col
            for(int i = bottom; i > top; i--)
                nums.add(grid[i][left]);

            int len = nums.size();
            int rotate = k % len;
            Collections.rotate(nums, -rotate);

            int index = 0;
            // putting back the elements by rotating
            // top row
            for(int j = left; j < right;  j++)
                grid[top][j] = nums.get(index++);

            // right col
            for(int i = top; i < bottom; i++)
                grid[i][right] = nums.get(index++);

            // bottom row
            for(int j = right; j > left; j--)
                grid[bottom][j] = nums.get(index++);

            // left col
            for(int i = bottom; i > top; i--)
                grid[i][left] = nums.get(index++);

        }
        return grid;

    }
}
