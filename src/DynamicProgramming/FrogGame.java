package DynamicProgramming;

import java.util.Arrays;


import java.util.HashMap;

public class FrogGame {
    // https://leetcode.com/problems/frog-jump/
    // example: stones = [0,1,3,5,6,8,12,17]
    // Output: true
    // Explanation: The frog can jump to the last stone by jumping 1 unit to the second stone, then 2 units to the third stone, then 2 units to the fourth stone, then 3 units to the sixth stone, then 4 units to the seventh stone, and then 5 units to the eighth stone.
    // mik video :
    static class Solution {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int[][] t = new int[2001][2001];
        int n;

        boolean solve(int[] stones, int currStoneIndex, int prevJump) {
            if(currStoneIndex == n-1) // if we have reached the last stone, then we can return true
                return true;

            boolean result = false; // we will check for the next jump which can be prevJump-1, prevJump, prevJump+1, and if any of them is true then we can return true

            if(t[currStoneIndex][prevJump] != -1)
                return t[currStoneIndex][prevJump] == 1;

            for(int nextJump = prevJump-1; nextJump <= prevJump+1; nextJump++) {
                if(nextJump > 0) {
                    int nextStone = stones[currStoneIndex] + nextJump;
                    if(mp.containsKey(nextStone))
                        result = result || solve(stones, mp.get(nextStone), nextJump);
                }
            }

            t[currStoneIndex][prevJump] = result ? 1 : 0;
            return result;
        }

        public boolean canCross(int[] stones) {
            n = stones.length;
            if (stones[1] != 1)
                return false;

            for (int i = 0 ; i < stones.length; i++)
                mp.put(stones[i], i);

            for (int[] row : t)
                Arrays.fill(row, -1);

            return solve(stones, 0, 0);
        }
    }
}
