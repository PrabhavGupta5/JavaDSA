package Arrays;

import java.util.HashSet;

public class ValidSudoku {
    // https://leetcode.com/problems/valid-sudoku/description/?envType=problem-list-v2&envId=top-interview-150
    // This problem is solved by using a hashset, we need to check if the number is already present in the row, column or box, if it is present then return false, otherwise add it to the hashset.
    // We can use a single hashset to store the numbers in the row, column and box, we can use a string to represent the number in the row, column and box, for example "5 in row 0", "5 in col 0", "5 in box 0-0" for the number 5 in the first row, first column and first box.
    // This way we can check if the number is already present in the row, column or box by checking if the string is already present in the hashset.
    // Time complexity: O(1) for each cell, total O(9*9) = O(81) = O(1)
    // Space complexity: O(1) for the hashset, since it can only contain at most 27 entries (9 for rows, 9 for columns and 9 for boxes)

    // https://www.youtube.com/watch?v=dgLypIfi9sk
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();

        for(int row = 0; row < 9 ; row++) {
            for(int col = 0; col < 9; col++) {
                char num = board[row][col];

                if (num != '.') {

                    String rowKey = num + " in row " + row;
                    String colKey = num + " in col " + col;
                    String boxKey = num + " in box " + (row / 3) + "-" + (col / 3);

                    if (seen.contains(rowKey) || seen.contains(colKey) || seen.contains(boxKey))
                        return false;

                    seen.add(rowKey);
                    seen.add(colKey);
                    seen.add(boxKey);
                }
            }
        }

        return true;
    }
}
