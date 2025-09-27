package DynamicProgramming;

// https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9

public class CountSubsetSum {

    int isSubSet(int[] arr, int n, int sum) {
        // here i is no of ele(size of array) and j is in sum direction (sum)
        int[][] dp = new int[ n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 0; // cuz for subset problem, it is false that means we have zero number of subsets, so 0
                }
                if (j == 0) {
                    dp[i][j] = 1; // We had only one subset which was empty subset, so 1 count
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] + dp[i - 1][j]; // to calculate no of subsets(count) we will add the possibility of finding a new subset
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum]; // Return the last block of the matrix

    }
}