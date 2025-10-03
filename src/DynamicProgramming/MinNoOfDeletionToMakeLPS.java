package DynamicProgramming;
// https://www.youtube.com/watch?v=CFwCCNbRuLY&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=28
// There's a LC question that is asking no of insertion but it is actually same as no of deletions
// https://leetcode.com/problems/minimum-insertion-steps-to-make-a-string-palindrome/

public class MinNoOfDeletionToMakeLPS {
    public int minInsertions(String s) {
        String s2 = new StringBuilder(s).reverse().toString();
        int lps = LCS(s,s2);

        return s.length() - lps;
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
