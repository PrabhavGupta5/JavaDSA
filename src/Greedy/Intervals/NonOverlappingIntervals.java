package Greedy.Intervals;

import java.util.Arrays;
import java.util.Comparator;

// https://leetcode.com/problems/non-overlapping-intervals/description/
// https://www.youtube.com/watch?v=XsrJgwGlRoc&t=10s
public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0)
            return 0;

        // Sort the intervals based on the end time
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));

        int count = 1;

        // end time of the first/current interval
        int previous_interval = 0;

        for (int i = 1; i < intervals.length; i++) {

            // If the start time of the next interval is greater than or equal to
            // the end time of the current interval, then we can keep it
            if (intervals[i][0] >= intervals[previous_interval][1]) {
                previous_interval = i;
                count++;
            }
        }

        // Return the number of intervals to remove
        return intervals.length - count;
    }
}

// 1. Sort intervals by end time as Greedy choice is to always pick the interval that ends first, because it leaves more room for the remaining intervals to fit in without overlapping.
// 2. Initialize count of non-overlapping intervals to 1 (the first interval is always included).
// 3. Iterate through the sorted intervals and compare the start time of the current interval with the end time of the last included interval. If they do not overlap, include the current interval and update the last included interval. If they do overlap, skip the current interval.
// 4. Finally, return the total number of intervals minus the count of non-overlapping intervals to get the number of intervals that need to be removed.

