package BinarySearch;

public class KokoEatsBanana {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/koko-eating-bananas/description/
    // https://www.youtube.com/watch?v=qyfekrNni90&list=PLgUwDviBIf0pMFMWuuvDNMAkoQFi-h0ZF&index=13
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int left = 1;
            //int right = Arrays.stream(piles).max().getAsInt();
            int right = Integer.MAX_VALUE;
            int ans = right;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (totalHours(piles, h, mid)) {
                    ans = mid;
                    right = mid - 1;
                } else
                    left = mid + 1;
            }
            return ans;
        }

        public boolean totalHours(int[] piles, int h, int mid) {
            long hours = 0;
            for (int p : piles) {
                hours = hours + p / mid;
                if (p % mid != 0)
                    hours++;
            }
            return hours <= h;
        }
    }


    //  This is same question, Find the Smallest Divisor Given a Threshold https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
    //  https://www.youtube.com/watch?v=UvBKTVaG6U8
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            high = Math.max(high, nums[i]);
        }
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (getSum(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    public boolean getSum(int[] nums, int mid, int threshold) {
        // Here we have to get the sum of the nums array by mid and compare by threshold
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % mid == 0)
                sum = sum + nums[i] / mid;
            else
                sum = sum + nums[i] / mid + 1;
        }
        if (sum <= threshold)
            return true;

        return false;
    }




    // This is also same
    // https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1;
        int high = 0;

        for (int q : quantities) {
            high = Math.max(high, q);
        }

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canDistribute(quantities, mid, n)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    public boolean canDistribute(int[] quantities, int maxPerStore, int n) {
        // here mid = maxPerStore, we have to check if we can distribute the products in n stores with maxPerStore products in each store
        int stores = 0;

        for (int q : quantities) {
            if(q % maxPerStore == 0)
                stores += q / maxPerStore;
            else
                stores += q / maxPerStore + 1;
        }

        return stores <= n;
    }
}
