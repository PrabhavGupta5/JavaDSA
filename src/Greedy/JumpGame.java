package Greedy;
import java.util.Arrays;

// https://leetcode.com/problems/jump-game/description/
// https://www.youtube.com/watch?v=Gtugy3mRV-A
public class JumpGame {
//    public boolean canJump(int[] nums) {
//        // we have to maintain finalPosition pointer at last;
//        int finalPosition = nums.length - 1;
//
//        for(int index = nums.length - 2; index >= 0; index--) {
//            if(index + nums[index] >= finalPosition) // Here why we are adding the index and the value at that index is because we are checking if we can jump from that index to the final position or not, if we can jump from that index to the final position, then we will update the final position to that index, because we can jump from that index to the final position, so we can say that we can jump from that index to the final position, so we will update the final position to that index.
//                finalPosition = index;
//        }
//
//        return finalPosition == 0;
//
//    }

    // Here we will maintain a variable maxReachable which will keep track of the maximum index we can reach at any point in time. We will iterate through the array and for each index, we will check if it is greater than maxReachable, if it is then we cannot reach that index and we will return false. If it is not then we will update maxReachable to be the maximum of maxReachable and the current index plus the value at that index, which represents the maximum index we can reach from that index. If we can iterate through the entire array without returning false, then we can reach the end of the array and we will return true.
    // https://www.youtube.com/watch?v=pvg0yrD-E5w
    public boolean canJump(int[] nums) {
        int maxReachable = 0;

        for(int i = 0; i < nums.length; i++) {
            if(i > maxReachable)
                return false;
            maxReachable = Math.max(maxReachable, i + nums[i]);
        }

        return true;
    }

    // DP approach, top down, but it will give TLE
    class Solution {
        int[] dp = new int[10001];
        public boolean canJump(int[] nums) {
            Arrays.fill(dp, -1);
            return solve(nums, nums.length, 0);
        }

        public boolean solve(int[] nums, int n, int idx) {
            if (idx >= n - 1)
                return true;
            if (dp[idx] != -1)
                return dp[idx] == 1;

            for (int jump = 1; jump <= nums[idx]; jump++) {
                if (solve(nums, n, idx + jump)) {
                    dp[idx] = 1;
                    return true;
                }
            }

            dp[idx] = 0; // if we are here then it means we cannot reach the end from this index, so we will mark it as 0 in dp array and return false
            return false;
        }
    }


// https://leetcode.com/problems/jump-game-ii/description/
    // JUMP GAME II
    public int jump(int[] nums) {
        int jumps = 0;
        int end = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {

            // keep updating how far we can go
            farthest = Math.max(farthest, i + nums[i]);

            // if we reached end of current jump
            if (i == end) { // if we have reached the end of the current jump, it means we need to make another jump to continue moving forward, so we will increment the jumps variable by 1 to indicate that we are taking another jump, and then we will update the end variable to be the farthest position we can reach with the next jump, which is stored in the farthest variable, so that we can continue moving forward in the next iteration of the loop.
                jumps++;           // take jump
                end = farthest;    // update new range
            }
        }

        return jumps;
    }



    // example of jump game 2
    // Input: nums = [2,3,1,1,4]
    // Output: 2
    // Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
    
}
