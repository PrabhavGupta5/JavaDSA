package DynamicProgramming.oneDimension;

// this problem is solved by using dynamic programming, we need to use an array to store the minimum cost to climb the stairs at each step, and we will use the relation that the minimum cost to climb n stairs is the minimum of the cost to climb n-1 stairs plus the cost of the nth stair, and the cost to climb n-2 stairs plus the cost of the (n-1)th stair, because we can either take 1 step or 2 steps at a time.
// https://leetcode.com/problems/min-cost-climbing-stairs/description/
// Time complexity: O(N) where N is the number of stairs
// Space complexity: O(N) for the dp array

public class MinCostToStairs {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] minCost = new int[n+1];
        // base condition, we can start from either the first step or the second step, so the minimum cost to climb 0 stairs is 0 and the minimum cost to climb 1 stair is also 0 because we can start from the first step without paying any cost, and we can also start from the second step without paying any cost, so both cases will have a minimum cost of 0.
        minCost[0] = 0;
        minCost[1] = 0;

        for(int i = 2; i <= n; i++) {
            minCost[i] = Math.min((cost[i-1] + minCost[i-1]), (cost[i-2] + minCost[i-2])); // we are using i-1 and i-2 because we can either take 1 step or 2 steps at a time, so we need to consider both cases to find the minimum cost to climb n stairs and theres only one way to reach top that either by taking 1 step from n-1 or by taking 2 steps from n-2, so we are adding the cost of the current stair to the minimum cost of the previous stairs to find the minimum cost to climb n stairs.
        }
        return minCost[n];

    }
}
