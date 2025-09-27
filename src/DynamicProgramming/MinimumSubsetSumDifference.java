package DynamicProgramming;
import java.util.*;

// This problem is quite tricky, but it's an extension of equal sum partition, have to use subset problem code and give the minimum in a range

// https://www.youtube.com/watch?v=-GtpxG6l_Mc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=10
public class MinimumSubsetSumDifference {

    // Returns list of all subset sums possible using array elements
    static List<Integer> isSubsetPoss(int[] arr, int n, int sum) {
        boolean[][] t = new boolean[n + 1][sum + 1];

        // Initialization: sum 0 is reachable with empty subset
        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }
        for (int j = 1; j <= sum; j++) {
            t[0][j] = false;
        }

        // Fill the DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j)
                    t[i][j] = t[i - 1][j - arr[i - 1]] || t[i - 1][j];
                else
                    t[i][j] = t[i - 1][j];
            }
        }

        // Have to take last row of matrix of subset sum and if the value is true fill the value in a list
        List<Integer> v = new ArrayList<>();
        for (int j = 0; j <= sum; j++) {
            if (t[n][j] == true) {
                v.add(j);
            }
        }
        return v;
    }

    // Returns minimum difference between sum of two subsets
    static int minSubsetSumDiff(int[] arr, int n) {
        int range = 0;
        for (int i = 0; i < n; i++)
            range += arr[i];

        List<Integer> v = isSubsetPoss(arr, n, range);

        int mn = Integer.MAX_VALUE;
        for (int val : v) {
            mn = Math.min(mn, Math.abs(range - 2 * val));
        }

        return mn;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println(minSubsetSumDiff(arr, n));
        sc.close();
    }
}
