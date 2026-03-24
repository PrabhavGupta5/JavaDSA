package Arrays.Matrix;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }
}

// Example:
// Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
// Step 1: Transpose the matrix
// After transposition, the matrix becomes [[1,4,7],[2,5,8],[3,6,9]]
// Step 2: Reverse each row
// After reversing each row, the matrix becomes [[7,4,1],[8,5,2],[9,6,3]]
// Output: [[7,4,1],[8,5,2],[9,6,3]]