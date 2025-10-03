package DynamicProgramming;

import java.util.Collections;

// https://leetcode.com/problems/delete-operation-for-two-strings/
// https://www.youtube.com/watch?v=-fx6aDxcWyg&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=26
public class MinNoOfOperations {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            int[][] t = new int[m+1][n+1];
            // To reverse a String
            // String s2 = new StringBuilder(word1).reverse().toString();

            for(int i=0; i<m+1; i++)
                t[i][0] = 0;
            for(int j=0; j<n+1; j++)
                t[0][j] = 0;

            for(int i=1; i<m+1; i++){
                for(int j=1; j<n+1; j++){

                    if(word1.charAt(i-1)== word2.charAt(j-1))
                        t[i][j] = 1 + t[i-1][j-1];
                    else {
                        t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
                    }
                }
            }

            return (m - t[m][n]) + (n - t[m][n]);
        }

}