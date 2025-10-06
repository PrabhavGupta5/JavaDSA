package DynamicProgramming;

import java.util.Arrays;

// https://www.youtube.com/watch?v=kMK148J9qEE&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=33&pp=iAQB
public class MCM {
    int[][] dp = new int[501][501];

    int solve(int i, int j, int[] arr) {
        if(i>=j)return 0;

        if(dp[i][j]!=-1)
            return dp[i][j];

        int ans=Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++) {
            int tempAns = solve(i,k,arr) + solve(k+1,j,arr) + arr[i-1]*arr[k]*arr[j];
            ans=Math.min(ans,tempAns);
        }
        return dp[i][j] = ans;
    }

    int matrixMultiplication(int N, int[] arr) {
        // Initialize the dp array with -1 before solving
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return solve(1,N-1,arr);
    }
}
