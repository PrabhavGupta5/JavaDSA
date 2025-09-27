package DynamicProgramming;
import java.util.Scanner;

public class Knapsack01 {

    public static int knapsack(int[] wt, int[] val, int W, int n) {
        int[][] t = new int[n + 1][W + 1]; // DP matrix

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    t[i][j] = 0; // base case
                } else if (wt[i - 1] <= j) {
                    int val1 = val[i - 1] + t[i - 1][j - wt[i - 1]]; // take item
                    int val2 = t[i - 1][j]; // skip item
                    t[i][j] = Math.max(val1, val2);
                } else {
                    t[i][j] = t[i - 1][j]; // skip if weight is greater
                }
            }
        }
        return t[n][W];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // number of items
        int[] wt = new int[n];
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }
        int W = sc.nextInt(); // capacity
        System.out.println(knapsack(wt, val, W, n));
        sc.close();
    }
}
