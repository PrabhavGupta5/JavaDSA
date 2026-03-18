package DynamicProgramming.oneDimension;

// this problem is solved by using dynamic programming, we need to use an array to store the maximum amount of money that can be robbed at each house, and we will use the relation that the maximum amount of money that can be robbed at the current house is the maximum of the amount of money that can be robbed at the previous house and the amount of money that can be robbed at the house before the previous house plus the amount of money at the current house, because we cannot rob two adjacent houses, so we need to consider both cases to find the maximum amount of money that can be robbed at the current house.
// https://leetcode.com/problems/house-robber-ii/description/
// Time complexity: O(N) where N is the number of houses
// Space complexity: O(N) for the dp array
// https://www.youtube.com/watch?v=ucmqYGVGQK8&list=PLFdAYMIVJQHPXtFM_9mpwwQtIdzP6kxHS&index=6
public class HouseRobberII {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n==1) return nums[0]; // base condition, if there is only one house, we can only rob that house, so we return the amount of money at that house.
        if(n == 2) return Math.max(nums[0], nums[1]); // base condition, if there are two houses, we can only rob one of them, so we return the maximum of the amount of money at the first house and the amount of money at the second house, because we cannot rob two adjacent houses, so we need to consider both cases to find the maximum amount of money that can be robbed when there are two houses.

        // skip last house
        int[] loot1 = new int[n];
        loot1[0] = nums[0];
        loot1[1] = Math.max(nums[0], nums[1]);

        for(int i = 2; i<=n-2; i++) {
            loot1[i] = Math.max((loot1[i-2] + nums[i]), loot1[i-1]);
        }

        // skip first house
        int[] loot2 = new int[n];
        loot2[1] = nums[1];
        loot2[2] = Math.max(nums[1], nums[2]);

        for(int i = 3; i<=n-1; i++) {
            loot2[i] = Math.max((loot2[i-2] + nums[i]), loot2[i-1]);
        }

        return Math.max(loot1[n-2], loot2[n-1]);
    }
}
