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
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int count = 1; //

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



    // Greedy criteria, keep the shorter interval
    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = intervals.length;
        int count = 0;
        int[] last = intervals[0];

        for (int i = 1; i < n; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            int lastEnd = last[1];

            if (currStart >= lastEnd) {
                // No overlap, skip current interval
                last = intervals[i];
            }

            else if (currEnd >= lastEnd) { // example: last = [1,2], current = [1,3] → overlap → remove current → count = 1
                // Current interval ends later, remove current
                // overlap, remove current interval
                count++;
            }

            else if(currEnd < lastEnd) { // example: last = [1,4], current = [2,3] → overlap → remove previous → count = 1
                // Current interval ends earlier
                // overlap, remove previous interval
                last = intervals[i];
                count++;
            }
        }
        return count;

    }
    // example: [[1,2],[2,3],[3,4],[1,3]] → [[1,2],[2,3],[3,4]] → 1 interval removed
    // first step: sort intervals by start time → [[1,2],[1,3],[2,3],[3,4]]
    // second step: iterate through the intervals and check for overlap
    // last = [1,2], current = [1,3] → overlap → remove current → count = 1

}

// 1. Sort intervals by end time as Greedy choice is to always pick the interval that ends first, because it leaves more room for the remaining intervals to fit in without overlapping.
// 2. Initialize count of non-overlapping intervals to 1 (the first interval is always included).
// 3. Iterate through the sorted intervals and compare the start time of the current interval with the end time of the last included interval. If they do not overlap, include the current interval and update the last included interval. If they do overlap, skip the current interval.
// 4. Finally, return the total number of intervals minus the count of non-overlapping intervals to get the number of intervals that need to be removed.

