package Graphs;

// https://leetcode.com/problems/surrounded-regions/description/
// The idea is to start DFS from the borders of the board and mark all the 'O's that are connected to the borders as safe
// (we can use a temporary marker like '#'). After that, we can flip all the remaining 'O's to 'X' and then flip back the safe
// 'O's to 'O'.
// Time complexity: O(M*N) where M is the number of rows and N is the number of columns in the board

public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };

        solve(board);

        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    // Directions for DFS (down, up, right, left)
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public static void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // Start DFS from borders
        for(int i = 0; i < rows; i++){ // scan left column, scan right column
            dfs(board, i, 0);
            dfs(board, i, cols - 1);
        }

        for(int j = 0; j < cols; j++){ // scan top row, top column
            dfs(board, 0, j);
            dfs(board, rows - 1, j);
        }

        // Flip surrounded regions
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){

                // Flip the surrounded regions to 'X'
                if(board[i][j] == 'O')
                    board[i][j] = 'X';

                // Flip back the non-surrounded regions
                else if(board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private static void dfs(char[][] board, int r, int c){

        // Check for out of bounds
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length)
            return;

        // If the cell is not 'O', we return as we are only interested in 'O' cells that are connected to the border
        if(board[r][c] != 'O')
            return;

        // Mark the cell as visited by changing it to '#', these are safe 'O's that are connected to the border and should not be flipped to 'X'
        board[r][c] = '#';

        // Explore the four directions (down, up, right, left) to find all connected 'O's
        dfs(board, r+1, c);
        dfs(board, r-1, c);
        dfs(board, r, c+1);
        dfs(board, r, c-1);
    }
}
