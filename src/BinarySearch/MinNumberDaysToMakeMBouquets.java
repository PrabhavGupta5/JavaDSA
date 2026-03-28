package BinarySearch;

// https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
// https://www.youtube.com/watch?v=erWfh_hBF80
// In this question we are applying binary search on answer space and not on the input array. We are trying to find the minimum number of days that can make "m" bouquets with "k" adjacent flowers. The minimum number of days can be the minimum bloom day and the maximum number of days can be the maximum bloom day. We will apply binary search on this range and check if we can make "m" bouquets with "k" adjacent flowers in "mid" days. If we can, we will try to find a smaller number of days, otherwise we will try to find a larger number of days. Finally, we will return the minimum number of days that can make "m" bouquets with "k" adjacent flowers.
public class MinNumberDaysToMakeMBouquets {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for(int i : bloomDay) {
            left = Math.min(left, i);
            right = Math.max(right, i);
        }

        if(m * k > n)
            return -1;
        int minDays = -1;

        while(left <= right) {
            int mid = left  + (right - left) / 2;
            if(canMakeBouquets(bloomDay, m, k, mid)) {
                minDays = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return minDays;
    }

    public boolean canMakeBouquets(int[] bloomDay, int m, int k, int midDays) {
        int bouquetsCount = 0;
        int flowersCount = 0;

        for(int i= 0; i < bloomDay.length; i++) {

            if(bloomDay[i] <= midDays) {
                flowersCount++;

                if(flowersCount == k) {
                    bouquetsCount++;
                    flowersCount = 0;
                }

            } else {
                flowersCount = 0;
            }

        }
        return bouquetsCount >= m;
    }
}
