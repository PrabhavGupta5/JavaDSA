package DynamicProgramming.oneDimension;

// leetcode: https://leetcode.com/problems/decode-ways/description/
// This problem is solved by using dynamic programming, we need to use an array to store the number of ways to decode the string at each
// index, and we will use the relation that the number of ways to decode a string of length n is the sum of the number of ways to decode
// a string of length n-1 and n-2, because we can either take 1 digit or 2 digits at a time, and we need to check if the digits are
// valid (between 1 and 26) before adding them to the count.
// Time complexity: O(N) where N is the length of the string
// Space complexity: O(N) for the dp array

// https://www.youtube.com/watch?v=FEkZxCl_-ik

public class DecodeWays {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for(int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i-1, i));
            int twoDigit = Integer.parseInt(s.substring(i-2, i));

            if(oneDigit >= 1)
                dp[i] += dp[i-1];

            if(twoDigit >= 10 && twoDigit <= 26)
                dp[i] += dp[i-2];

        }

        return dp[n];
    }
}
