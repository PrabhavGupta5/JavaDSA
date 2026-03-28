package BinarySearch;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
// In this question we are applying binary search on answer space and not on the input array. We are trying to find the minimum capacity of the ship that can ship all packages within "days" days. The minimum capacity can be the maximum weight of a single package and the maximum capacity can be the sum of all weights (if we ship all packages in one day). We will apply binary search on this range and check if we can ship all packages within "days" days with the current mid capacity. If we can, we will try to find a smaller capacity, otherwise we will try to find a larger capacity. Finally, we will return the minimum capacity that can ship all packages within "days" days.
// https://www.youtube.com/watch?v=f2qf4u_O2QE
public class CapacityToShipPackages {
    public int shipWithinDays(int[] weights, int days) {
        int minCap = 0;
        int maxCap = 0;
        for (int weight : weights) {
            minCap = Math.max(minCap, weight);
            maxCap += weight;
        }

        // Apply binary search
        while (minCap < maxCap) {
            int midDay = minCap + (maxCap - minCap) / 2;

            // Try to ship with "midDay" capacity
            int daysNeed = 1;
            int sum = 0;
            for (int weight : weights) {
                if (sum + weight > midDay) { // If adding the current weight exceeds the midDay capacity, we need an extra day
                    daysNeed++;
                    sum = 0;
                }
                sum += weight; // Add the current weight to the sum for the current day
            }

            // If more days are required, increase capacity
            if (daysNeed > days)
                minCap = midDay + 1;
            else
                maxCap = midDay;
        }

        return minCap; // We are returning minCap because it is the smallest capacity that can ship within "days"
    }
}
