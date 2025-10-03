package DynamicProgramming;

public class LongestCommonSubstring {
    static int LongestCommonSbstring(String X, String Y) {

        int m = X.length();
        int n = Y.length();
        int[][] dp = new int[m+1][n+1];
        int[] nums = {2,234, 5,2, 52};


        // initialization
        for (int i = 0; i <= m; i++)
            dp[i][0] = 0;   // Eg LCS of "abc" & "" = 0
        for (int j = 0; j <= n; j++)
            dp[0][j] = 0;   // Eg LCS of "" & "abc" = 0

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i-1) == Y.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = 0;          // ONLY THIS CHANGE from base LCS, We are breaking if it is not continuous
            }
        }
        int maxLen = 0;              // Now finding the max element in the matrix cuz it can store anywhere in the matrix
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++)
                maxLen = Math.max(maxLen, dp[i][j]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String a = "abcsds";
        String b = "abrty";
        int result = LongestCommonSbstring(a,b);
        System.out.println("Maximum length of substring is : " + result);
    }
}