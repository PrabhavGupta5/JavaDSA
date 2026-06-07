package Greedy;

// https://leetcode.com/problems/jump-game-ii/description/
// Same as Minimum number of taps to water a garden, but here we have to jump to the end of the array, and we have to find the minimum number of jumps to reach the end of the array, and we can jump from any position to any position within the range of that position, so we will use a greedy approach to find the maximum range of each position, and then we will keep jumping until we reach the end of the array, and we will keep track of the number of jumps we have made, and return that as the answer.
public class JumpGameII {
    public int jump(int[] nums) {
        // new startEnd array that will store the maximum range of ith position
        int[] startEnd = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            startEnd[i] = i + nums[i];

        }

        // Now we have populated our startEnd array with the maximum range of each position, now we have to find the minimum number of
        // jumps to reach the end of the array, so we will start from the first position and keep jumping until we reach the end of the
        // array, and we will keep track of the maximum range of each jump, and when we reach the end of the current jump, we will make
        // a jump and update the current end to the maximum range of the next jump, and we will keep doing this until we reach the end
        // of the array, and we will keep track of the number of jumps we have made, and return that as the answer.
        // we will start greedy approach
        int minJumps = 0, currEnd = 0, maxEnd = 0;
        for(int i = 0; i < nums.length - 1; i++) {
            maxEnd = Math.max(maxEnd, startEnd[i]);

            if(i == currEnd) { // if we have reached the end of the current jump, then we need to make a jump
                minJumps++;
                currEnd= maxEnd;
            }

        }

        return minJumps;

    }
}
