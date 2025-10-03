package DynamicProgramming;

// Here we don't need to initialize the second row as shown in the video
// Minimum number of coins
public class CoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[][] t = new int[coins.length + 1][amount + 1];

        // Initialize first row (0 coins): 0 coins needed to make 0 amount,
        // Integer.MAX_VALUE-1 for all other amounts
        t[0][0] = 0;
        for (int j = 0; j <= amount; j++) {
            t[0][j] = Integer.MAX_VALUE - 1;
        }
        // Initialize first column (amount 0): 0 coins needed to make amount 0
        for (int i = 0; i <= coins.length; i++) {
            t[i][0] = 0;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    t[i][j] = Math.min(1 + t[i][j - coins[i-1]], t[i-1][j]);
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return (t[coins.length][amount] > amount) ? -1 : t[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(coinChange(coins, amount));
    }
}