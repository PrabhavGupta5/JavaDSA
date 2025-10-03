package DynamicProgramming;

// https://leetcode.com/problems/coin-change-ii/
//https://www.youtube.com/watch?v=I4UR2T6Ro3w&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=16

// This problem is of maximum number of ways
public class CoinChangeII {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] t = new int[n+1][amount+1];

//        for(int i=0;i<n+1;i++){
//            for(int j = 0; j<amount+1; j++){
//                if(i==0)
//                    t[i][j] = 0;  // for arr size 0, we cannot have sum fluctuate so putting 0
//                else if(j==0)
//                    t[i][j] = 1; // there is always an empty subset  for sum = 0
//            }
//        }
        // WE can simplify initialization with this step below :

        // Initialize first row: when i == 0, no subsets possible except sum = 0
        for (int j = 0; j <= amount; j++) {
            t[0][j] = 0;
        }

        // Initialize first column: when j == 0, there's always one subset (empty set)
        for (int i = 0; i <= n; i++) {
            t[i][0] = 1;
        }

        for(int i=1;i<n+1;i++){
            for(int j = 1; j<amount+1; j++){
                if(coins[i-1] <= j)
                    t[i][j] = t[i][j-coins[i-1]] + t[i-1][j];
                else
                    t[i][j] = t[i-1][j];

            }
        }

        return t[n][amount];

    }
}