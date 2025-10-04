package DynamicProgramming;

// https://leetcode.com/discuss/post/1274765/longest-repeated-subsequence-lrs-by-vidh-e7a7/
public class LongestRepeatedSubs {

int LCS(String X, String Y) {           // or call it --> int LRS(string X, string Y)

    int m=X.length();
    int n=Y.length();
    int[][] dp = new int[m+1][n+1];

    // initialization
    for(int i=0;i<=m;i++)
        dp[i][0]=0;   // Eg LCS of "abc" & "" = 0
    for(int j=0;j<=n;j++)
        dp[0][j]=0;   // Eg LCS of "" & "abc" = 0

    for(int i=1;i<=m;i++)
    {
        for(int j=1;j<=n;j++)
        {
            if(X.charAt(i-1)==Y.charAt(j-1) && i!=j)     // this is the only extra condition
                dp[i][j]=1+dp[i-1][j-1];
            else dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        }
    }
    return dp[m][n];
}
}