package BinarySearch;

public class Search2DMatrix {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/search-a-2d-matrix/
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int low = 0, high = m * n - 1;

            while (low <= high){
                int mid = low + (high-low)/2;
                int row = mid / n;
                int col = mid % n;
                if(matrix[row][col] == target)
                    return true;
                else if(matrix[row][col] < target)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            return false;
        }
    }

    // https://leetcode.com/problems/search-a-2d-matrix-ii/
    class Solution2 {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int row = 0, col = n - 1;

            while (row < m && col >= 0){
                if(target == matrix[row][col])
                    return true;
                else if(target < matrix[row][col])
                    col--;
                else
                    row++;
            }
            return false;
        }
    }
}
