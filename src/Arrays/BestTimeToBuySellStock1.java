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

    // DP approach
    // We can also solve this problem using DP, we can keep track of the minimum price we have seen so far and the maximum profit we can get by selling at the current price, and update the maximum profit accordingly.
    // The idea is to iterate through the array of prices and keep track of the minimum price we have seen so far, and for each price, we calculate the profit we would get if we sold at that price (current price - minimum price), and update the maximum profit if the calculated profit is greater than the current maximum profit. This way, we can find the maximum profit in a single pass through the array.
    // https://www.youtube.com/watch?v=excAOvwF_Wk&list=PLgUwDviBIf0pwFf-BnpkXxs0Ra0eU2sJY&index=17
    public int maxProfit(int[] prices) {
        // Use DP
        int min = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > min)
                maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return maxProfit;
    }
}
