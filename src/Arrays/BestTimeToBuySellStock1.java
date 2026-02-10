package Arrays;

public class BestTimeToBuySellStock1 {
    // https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
    // https://www.youtube.com/watch?v=E2-heUEnZKU&t=5s
    // This is kadane's variant or DP you can say
    class Solution {
        public int maxProfit(int[] prices) {
            int buyPrice = prices[0];
            int maxProfit = 0;
            int currProfit = 0;

            for(int i = 1; i < prices.length; i++) {
                if (prices[i] < buyPrice)
                    buyPrice = prices[i];  // if new price is lower update buy price

                else {
                    currProfit = prices[i] - buyPrice; // try to sell at higher price
                    maxProfit = Math.max(currProfit, maxProfit);
                }
            }
            return maxProfit;
        }
    }
}
