package Greedy;

// https://leetcode.com/problems/jump-game-vii/description/
// https://www.youtube.com/watch?v=LQjehUy3AnM
public class JumpGameVII {
    // This will give TLE
    class Solution {
        Boolean[] dp;
        public boolean canReach(String s, int minJump, int maxJump) {

            int n = s.length();
            dp = new Boolean[n+1];
            return solve(0, s, minJump, maxJump);

        }

        public boolean solve(int i, String s, int minJump, int maxJump) {
            if(i == s.length() - 1)
                return true;

            if(dp[i] != null)
                return dp[i];

            // check for all j positions
            for(int jump = minJump; jump <= maxJump; jump++) {
                int j = i + jump;
                if(j > s.length()-1)
                    break;
                if(s.charAt(j) == '0') {
                    if(solve(j, s, minJump, maxJump))
                        return dp[i] = true;
                }
            }

            return dp[i] = false;
        }
    }


    // Here the approach is to use a sliding window to keep track of the number of ways to reach the current position. We will use an
    // array t to keep track of the number of ways to reach each position. We will also use a variable count to keep track of the number
    // of ways to reach the current position. We will iterate through the string and for each position j, we will check if we can jump
    // from j - minJump to j, if yes then we will add the number of ways to reach j - minJump to count. We will also check if we can
    // jump from j - maxJump - 1 to j, if yes then we will subtract the number of ways to reach j - maxJump - 1 from count because we
    // are only interested in the number of ways to reach j. Finally, if count is greater than 0 and s.charAt(j) is '0', then we can
    // reach j and we will set t[j] to 1. At the end, we will return true if t[n-1] is greater than 0, otherwise false.

    class Solution2 {
        public boolean canReach(String s, int minJump, int maxJump) {
            int n = s.length();
            int[] t = new int[n];
            //t[i] > 0 : possible to reach i
            // == 0 : not possible to reach i

            t[0] = 1;
            int count = 0;

            for (int j = 1; j <= n - 1; j++) {
                if (j - minJump >= 0) { // we can jump from j - minJump to j
                    count += t[j - minJump];
                }

                if (j - maxJump - 1 >= 0) { // we can jump from j - maxJump - 1 to j, but we have to remove the count of j - maxJump - 1 because we are only interested in the count of jumps that can reach j
                    count -= t[j - maxJump - 1];
                }

                if (count > 0 && s.charAt(j) == '0') {
                    t[j] = 1;
                }
            }

            return t[n - 1] > 0;
        }
    }
}
