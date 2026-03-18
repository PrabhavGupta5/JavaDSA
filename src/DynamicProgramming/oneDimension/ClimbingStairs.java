package DynamicProgramming.oneDimension;

// this problem is solved by using dynamic programming, we need to use an array to store the number of ways to climb the stairs at each step, and we will use the relation that the number of ways to climb n stairs is the sum of the number of ways to climb n-1 stairs and n-2 stairs, because we can either take 1 step or 2 steps at a time.
// https://leetcode.com/problems/climbing-stairs/description/
// Time complexity: O(N) where N is the number of stairs
// Space complexity: O(N) for the dp array
public class ClimbingStairs {
    public int climbStairs(int n) {
        // base condition
        if(n == 1) return 1;

        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 2;

        // why start from 3? because we have already filled the base cases for 1 and 2 stairs, and we need to fill the dp array from 3 to n stairs using the relation dp[i] = dp[i-1] + dp[i-2]
        for(int i=3; i<=n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        // we are returning dp[n] because it will contain the number of ways to climb n stairs after filling the dp array using the relation
        return dp[n];
    }
}
