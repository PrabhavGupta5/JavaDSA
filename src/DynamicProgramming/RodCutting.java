package DynamicProgramming;

// This problem is unbounded knapsack problem asked in different way

public class RodCutting {

    public static void main(String[] args) {
        // Define the profits and lengths for each possible rod piece.
        int[] price = { 1, 5, 8, 9, 10, 17, 17, 20 }; // Profits associated with rod pieces.
        int[] length = { 1, 2, 3, 4, 5, 6, 7, 8 }; // Lengths of corresponding rod pieces.
        int n = 8; // Total length of the rod.

        // Create a 2D array 'dp' for dynamic programming.
        int[][] dp = new int[price.length + 1][n + 1];

        // Initialize the first row (no rod pieces) and first column (no length) of 'dp' to 0.
        for (int i = 0; i < price.length + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        // Fill in the 'dp' array to compute the maximum profit
        // Unbounded knapsack code
        for (int i = 1; i < price.length + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (length[i - 1] <= j) {
                    // If the current rod piece's length can be accommodated, consider both options:
                    // 1. Cutting the current rod piece and adding its profit to the previous state.
                    // 2. Keeping the current rod piece intact and keeping the previous state.
                    dp[i][j] = Math.max(price[i - 1] + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    // If the current rod piece's length exceeds the available length, exclude it.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Print the maximum profit achievable by cutting the rod.
        System.out.println("Maximum Profit: " + dp[price.length][n]);
    }
}