package DynamicProgramming.oneDimension;

// this problem is solved by using dynamic programming, we need to use an array to store the maximum amount of money that can be robbed at each house, and we will use the relation that the maximum amount of money that can be robbed at the current house is the maximum of the amount of money that can be robbed at the previous house and the amount of money that can be robbed at the house before the previous house plus the amount of money at the current house, because we cannot rob two adjacent houses, so we need to consider both cases to find the maximum amount of money that can be robbed at the current house.
// https://leetcode.com/problems/house-robber/description/
// Time complexity: O(N) where N is the number of houses
// Space complexity: O(N) for the dp array
// https://www.youtube.com/watch?v=VXqUQYGMnQg&list=PLFdAYMIVJQHPXtFM_9mpwwQtIdzP6kxHS&index=5

public class HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] loot = new int[n];
        if(n==1) return nums[0];

        // base condition, the maximum amount of money that can be robbed at the first house is the amount of money at the first house, and the maximum amount of money that can be robbed at the second house is the maximum of the amount of money at the first house and the amount of money at the second house, because we cannot rob two adjacent houses, so we need to consider both cases to find the maximum amount of money that can be robbed at the second house.
        loot[0] = nums[0];
        loot[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i<=n-1; i++) {
            loot[i] = Math.max((loot[i-2] + nums[i]), loot[i-1]); // think of it from nth house perspective, we can either rob the current house and add the amount of money at the current house to the maximum amount of money that can be robbed at the house before the previous house, or we can skip the current house and take the maximum amount of money that can be robbed at the previous house, so we are taking the maximum of both cases to find the maximum amount of money that can be robbed at the current house.
        }

        return loot[n-1];
    }
}
