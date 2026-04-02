package Backtracking;

public class WordSearch {
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index){
        if(index == word.length())
            return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(index))
            return false;

        // we have to start dfs traversal here, mark the character as visited and then unmark for backtracking
        visited[i][j] = true;
//        char temp = board[i][j];
//        board[i][j] = '#';

        boolean isValid = dfs(board, word, i-1, j, index + 1) ||
                dfs(board, word, i+1, j, index + 1) ||
                dfs(board, word, i, j+1, index + 1) ||
                dfs(board, word, i, j-1, index + 1);

        visited[i][j] = false; // backtrack
//        board[i][j] = temp;
        return isValid;

    }

    // we can also solve this without visited array, with just temp variable
}

// Given a board + word,
// check if you can form the word
// by moving in 4 directions
// without reusing cells

// Pick a starting cell →
//match first char →
//explore 4 directions →
//mark visited →
//backtrack