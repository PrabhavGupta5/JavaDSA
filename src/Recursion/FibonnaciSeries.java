package Recursion;

public class FibonnaciSeries {

    // https://leetcode.com/problems/fibonacci-number/description/
    public int fib(int n) {
        // base condition
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;
        // Induction step
        return fib(n-1) + fib(n-2);
    }

    // memoization
    int[] dp = new int[31];
    public int fibdp(int n) {
        if(n <= 1) return n;

        if(dp[n] != 0) return dp[n];

        dp[n] = fibdp(n-1) + fibdp(n-2);

        return dp[n];
    }

    // Bottom Up, Tabulation
    public int fibdp2(int n) {
        if (n <= 1) return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // This is for finding the factorial of a number using recursion
    public int factorial(int n) {
        if(n == 1)
            return 1;
        return n * factorial(n-1);
    }
}
