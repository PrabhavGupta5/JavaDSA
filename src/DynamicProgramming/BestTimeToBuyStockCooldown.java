package DynamicProgramming;

public class BestTimeToBuyStockCooldown {
    int[][] dp = new int[5001][2];

    public int maxProfit(int[] prices) {
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            dp[i][0] = dp[i][1] = -1;
        }
        return solve(prices, 0, n, true);
    }

    public int solve(int[] prices, int day, int n, boolean buy) {
        // recursion + memoization
        if(day >= n) return 0;
        int profit = 0;
        // We have to maximise the profit, we will see the recursive conditions when we are buying and selling
        int buyIndex = buy ? 1 : 0;

        if(dp[day][buyIndex] != -1) {
            return dp[day][buyIndex];
        }

        if(buy) {
            int take = solve(prices, day+1, n, false) - prices[day];  // if we are buying, then we will call the next day with buy as false and we will subtract the price of the stock from the profit, because we are buying the stock, so we are spending money, so we will subtract the price of the stock from the profit.
            int notTake = solve(prices, day+1, n, true); // if we are not buying, then we will call the next day with buy as true and we will not subtract the price of the stock from the profit, because we are not buying the stock, so we are not spending money, so we will not subtract the price of the stock from the profit.
            profit = Math.max(take, notTake);
        }

        else{
            int sell = prices[day] + solve(prices, day + 2, n, true); // if we are selling, then we will call the day after the next day with buy as true and we will add the price of the stock to the profit, because we are selling the stock, so we are earning money, so we will add the price of the stock to the profit, and we will also skip the next day because of cooldown, so we will call the day after the next day.
            int notSell = solve(prices, day+1, n, false); // if we are not selling, then we will call the next day with buy as false and we will not add the price of the stock to the profit, because we are not selling the stock, so we are not earning money, so we will not add the price of the stock to the profit.
            profit = Math.max(sell, notSell);
        }

        return dp[day][buyIndex] = profit;
    }
}
