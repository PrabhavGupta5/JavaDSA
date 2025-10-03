package DynamicProgramming;

// https://leetcode.com/problems/longest-palindromic-subsequence/
// In this question we will create another String to find LCS
public class LongestPalindromeSubsequence {

    public int longestPalindromeSubseq(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        return LCS(s,s2);
    }

    public int LCS(String a, String b){
        int m = a.length();
        int n = b.length();

        int[][] t = new int[m+1][n+1];

        for(int i=0; i<m+1; i++)
            t[i][0] = 0;
        for(int j=0; j<n+1; j++)
            t[0][j] = 0;

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(a.charAt(i-1)==b.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else {
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
                }
            }
        }

        return t[m][n];
    }
}