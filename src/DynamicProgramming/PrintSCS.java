package DynamicProgramming;

// This question is LCS + printing LCS plus a tweak
// https://leetcode.com/problems/shortest-common-supersequence/description/
// https://www.youtube.com/watch?v=VDhRg-ZJTuc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=30

public class PrintSCS {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();

        int[][] t = new int[m+1][n+1];

        for(int i=0; i<m+1; i++)
            t[i][0] = 0;
        for(int j=0; j<n+1; j++)
            t[0][j] = 0;

        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
            }
        }

        int i = m;
        int j = n;
        StringBuilder s = new StringBuilder();

        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                s.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else {
                if(t[i][j-1]>t[i-1][j]){
                    s.append(str2.charAt(j-1));
                    j--;
                }
                else {
                    s.append(str1.charAt(i-1));
                    i--;
                }
            }
        }

        while(i>0){
            s.append(str1.charAt(i-1));
            i--;
        }

        while(j>0){
            s.append(str2.charAt(j-1));
            j--;
        }

        return s.reverse().toString();
    }
}