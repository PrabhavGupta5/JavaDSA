package DynamicProgramming;


// https://www.youtube.com/watch?v=823Grn4_dCQ&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=25

public class LengthSCS {

    int LCS(String X, String Y) {
        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m + 1][n + 1];

        // initialization
        for (int i = 0; i <= m; i++)
            dp[i][0] = 0;   // Eg LCS of "abc" & "" = 0
        for (int j = 0; j <= n; j++)
            dp[0][j] = 0;   // Eg LCS of "" & "abc" = 0

        // LCS Code
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

    int SCS(String X, String Y, int m, int n) {
        return m + n - LCS(X, Y); // This will give the length of SCS
    }
}