package Intervals;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/insert-interval/description/
// https://www.youtube.com/watch?v=wCBtjZxw1xY
public class InsertIntervals {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n= intervals.length;
        List<int[]> list=new ArrayList<>();
        int i=0;
        //left part
        while(i<n && intervals[i][1]< newInterval[0]){
            list.add(intervals[i]);
            i++;
        }
        //overlapping
        while(i<n && intervals[i][0]<= newInterval[1]){ // overlapping condition is a[i][0]<=newInterval[1] because if the start of the current interval is less than or equal to the end of the new interval, then they are overlapping
            newInterval[0]=Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]=Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        //new interval
        list.add(newInterval);

        //right part
        while(i<n){
            list.add(intervals[i]);
            i++;
        }
        int[][]ans=new int[list.size()][2];
        for(int j=0;j<list.size();j++){
            ans[j]=list.get(j);
        }
        return ans;
    }
}

// 1. Add all intervals that end before the new interval starts to the result list.
// 2. Merge all overlapping intervals with the new interval by updating the start and end of the new interval.
// 3. Add the merged new interval to the result list.
// 4. Add all remaining intervals that start after the new interval ends to the result list.