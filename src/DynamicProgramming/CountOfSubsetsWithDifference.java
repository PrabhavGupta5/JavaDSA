package DynamicProgramming;

// This problem is nothing but simple maths calculation with Count Subset problem
// https://www.youtube.com/watch?v=ot_XBHyqpFc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=11

public class CountOfSubsetsWithDifference {

    int countSubsetSum(int[] a, int n, int sum) {
        // Initializing the matrix
        int[][] dp = new int[n + 1][sum + 1];
        // Initializing the first value of matrix
        dp[0][0] = 1;
        for (int i = 1; i < sum+1; i++)
            dp[0][i] = 0;
        for (int i = 1; i < n+1; i++)
            dp[i][0] = 1;

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                // if the value is greater than the sum
                if (a[i - 1] <= j)
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-a[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }

        return dp[n][sum];
    }

    int countWithGivenSum(int[] arr, int n, int diff) {
        int sumArr = 0;
        for (int i = 0; i < n; i++)
            sumArr += arr[i];

        int reqSum = (diff + sumArr) / 2;
        return countSubsetSum(arr, n, reqSum);
    }
}