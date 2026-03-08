package Graphs;

// https://leetcode.com/problems/flood-fill/description/
// We are using a depth-first search (DFS) approach to solve the problem.
// We start from the given starting pixel and change its color to the new color. Then we recursively call the DFS function for its
// neighboring pixels (up, down, left, right) that have the same color as the original color. We continue this process until we have
// changed the color of all connected pixels that have the same original color.

// https://www.youtube.com/watch?v=aehEcTEPtCs
// The time complexity of this solution is O(m*n) where m is the number of rows and n is the number of columns in the image, because in the worst case we might have to visit every pixel in the image. The space complexity is O(m*n) in the worst case when the image is filled with the same color, as we might have to add all pixels to the call stack due to recursion.
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if(oldColor == newColor) // if the old color is the same as the new color, we don't need to do anything, we can return the original image
            return image;
        dfs(image, sr, sc, oldColor, newColor);
        return image;
    }

    public void dfs(int[][] image, int r, int c, int oldColor, int newColor){
        // DFS base case: Array index out of bounds
        if(r < 0 || c < 0 || r >= image.length || c >= image[0].length)
            return;

        // if the color of the current pixel is not the same as the original color, we skip it because we only want to change the color of the pixels that are connected and have the same original color
        if(image[r][c] != oldColor)
            return;

        // Change the color of the current pixel to the new color, marking it as visited so that we don't change it again when we encounter it in the future
        image[r][c] = newColor;

        // DFS recursive calls for the neighboring pixels (up, down, left, right)
        dfs(image, r+1, c, oldColor, newColor);
        dfs(image, r-1, c, oldColor, newColor);
        dfs(image, r, c+1, oldColor, newColor);
        dfs(image, r, c-1, oldColor, newColor);
    }
}

// Flow :

// call dfs(r,c)
//      ↓
//boundary check ❌ → stop
//      ↓
//color match? ❌ → stop
//      ↓
//change color
//      ↓
//visit neighbors