import java.util.*;

public class GoldmanQuestions {
    // [
    // ["Bob",90],
    // ["Alice",80],
    // ["Bob",70]
    //]

    // avg = sum/count

    public static double maxAverage(String[][] records) {
        Map<String, Integer> sum = new HashMap<>();
        Map<String, Integer> count = new HashMap<>();

        for (String[] record : records) {
            String student = record[0];
            int marks = Integer.parseInt(record[1]);

            sum.put(student, sum.getOrDefault(student, 0) + marks);

            count.put(student, count.getOrDefault(student, 0) + 1);
        }
        double maxAvg = 0;

        for (String student : sum.keySet()) {
            double avg = (double) sum.get(student) / count.get(student);
            maxAvg = Math.max(maxAvg, avg);
        }

        return maxAvg;
    }

    // max stone
    // Maximum stones till here
    //=
    //current stones
    //+
    //best previous path
    public static int maxStones(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows][cols];

        dp[rows - 1][0] = grid[rows - 1][0]; // we are filling the last row of the dp array, so we need to initialize the last cell of the first column of the dp array with the value of the last cell of the first column of the grid

        for (int r = rows - 2; r >= 0; r--) { // we are filling the first column of the dp array
            dp[r][0] = dp[r + 1][0] + grid[r][0]; // why r + 1 ? because we are filling the dp array from bottom to top, so we need to add the value of the cell below the current cell in the dp array to the value of the current cell in the grid to get the value of the current cell in the dp array
        }

        for (int c = 1; c < cols; c++) { // we are filling the last row of the dp array
            dp[rows - 1][c] = dp[rows - 1][c - 1] + grid[rows - 1][c];
        }

        for (int r = rows - 2; r >= 0; r--) { // we are filling the rest of the dp array
            for (int c = 1; c < cols; c++) {
                dp[r][c] = grid[r][c] + Math.max(dp[r + 1][c], dp[r][c - 1]);
            }
        }

        return dp[0][cols - 1];
    }

    // largest component in forest
    public static int largestTreeRoot(int[][] pairs) {
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        Set<Integer> nodes = new HashSet<>();

        for (int[] pair : pairs) {
            int child = pair[0];
            int parent = pair[1];

            graph.computeIfAbsent(parent, k -> new ArrayList<>()).add(child);
            children.add(child);

            nodes.add(child);
            nodes.add(parent);
        }

        int answerRoot = -1;
        int maxSize = 0;

        for (int node : nodes) {
            if (!children.contains(node)) {
                int size = dfs(node, graph);
                if (size > maxSize || (size == maxSize && node > answerRoot)) {
                    maxSize = size;
                    answerRoot = node;
                }
            }
        }

        return answerRoot;
    }

    private static int dfs(int node, Map<Integer, List<Integer>> graph) {
        int count = 1;

        for (int child : graph.getOrDefault(node, Collections.emptyList()))
            count += dfs(child, graph);

        return count;
    }




    // Best time to buy and sell stock III ( Atmost 2 transactions allowed)
    // buy1  = max profit after first buy
    // sell1 = max profit after first sell
    //
    // buy2  = max profit after second buy
    // sell2 = max profit after second sell
    public int maxProfit(int[] prices) {
        int sell1 = 0, sell2 = 0, buy1 = Integer.MIN_VALUE, buy2 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.max(buy1, -prices[i]);

            sell1 = Math.max(sell1, buy1 + prices[i]);

            buy2 = Math.max(buy2, sell1 - prices[i]);

            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }



    // Best time to buy and sell stock IV  (Atmost K transactions allowed)
    public int maxProfitK(int k, int[] prices) {
        if (k == 0 || prices.length == 0) return 0;

        int n = prices.length;
//        if (k >= n / 2) { // If k is large enough, we can make as many transactions as we want
//            int maxProfit = 0;
//            for (int i = 1; i < n; i++) {
//                if (prices[i] > prices[i - 1]) {
//                    maxProfit += prices[i] - prices[i - 1]; // We can profit from every increase in price
//                }
//            }
//            return maxProfit;
//        }

        // buy[j] stores the maximum profit after performing the j-th buy, and sell[j] stores the maximum profit after performing the
        // j-th sell. For each price, we either keep the previous state or perform the current buy/sell operation. The transition for
        // buying is sell[j-1] - price, since we must complete j-1 transactions before the j-th buy. The transition for selling is buy[j] + price.
        // This generalizes the buy1/sell1/buy2/sell2 solution of Stock III to k transactions, giving O(nk) time and O(k) space.

        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);

        for (int price : prices) {
            for (int j = 1; j <= k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }

        return sell[k];
    }


    // Equal Sum Partition
    class Solution {
        public static boolean solve(int n,int[] nums,int sum){
            boolean[][] t = new boolean[n+1][sum+1];

            // initialization of matrix base condition
            for(int i=0;i<n+1;i++){
                for(int j=0;j<sum+1;j++){
                    if(i==0)
                        t[i][j]=false;
                    if(j==0)
                        t[i][j]=true;
                }
            }


            // filling all elements with matrix
            for(int i=1;i<n+1;i++){
                for(int j=1;j<sum+1;j++){
                    if(nums[i-1]<=j)
                        t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];
                    else if(nums[i-1]>j)
                        t[i][j] = t[i-1][j];
                }
            }

            return t[n][sum];
        }
        public boolean canPartition(int[] nums) {
            int sum = 0;
            int n = nums.length;
            for(int i=0;i<n;i++){
                sum += nums[i];
            }
            if(sum%2 == 0)
                return solve(n,nums,sum/2);
            else
                return false;
        }
    }

    // Cycle Array Length
    public static int cycleLength(int[] arr) {
        int slow = 0;
        int fast = 0;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        int length = 1;
        fast = arr[slow]; // we can also do fast = arr[fast], but we are doing fast = arr[slow] because we want to start from the point where slow and fast met, and we want to move fast one step at a time to count the length of the cycle. If we do fast = arr[fast], we will be moving fast two steps at a time, which will not give us the correct length of the cycle.

        while (fast != slow) { // we are moving fast one step at a time until it meets slow again, which means we have completed one full cycle, and the length variable will give us the length of the cycle.
            fast = arr[fast];
            length++;
        }

        return length;
    }


    // Coin Change Minimum number of coins

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1); // we are filling the dp array with amount+1 because we want to find the minimum number of coins, and the maximum number of coins we can use is amount (if we use all coins of denomination 1), so we can initialize the dp array with amount+1 to represent an impossible case where we cannot make the change with the given coins.
        dp[0]=0; // base case, if amount is 0, then we need 0 coins to make the change
        for(int i=1;i<=amount;i++){ //
            for(int coin : coins){
                if(i>=coin) // we can only use the coin if the current amount i is greater than or equal to the coin denomination, otherwise we cannot use that coin to make the change for the current amount.
                    dp[i] = Math.min(dp[i], dp[i-coin]+1); // we are taking the minimum of the current value in dp[i] and the value of dp[i-coin] + 1 because if we use the coin, we need to add 1 to the number of coins needed to make the change for the amount i-coin, and we want to find the minimum number of coins needed to make the change for the amount i, so we take the minimum of these two values.
            }
        }

        return dp[amount] > amount ? -1 : dp[amount]; // if the value in dp[amount] is greater than amount, it means we cannot make the change with the given coins, so we return -1, otherwise we return the value in dp[amount] which represents the minimum number of coins needed to make the change for the amount.
    }

    // String Compression
    public static String compress(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int count = 1;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                sb.append(s.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        sb.append(s.charAt(s.length() - 1)).append(count); // we need to append the last character and its count after the loop because the loop only appends the character and count when it encounters a different character, so we need to append the last character and its count after the loop to account for the last sequence of characters in the string.

        return sb.toString();
    }

    // Add two fractions
    public static int[] addFractions(
            int a, int b,
            int c, int d) {

        int numerator =
                a * d + b * c;

        int denominator =
                b * d;

        int gcd = gcd(numerator, denominator);

        return new int[]{
                numerator / gcd,
                denominator / gcd
        };
    }

    private static int gcd(int a, int b) {

        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    // Trapping rain water
    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0]; // we are filling the leftMax array from left to right, so we need to initialize the first element of the leftMax array with the value of the first element of the height array because there is no element to the left of the first element, so the maximum height to the left of the first element is just the height of the first element itself.
        rightMax[n - 1] = height[n - 1]; // we are filling the rightMax array from right to left, so we need to initialize the last element of the rightMax array with the value of the last element of the height array because there is no element to the right of the last element, so the maximum height to the right of the last element is just the height of the last element itself.

        for (int i = 1; i < n; i++) // we are filling the leftMax array from left to right, so we need to start from the second element and move towards the last element, and we are comparing the current value in the leftMax array with the current height to get the maximum height to the left of the current index, which will help us calculate the amount of water that can be trapped at that index.
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        for (int i = n - 2; i >= 0; i--) // we are filling the rightMax array from right to left, so we need to start from the second last element and move towards the first element, and we are comparing the current value in the rightMax array with the current height to get the maximum height to the right of the current index, which will help us calculate the amount of water that can be trapped at that index.
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);

        int totalWater = 0;
        for (int i = 0; i < n; i++)
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i]; // Formula to calculate the amount of water that can be trapped at index i is min(leftMax[i], rightMax[i]) - height[i], because the water level at index i can only be as high as the minimum of the maximum height to the left and the maximum height to the right, and we need to subtract the height at index i from this minimum value to get the actual amount of water that can be trapped at that index.

        return totalWater;
    }

    // knapsack problem Pattern
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

    // Most frequent IP address
    public static String mostFrequentIP(List<String> logs) {
        Map<String,Integer> map = new HashMap<>();
        String answer = "";
        int max = 0;

        for (String line : logs) {
            String ip = line.split(" ")[0]; // we are splitting the log line by space and taking the first part which is the IP address, because the log line is in the format "IP_ADDRESS TIMESTAMP", so the IP address is always the first part of the log line.
            int freq = map.getOrDefault(ip,0) + 1; // we are getting the current frequency of the IP address from the map, if it does not exist in the map we are using getOrDefault to return 0, and then we are adding 1 to it because we have encountered this IP address one more time in the logs.
            map.put(ip,freq);

            if (freq > max) {
                max = freq;
                answer = ip;
            }
        }

        return answer;
    }

    // Minimum in rotated sorted array
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) // if the middle element is greater than the rightmost element, it means the minimum element is in the right half of the array, so we move the left pointer to mid + 1 to search in the right half.
                left = mid + 1;
            else
                right = mid; // if the middle element is less than or equal to the rightmost element, it means the minimum element is in the left half of the array (including mid), so we move the right pointer to mid to search in the left half.

        }

        return nums[left];
    }

    // First Non Repeating Character in a String

    public static char firstNonRepeating(String s) {
        Map<Character,Integer> freq = new HashMap<>();
        for (char ch : s.toCharArray()) {

            freq.put(ch, freq.getOrDefault(ch,0)+ 1);
        }

        for (char ch : s.toCharArray()) {
            if (freq.get(ch) == 1) {
                return ch;
            }
        }
        return '0';
    }

    // Container with most water

    public int maxArea(int[] height) {
            int left = 0;
            int right = height.length - 1;
            int maxArea = 0;

            while (left < right) {
                int width = right - left;
                int minHeight = Math.min(height[left], height[right]);
                int area = width * minHeight;

                maxArea = Math.max(maxArea, area);

                if (height[left] < height[right]) {
                    left++;
                } else {
                    right--;
                }
            }
            return maxArea;
    }

    // Koko Eating Bananas
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            int right = 0;
            for (int pile : piles)
                right = Math.max(right, pile);
            int ans = right;

            while (left<=right){
                int mid = left + (right - left)/2;
                if(canEat(piles, h, mid)){
                    ans = mid;
                    right = mid - 1;
                }
                else
                    left = mid + 1;
            }
            return ans;
        }
        public boolean canEat(int[] piles, int h, int speed){
            long hours = 0;
            for (int p : piles){
                hours = hours + p/speed; // we are calculating the total hours needed to eat all the bananas at the given speed, by dividing the number of bananas in each pile by the speed, and adding it to the total hours. We are using long data type for hours because the total hours can be very large and can exceed the range of int data type.
                if(p%speed !=0)
                    hours ++;
            }
            return hours <= h;
        }



        // Number of Islands
        public int numIslands(char[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int noOfIslands = 0;

            // directions array to explore the four possible directions (up, down, left, right) from the current cell
            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

            for(int i = 0; i < rows; i++){
                for(int j = 0; j < cols; j++){

                    if(grid[i][j] == '1'){
                        noOfIslands++;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.offer(new int[]{i,j});
                        // Mark the current cell as visited by changing it to '0' so that we don't count it again when we encounter it in the future.
                        grid[i][j] = '0'; // mark as visited

                        // This is BFS exploration starting from the current cell, we keep adding the neighboring cells that are '1' to the queue and marking them as '0' until the queue is empty. This way we are marking all the connected '1's as '0' and counting them as one island.
                        while(!queue.isEmpty()){
                            int[] cell = queue.poll();
                            for(int[] dir : dirs){
                                // Get the neighboring cell by adding the direction to the current cell's coordinates
                                int nr = cell[0] + dir[0];
                                int nc = cell[1] + dir[1];

                                // Check if the neighboring cell is out of bounds or if it is not land ('1'), then we skip it
                                if(nr < 0 || nc < 0 || nr >= rows || nc >= cols)
                                    continue;
                                if(grid[nr][nc] != '1')
                                    continue;

                                // If the neighboring cell is land ('1'), we mark it as visited by changing it to '0' and add it to the queue to continue the BFS traversal
                                grid[nr][nc] = '0';
                                queue.offer(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }

            return noOfIslands;
        }


        // dfs approach for number of islands

        int numIslandsdfs(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return 0;
            }
            int count = 0;

            for (int i = 0; i < grid.length; i++)
                for (int j = 0; j < grid[0].length; j++)
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }

            return count;
        }

        private void dfs(char[][] grid, int i, int j) {
            if (i < 0 || i >= grid.length
                    || j < 0 || j >= grid[0].length
                    || grid[i][j] == '0') {
                return;
            }

            grid[i][j] = '0'; // Mark the cell as visited

            // Explore all four directions
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }




        // Median of two sorted arrays

            public double findMedianSortedArrays(int[] nums1, int[] nums2) {
                // so i have to merge the two sorted arrays
                int m = nums1.length, n = nums2.length;
                int i = 0, j = 0;
                int k = 0;
                int[] temp = new int[m+n];

                while(i < m && j < n) {
                    if(nums1[i] < nums2[j])
                        temp[k++] = nums1[i++];
                    else
                        temp[k++] = nums2[j++];
                }

                while(i < m) {
                    temp[k++] = nums1[i++];
                }
                while(j < n) {
                    temp[k++] = nums2[j++];
                }

                int size = temp.length;

                if(size % 2 != 0)  // odd length
                    return temp[size/2];

                if(size % 2 == 0) // even length
                    return (temp[size/2] + temp[size/2 - 1])/2.0;

                return 0;
            }


            // square root
            public static double sqrt(int n) {
                double low = 0;
                double high = n;
                while (high - low > 0.001) {
                    double mid = (low + high) / 2;

                    if (mid * mid < n) {
                        low = mid;
                    } else {
                        high = mid;
                    }
                }
                return low;
            }


            // Minimum size subarray sum

                public int minSubArrayLen(int target, int[] nums) {
                    int minLen = Integer.MAX_VALUE, sum = 0;
                    int i = 0;
                    for(int j = 0; j < nums.length; j++) {
                        // Calculate the sum
                        sum = sum + nums[j];

                        // check if the sum in the window is greater than or equal to target, shrink the window
                        while(sum >= target) {
                            minLen = Math.min(minLen, j-i+1);
                            sum = sum - nums[i];
                            i++;
                        }
                    }

                    return minLen == Integer.MAX_VALUE ? 0 : minLen;
                }


                // Fraction to Recurring Decimal

        public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) return "0"; // zero top → zero
            StringBuilder res = new StringBuilder();
            if ((numerator < 0) ^ (denominator < 0)) res.append("-");

            long num = Math.abs((long)numerator), den = Math.abs((long)denominator);
            res.append(num / den);
            long rem = num % den;
            if (rem == 0) return res.toString();

            res.append(".");
            Map<Long, Integer> seen = new HashMap<>();

            while (rem != 0) {
                if (seen.containsKey(rem)) {
                    res.insert(seen.get(rem), "(");
                    res.append(")");
                    break;
                }
                seen.put(rem, res.length());
                rem *= 10;
                res.append(rem / den);
                rem %= den;
            }
            return res.toString();
        }




}
