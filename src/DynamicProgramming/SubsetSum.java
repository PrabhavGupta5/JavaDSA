package DynamicProgramming;

public class SubsetSum {

// using recursion ----------

    boolean isSubSet(int arr[], int n, int sum) {
        if (n == 0) {
            return false;
        }
        if (sum == 0) {
            return true;
        }

        if (arr[n - 1] > sum) {
            return isSubSet(arr, n - 1, sum);
        } else {
            return isSubSet(arr, n - 1, sum) || isSubSet(arr, n - 1, sum - arr[n - 1]);
        }
    }

// using Bottom-Up Approach -------------

    boolean isSubsetSum(int[] arr, int sum) {

        int n = arr.length;
        boolean[][]  dp= new boolean[n+1][sum+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    dp[i][j] = false;
                }
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];

    }
}