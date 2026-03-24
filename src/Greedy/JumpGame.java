package Greedy;

// https://leetcode.com/problems/jump-game/description/
// https://www.youtube.com/watch?v=Gtugy3mRV-A
public class JumpGame {
    public boolean canJump(int[] nums) {
        // we have to maintain finalPosition pointer at last;
        int finalPosition = nums.length - 1;

        for(int index = nums.length - 2; index >= 0; index--) {
            if(index + nums[index] >= finalPosition) // Here why we are adding the index and the value at that index is because we are checking if we can jump from that index to the final position or not, if we can jump from that index to the final position, then we will update the final position to that index, because we can jump from that index to the final position, so we can say that we can jump from that index to the final position, so we will update the final position to that index.
                finalPosition = index;
        }

        return finalPosition == 0;

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
