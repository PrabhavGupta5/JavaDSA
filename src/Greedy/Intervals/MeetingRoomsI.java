package Greedy.Intervals;
import java.util.*;

public class MeetingRoomsI {
    public class Interval {
      public int start, end;
      public Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
    }

    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for(int i = 0; i < intervals.size() - 1; i++) {
            Interval curr = intervals.get(i);
            Interval next = intervals.get(i+1);

            int currEnd = curr.end;
            int nextStart = next.start;

            if(currEnd > nextStart)
                return false;

        }
        return true;
    }


    public boolean canAttendMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        for(int i = 0; i < intervals.length - 1; i++) {
            int[] currInterval = intervals[i];
            int[] nextInterval = intervals[i+1];

            if(currInterval[1] > nextInterval[0])
                return false;
        }

        return true;
    }

    // Merge Intervals:
    //    overlap if start <= previousEnd
    //
    // Meeting Rooms:
    //    conflict if start < previousEnd
    //    (implemented as previousEnd > start)
    //
    // Non-overlapping Intervals:
    //    overlap if start < previousEnd
}
